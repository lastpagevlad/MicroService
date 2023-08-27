package org.example.dao;

import org.example.model.Bus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusMapper implements RowMapper
{
    @Override
    public Bus mapRow(ResultSet resultSet, int i) throws SQLException {
        Bus bus = new Bus();
        bus.setBus_id(resultSet.getInt("bus_id"));
        bus.setUsers_id(resultSet.getInt("users_id"));
        bus.setMailing_id(resultSet.getInt("mailing_id"));
        return bus;
    }
}
