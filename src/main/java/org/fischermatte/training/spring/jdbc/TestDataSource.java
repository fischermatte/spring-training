package org.fischermatte.training.spring.jdbc;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestDataSource {
    public TestDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("");
        ds.setPassword("");
        ds.setUsername("");
        ds.setUrl("");

        DataSourceTransactionManager dm = new DataSourceTransactionManager(ds);
    }
}
