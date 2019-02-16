package test.Dao;

import org.jooq.Record4;
import org.jooq.Record6;
import org.jooq.Result;
import jooqtest.tables.records.EmployeesRecord;

public interface EmplDao {
    public Integer insertNewEmployee(EmployeesRecord employeesRecord);
    public Result<Record6<Integer,String,Integer,Integer,String,String>> getAllEmployees();
    public Integer updateEmployeeById(EmployeesRecord employeesRecord);
    public Integer deleteEmployeeById(Integer id);
    public EmployeesRecord getNewEmployeesRecord();
    public Integer countOfChildEmpl(Integer id);
}
