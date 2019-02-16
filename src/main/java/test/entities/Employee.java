package test.entities;

public class Employee{

    private Integer id;
    private String name;
    private Integer orgId;
    private Integer bossId;

    private String orgName;
    private String bossName;

    public Employee(Integer id, String name, Integer orgId, Integer bossId, String orgName, String bossName) {
        this.id = id;
        this.name = name;
        this.orgId = orgId;
        this.bossId = bossId;
        this.orgName = orgName;
        this.bossName = bossName;
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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getBossId() {
        return bossId;
    }

    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }
}
