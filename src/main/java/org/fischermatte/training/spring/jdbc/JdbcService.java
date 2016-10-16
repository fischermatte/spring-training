package org.fischermatte.training.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class JdbcService {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;
    private final TransactionTemplate transactionTemplate;

    @Autowired
    public JdbcService(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = transactionManager;
        this.transactionTemplate = transactionTemplate;
    }

    public void doSomeJdbc() {
        jdbcTemplate.execute("create table employee (id int, name varchar)");
//
        transactionTemplate.execute(status -> {
            jdbcTemplate.execute("insert into employee (id, name) values (1, 'A')");
            jdbcTemplate.execute("insert into employee (id, name) values (2, 'B')");
            jdbcTemplate.execute("insert into employee (id, name) values (3, 'C')");
            jdbcTemplate.execute("insert into employee (id, name) values (4, 'D')");
            jdbcTemplate.execute("insert into employee (id, name) values (5, 'E')");
            jdbcTemplate.execute("insert into employee (id, name) values (6, 'F')");
            return null;
        });



        TransactionDefinition transactionDefintion = new DefaultTransactionDefinition(transactionTemplate);
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefintion);
        jdbcTemplate.execute("insert into employee (id, name) values (7, 'H')");
        jdbcTemplate.execute("insert into employee (id, name) values (8, 'I')");
        transactionManager.rollback(transactionStatus);


        // row mapper
        List<String> names = jdbcTemplate.query("SELECT * FROM employee", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("name");
            }
        });
        String firstPerson = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = 1", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return resultSet.getString("name");
            }
        });
        // row callback handler
        jdbcTemplate.query("SELECT * FROM employee", resultSet -> {
            System.out.println("huhu name " + resultSet.getString("name"));
        });
        // resultset extractor
        String nameOfFirstRecord = jdbcTemplate.query("SELECT * FROM employee", resultSet -> {
            resultSet.next();
            return resultSet.getString("name");
        });

    }
}
