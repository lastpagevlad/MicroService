package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException{
        User user = new User();
        user.setId(resultSet.getInt("users_id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setBus_id(resultSet.getInt("bus_id"));
        return user;
    }
}
