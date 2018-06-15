package org.assemblyline;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean("dataSource")
    public DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new SQLServerDriver());
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=assemblylinedb");
        dataSource.setUsername("sa");
        dataSource.setPassword("12345678");

        return dataSource;
    }

    @Bean("jdbcTemplate")
    @Autowired
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
