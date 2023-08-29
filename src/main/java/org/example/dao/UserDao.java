package org.example.dao;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> index(){
        return jdbcTemplate.query("select * from users", new UserMapper());
    }

    public void update(int id, User updateUser){
        jdbcTemplate.update("update users set username=?, email=?, bus_id=? where users_id=?", updateUser.getName(), updateUser.getBus_id(), updateUser.getEmail(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from users where users_id=?", id);
    }
}
