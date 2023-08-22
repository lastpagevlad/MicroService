package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException{
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setTypeMessage(resultSet.getString("typeMessage"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}
