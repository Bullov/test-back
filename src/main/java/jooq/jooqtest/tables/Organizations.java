/*
 * This file is generated by jOOQ.
 */
package jooqtest.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooqtest.Indexes;
import jooqtest.Keys;
import jooqtest.Public;
import jooqtest.tables.records.OrganizationsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Organizations extends TableImpl<OrganizationsRecord> {

    private static final long serialVersionUID = 1171057989;

    /**
     * The reference instance of <code>public.organizations</code>
     */
    public static final Organizations ORGANIZATIONS = new Organizations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrganizationsRecord> getRecordType() {
        return OrganizationsRecord.class;
    }

    /**
     * The column <code>public.organizations.id</code>.
     */
    public final TableField<OrganizationsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('\"Organizations_id_seq\"'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.organizations.name</code>.
     */
    public final TableField<OrganizationsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>public.organizations.parent_id</code>.
     */
    public final TableField<OrganizationsRecord, Integer> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.organizations</code> table reference
     */
    public Organizations() {
        this(DSL.name("organizations"), null);
    }

    /**
     * Create an aliased <code>public.organizations</code> table reference
     */
    public Organizations(String alias) {
        this(DSL.name(alias), ORGANIZATIONS);
    }

    /**
     * Create an aliased <code>public.organizations</code> table reference
     */
    public Organizations(Name alias) {
        this(alias, ORGANIZATIONS);
    }

    private Organizations(Name alias, Table<OrganizationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Organizations(Name alias, Table<OrganizationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Organizations(Table<O> child, ForeignKey<O, OrganizationsRecord> key) {
        super(child, key, ORGANIZATIONS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ORGANIZATIONS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OrganizationsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORGANIZATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OrganizationsRecord> getPrimaryKey() {
        return Keys.ORGANIZATIONS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OrganizationsRecord>> getKeys() {
        return Arrays.<UniqueKey<OrganizationsRecord>>asList(Keys.ORGANIZATIONS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizations as(String alias) {
        return new Organizations(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organizations as(Name alias) {
        return new Organizations(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizations rename(String name) {
        return new Organizations(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Organizations rename(Name name) {
        return new Organizations(name, null);
    }
}
