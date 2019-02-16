package test.Dao;

import jooqtest.tables.Employees;
import jooqtest.tables.Organizations;
import jooqtest.tables.records.OrganizationsRecord;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.jooq.impl.DSL.count;

@Repository
public class OrgDaoImpl implements OrgDao {
    @Autowired
    DSLContext dsl;

    @Override
    public Integer insertNewOrg(OrganizationsRecord organizationsRecord) {
        dsl.insertInto(Organizations.ORGANIZATIONS)
                .columns(Organizations.ORGANIZATIONS.NAME, Organizations.ORGANIZATIONS.PARENT_ID)
                .values(organizationsRecord.getName(),organizationsRecord.getParentId())
                .execute();
        return 0;
    }

    @Override
    public Result<Record4<Integer, String, Integer, Integer>> getAllOrgsWithEmployeesNumber() {
        return dsl.select(Organizations.ORGANIZATIONS.ID,Organizations.ORGANIZATIONS.NAME,
                Organizations.ORGANIZATIONS.PARENT_ID, count(Employees.EMPLOYEES.ID))
                             .from(Organizations.ORGANIZATIONS).leftJoin(Employees.EMPLOYEES)
                             .on(Organizations.ORGANIZATIONS.ID.eq(Employees.EMPLOYEES.ORG_ID))
                             .groupBy(Organizations.ORGANIZATIONS.ID).orderBy(Organizations.ORGANIZATIONS.ID)
                             .fetch();
    }

    @Override
    public OrganizationsRecord getOrgById(Integer id) {
        return dsl.selectFrom(Organizations.ORGANIZATIONS).where(Organizations.ORGANIZATIONS.ID.eq(id)).fetchAny();
    }

    @Override
    public Integer updateOrgById(OrganizationsRecord organizationsRecord) {
        dsl.update(Organizations.ORGANIZATIONS)
                .set(Organizations.ORGANIZATIONS.NAME, organizationsRecord.getName())
                .set(Organizations.ORGANIZATIONS.PARENT_ID, organizationsRecord.getParentId())
                .where(Organizations.ORGANIZATIONS.ID.eq(organizationsRecord.getId())).execute();
        return organizationsRecord.getId();
    }

    @Override
    public Integer deleteOrgById(Integer id) {
        dsl.deleteFrom(Organizations.ORGANIZATIONS).where(Organizations.ORGANIZATIONS.ID.eq(id)).execute();
        return id;
    }

    @Override
    public OrganizationsRecord getNewOrganizationsRecord() {
        return dsl.newRecord(Organizations.ORGANIZATIONS);
    }

    @Override
    public Integer countOfChildOrg(Integer id) {
        return dsl.selectCount().from(Organizations.ORGANIZATIONS).where(Organizations.ORGANIZATIONS.PARENT_ID.eq(id)).fetchAny().value1();
    }
}
