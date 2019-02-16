package test.entities;

public class Organization {

    private Integer id;
    private String name;
    private Integer parentId;

    private Integer employeesNumber;

    public Organization() {
    }

    public Organization(Integer id, String name, Integer parentId, Integer employeesNumber) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.employeesNumber = employeesNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}

