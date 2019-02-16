package test.Dao;

import jooqtest.tables.Employees;
import jooqtest.tables.Organizations;
import jooqtest.tables.records.EmployeesRecord;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.entities.Employee;

@Repository
public class EmplDaoImpl implements EmplDao {
    @Autowired
    DSLContext dsl;

    @Override
    public Integer insertNewEmployee(EmployeesRecord employeesRecord) {
        dsl.insertInto(Employees.EMPLOYEES)
                .columns(Employees.EMPLOYEES.NAME, Employees.EMPLOYEES.ORG_ID, Employees.EMPLOYEES.BOSS_ID)
                .values(employeesRecord.getName(), employeesRecord.getOrgId(), employeesRecord.getBossId()).execute();
        return 0;
    }

    @Override
    public Result<Record6<Integer,String,Integer,Integer,String,String>> getAllEmployees() {
        Employees e = Employees.EMPLOYEES.as("e");
        Employees e2 = Employees.EMPLOYEES.as("e2");
        Organizations o = Organizations.ORGANIZATIONS.as("o");

        return dsl.select(e.ID, e.NAME, e.ORG_ID, e.BOSS_ID, o.NAME, e2.NAME)
                .from(e).leftJoin(o)
                .on(e.ORG_ID.eq(o.ID))
                .leftJoin(e2).on(e.BOSS_ID.eq(e2.ID)).fetch();
    }

    @Override
    public Integer updateEmployeeById(EmployeesRecord employeesRecord) {
        dsl.update(Employees.EMPLOYEES)
                .set(Employees.EMPLOYEES.NAME, employeesRecord.getName())
                .set(Employees.EMPLOYEES.ORG_ID, employeesRecord.getOrgId())
                .set(Employees.EMPLOYEES.BOSS_ID, employeesRecord.getBossId())
                .where(Employees.EMPLOYEES.ID.eq(employeesRecord.getId())).execute();
        return employeesRecord.getId();
    }

    @Override
    public Integer deleteEmployeeById(Integer id) {
        dsl.deleteFrom(Employees.EMPLOYEES).where(Employees.EMPLOYEES.ID.eq(id)).execute();
        return id;
    }

    @Override
    public EmployeesRecord getNewEmployeesRecord() {
        return dsl.newRecord(Employees.EMPLOYEES);
    }

    @Override
    public Integer countOfChildEmpl(Integer id) {
        return dsl.selectCount().from(Employees.EMPLOYEES).where(Employees.EMPLOYEES.BOSS_ID.eq(id)).fetchAny().value1();
    }
}
