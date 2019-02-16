package test.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.entities.Employee;

public interface EmplService {
    public Integer saveEmployee(String name, Integer orgId, Integer bossId);
    public Page<Employee> getAllEmployees(Pageable pageable);
    public Integer updateEmployeeById(Integer id, String name, Integer orgId, Integer bossId);
    public Integer deleteEmployeeById(Integer id);
}
