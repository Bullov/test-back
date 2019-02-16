package test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

public class DataSourceConfig {
    public DataSourceConfig() {
    }

    public static DataSource createDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/test");
        config.setUsername("Anykey");
        config.setPassword("root1");
        config.setAutoCommit(true);
        config.setMaximumPoolSize(20);
        return new HikariDataSource(config);
    }

    public DefaultConfiguration configuration(){
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        return jooqConfiguration;
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider(){
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(createDataSource()));
    }
    @Bean
    public DefaultDSLContext dsl(){
        return new DefaultDSLContext(configuration());
    }

}
