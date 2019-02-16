/*
 * This file is generated by jOOQ.
 */
package jooqtest;


import javax.annotation.Generated;

import jooqtest.tables.Employees;
import jooqtest.tables.Organizations;
import jooqtest.tables.records.EmployeesRecord;
import jooqtest.tables.records.OrganizationsRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<EmployeesRecord, Integer> IDENTITY_EMPLOYEES = Identities0.IDENTITY_EMPLOYEES;
    public static final Identity<OrganizationsRecord, Integer> IDENTITY_ORGANIZATIONS = Identities0.IDENTITY_ORGANIZATIONS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<EmployeesRecord> EMPLOYEES_PKEY = UniqueKeys0.EMPLOYEES_PKEY;
    public static final UniqueKey<OrganizationsRecord> ORGANIZATIONS_PKEY = UniqueKeys0.ORGANIZATIONS_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<EmployeesRecord, OrganizationsRecord> EMPLOYEES__ORGID = ForeignKeys0.EMPLOYEES__ORGID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<EmployeesRecord, Integer> IDENTITY_EMPLOYEES = Internal.createIdentity(Employees.EMPLOYEES, Employees.EMPLOYEES.ID);
        public static Identity<OrganizationsRecord, Integer> IDENTITY_ORGANIZATIONS = Internal.createIdentity(Organizations.ORGANIZATIONS, Organizations.ORGANIZATIONS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<EmployeesRecord> EMPLOYEES_PKEY = Internal.createUniqueKey(Employees.EMPLOYEES, "Employees_pkey", Employees.EMPLOYEES.ID);
        public static final UniqueKey<OrganizationsRecord> ORGANIZATIONS_PKEY = Internal.createUniqueKey(Organizations.ORGANIZATIONS, "Organizations_pkey", Organizations.ORGANIZATIONS.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<EmployeesRecord, OrganizationsRecord> EMPLOYEES__ORGID = Internal.createForeignKey(jooqtest.Keys.ORGANIZATIONS_PKEY, Employees.EMPLOYEES, "employees__orgId", Employees.EMPLOYEES.ORG_ID);
    }
}
