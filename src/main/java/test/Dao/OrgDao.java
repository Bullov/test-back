package test.Dao;

import jooqtest.tables.records.OrganizationsRecord;
import org.jooq.Record4;
import org.jooq.Result;

public interface OrgDao {
    public Integer insertNewOrg(OrganizationsRecord organizationsRecord);
    public Result<Record4<Integer, String, Integer, Integer>> getAllOrgsWithEmployeesNumber();
    public OrganizationsRecord getOrgById(Integer id);
    public Integer updateOrgById(OrganizationsRecord organizationsRecord);
    public Integer deleteOrgById(Integer id);
    public OrganizationsRecord getNewOrganizationsRecord();
    public Integer countOfChildOrg(Integer id);
}
