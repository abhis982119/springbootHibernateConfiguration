package com.database.basics.orm;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataConfiguration {


    @Value("${spring.datasource.driverClassName}")
    private String dataSourceClassName;


    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUserName;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

        @Value("${spring.dataspource.hibernate.dialect}")
    private String hibernateDialect;



    @Bean(name = "dwEntityManager")
    public LocalContainerEntityManagerFactoryBean dwEntityManagerFactory() {
        try {
            LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            localContainerEntityManagerFactoryBean.setDataSource(dataSource());
            localContainerEntityManagerFactoryBean.setPackagesToScan("com.mettl.authenticator.entities");
            localContainerEntityManagerFactoryBean.setPersistenceUnitName("dw");
            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

            jpaVendorAdapter.setDatabasePlatform(hibernateDialect);
            localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
            localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
            return localContainerEntityManagerFactoryBean;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception is :");
        }
        return new LocalContainerEntityManagerFactoryBean();
    }


    @Bean
    public DataSource dataSource() {

        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(20);
        ds.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        ds.addDataSourceProperty("url", dataSourceUrl);
        ds.addDataSourceProperty("user", dataSourceUserName);
        ds.addDataSourceProperty("password", dataSourcePassword);
        ds.setLeakDetectionThreshold(5000);
        return ds;
    }


    private Properties hibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", hibernateDialect);
        prop.put("hibernate.show_sql", "true");
        return prop;
    }

}
