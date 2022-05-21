package io.swagger.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Config {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceOltpmodbd());

    @Bean
    public DataSource getDataSource(String url) {

//            if(url.contains("oltpmodbd"))
//                return dataSourceOltpmodbd();
            if(url.contains("globalmodbd"))
                return dataSourceGlobalmodbd();
//            if(url.contains("remotele"))
//                return dataSourceRemotele();
//            if(url.contains("remoteda"))
//                return dataSourceRemoteda();
            return  dataSourceOltpmodbd();
    }

    public DataSource dataSourceOltpmodbd() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:oltpmodbd");
        dataSourceBuilder.username("system");
        dataSourceBuilder.password("blueroot");
        return dataSourceBuilder.build();
    }

    public DataSource dataSourceGlobalmodbd() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:globalmodbd");
        dataSourceBuilder.username("global_modbd");
        dataSourceBuilder.password("blue");
        return dataSourceBuilder.build();
    }
//    @Bean(name = "oltpmodbd")
//    @ConfigurationProperties("oltpmodbd.db")
//    @Primary
//    public DataSource dataSourceOltpmodbd(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "globalmodbd")
//    @ConfigurationProperties("globalmodbd.datasource")
//    public DataSource dataSourceGlobalmodbd(){
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "remotele")
//    @ConfigurationProperties("remotele.datasource")
//    public DataSource dataSourceRemotele(){
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "remoteda")
//    @ConfigurationProperties("remoteda.datasource")
//    public DataSource dataSourceRemoteda(){
//        return DataSourceBuilder.create().build();
//    }
//
    @Bean
    public void setRepository(String url) {
        this.jdbcTemplate = new JdbcTemplate(getDataSource(url));
    }

    public JdbcTemplate  getJdbcTemplate() {
        return this.jdbcTemplate;
    }
}
