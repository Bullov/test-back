package test.Service;

import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.Dao.EmplDao;
import test.entities.Employee;
import jooqtest.tables.records.EmployeesRecord;

import java.util.List;

@Service
public class EmplServiceImpl implements EmplService{
    @Autowired
    private EmplDao emplDao;

    @Override
    public Integer saveEmployee(String name, Integer orgId, Integer bossId) {
        EmployeesRecord employeesRecord = new EmployeesRecord();
        employeesRecord.setName(name);
        if (orgId > 0) {
            employeesRecord.setOrgId(orgId);
        } else {
            employeesRecord.setOrgId(null);
        }
        if (bossId > 0) {
            employeesRecord.setBossId(bossId);
        } else {
            employeesRecord.setBossId(null);
        }
        return emplDao.insertNewEmployee(employeesRecord);
    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        Result<Record6<Integer,String,Integer,Integer,String,String>> records = emplDao.getAllEmployees();
        List<Employee> employeeList = records.map(empl -> {
            return new Employee(empl.value1(), empl.value2(), empl.value3(), empl.value4(), empl.value5(), empl.value6());
        });
        return new PageImpl<>(employeeList,pageable,employeeList.size());
    }

    @Override
    public Integer updateEmployeeById(Integer id, String name, Integer orgId, Integer bossId) {
        EmployeesRecord employeesRecord = new EmployeesRecord();
        employeesRecord.setName(name);
        if (orgId > 0) {
            employeesRecord.setOrgId(orgId);
        } else {
            employeesRecord.setOrgId(null);
        }
        if (bossId > 0) {
            employeesRecord.setBossId(bossId);
        } else {
            employeesRecord.setBossId(null);
        }
        employeesRecord.setId(id);
        return emplDao.updateEmployeeById(employeesRecord);
    }

    @Override
    public Integer deleteEmployeeById(Integer id) {
        if (emplDao.countOfChildEmpl(id) == 0){
            return emplDao.deleteEmployeeById(id);
        } else {
            return null;
        }

    }
}
