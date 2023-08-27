package org.example.dao;

import org.example.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper {

    @Override
    public Message mapRow(ResultSet resultSet, int i) throws SQLException{
        Message message = new Message();
        message.setBus_id(resultSet.getInt("mailing_id"));
        message.setMailing_message(resultSet.getString("mailing_message"));
        message.setBus_id(resultSet.getInt("bus_id"));
        return message;
    }
}
