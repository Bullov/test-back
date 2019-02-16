package test.Service;

import jooqtest.tables.records.OrganizationsRecord;
import org.jooq.Record4;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.Dao.OrgDao;
import test.entities.Organization;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgDao orgDao;

    @Override
    public Integer saveOrg(String name, Integer parentId) {
        OrganizationsRecord record = new OrganizationsRecord();
        record.setName(name);
        if (parentId > 0) {
            record.setParentId(parentId);
        } else {
            record.setParentId(null);
        }
        return orgDao.insertNewOrg(record);
    }

    @Override
    public Page<Organization> getAllOrgsWithEmployeesNumber(Pageable pageable) {
        Result<Record4<Integer, String, Integer, Integer>> orgs = orgDao.getAllOrgsWithEmployeesNumber();
        List<Organization> orgsList = orgs.map(org ->{
            return new Organization(org.value1(), org.value2(), org.value3(), org.value4());
        });
        return new PageImpl<>(orgsList,pageable,orgsList.size());
    }

    @Override
    public OrganizationsRecord getOrgById(Integer id) {
        return orgDao.getOrgById(id);
    }

    @Override
    public Integer updateOrgById(Integer id, String name, Integer parentId) {
        OrganizationsRecord organizationsRecord = orgDao.getNewOrganizationsRecord();
        organizationsRecord.setName(name);
        if (parentId > 0) {
            organizationsRecord.setParentId(parentId);
        } else {
            organizationsRecord.setParentId(null);
        }
        organizationsRecord.setId(id);
        return orgDao.updateOrgById(organizationsRecord);
    }

    @Override
    public Integer deleteOrgById(Integer id) {
        if (orgDao.countOfChildOrg(id) == 0){
            return orgDao.deleteOrgById(id);
        } else {
            return null;
        }
    }
}
