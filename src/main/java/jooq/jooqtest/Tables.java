/*
 * This file is generated by jOOQ.
 */
package jooqtest;


import javax.annotation.Generated;

import jooqtest.tables.Employees;
import jooqtest.tables.Organizations;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.employees</code>.
     */
    public static final Employees EMPLOYEES = jooqtest.tables.Employees.EMPLOYEES;

    /**
     * The table <code>public.organizations</code>.
     */
    public static final Organizations ORGANIZATIONS = jooqtest.tables.Organizations.ORGANIZATIONS;
}
