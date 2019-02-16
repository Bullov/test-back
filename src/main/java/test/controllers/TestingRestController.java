package test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import test.Service.EmplService;
import test.Service.OrgService;
import test.entities.Employee;
import test.entities.Organization;

import java.util.Map;


@RestController
public class TestingRestController {
    @Autowired
    OrgService orgService;

    @Autowired
    EmplService emplService;

    // ------------ Organizations ------------------
    @RequestMapping(method = RequestMethod.GET, path = "/orgs")
    public Page<Organization> getOrganizationsList(@PageableDefault Pageable pageable){
        return orgService.getAllOrgsWithEmployeesNumber(pageable);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/orgs")
    public Integer addOrganization(@RequestBody Map<String,String> body){
        return orgService.saveOrg(body.get("name"),Integer.parseInt("0"+body.get("parentId")));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/orgs/{id}")
    public Integer deleteOrganization(@PathVariable(value = "id") Integer id){
        return orgService.deleteOrgById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/orgs/{id}")
    public Integer updateOrganization(@PathVariable(value = "id") Integer id,
                                      @RequestBody Map<String,String> body){
        return orgService.updateOrgById(Integer.parseInt(body.get("id")),
                                        body.get("name"),Integer.parseInt("0" + body.get("parentId")));
    }

    // ------------ Employees ------------------
    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public Page<Employee> getEmployeesList(@PageableDefault Pageable pageable){
        return emplService.getAllEmployees(pageable);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/employees")
    public Integer addEmployee(@RequestBody Map<String,String> body){
        return emplService.saveEmployee(body.get("name"), Integer.parseInt("0"+body.get("orgId")),
                Integer.parseInt("0"+body.get("bossId")));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/employees/{id}")
    public Integer deleteEmployee(@PathVariable(value = "id") Integer id){
        return emplService.deleteEmployeeById(id);
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/employees/{id}")
    public Integer updateEmployee(@PathVariable(value = "id") Integer id,
                                 @RequestBody Map<String,String> body){
        return emplService.updateEmployeeById(Integer.parseInt(body.get("id")), body.get("name"),
                Integer.parseInt("0"+body.get("orgId")),
                Integer.parseInt("0"+body.get("bossId")));
    }
}