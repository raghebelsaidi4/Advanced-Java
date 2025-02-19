package com.ragheb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericMapper<T> {

    T rowMapper(ResultSet resultSet) throws SQLException;
}
