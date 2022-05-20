package io.swagger.repositories;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Config {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:oltpmodbd");
        dataSourceBuilder.username("oltp_modbd");
        dataSourceBuilder.password("blue");
        return dataSourceBuilder.build();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
