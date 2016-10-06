package org.fischermatte.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Storage {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Storage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    private void onPostConstruct() {
        jdbcTemplate.execute("create table employee (id int, name varchar)");
        jdbcTemplate.execute("insert into employee (id, name) values (1, 'A')");
        jdbcTemplate.execute("insert into employee (id, name) values (2, 'B')");
        jdbcTemplate.execute("insert into employee (id, name) values (3, 'C')");
        jdbcTemplate.execute("insert into employee (id, name) values (4, 'D')");
        jdbcTemplate.execute("insert into employee (id, name) values (5, 'E')");
        jdbcTemplate.execute("insert into employee (id, name) values (6, 'F')");

        // row mapper
        List<String> names = jdbcTemplate.query("SELECT * FROM employee", (resultSet, i) -> resultSet.getString("name"));
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
