package test.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import test.entities.Organization;

public interface OrgService {
    public Integer saveOrg(String name, Integer parentId);
    public Page<Organization> getAllOrgsWithEmployeesNumber(Pageable pageable);
    public jooqtest.tables.records.OrganizationsRecord getOrgById(Integer id);
    public Integer updateOrgById(Integer id, String name, Integer parentId);
    public Integer deleteOrgById(Integer id);

}
