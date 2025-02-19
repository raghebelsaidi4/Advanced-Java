package com.ragheb.dao.api;

import com.ragheb.mapper.GenericMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);

    protected Connection connection;

    public AbstractDao() {}

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Executes a query and maps the result to a list of objects.
     *
     * @param query      The SQL query to be executed.
     * @param rowMapper  The mapper to convert each row into an object.
     * @param parameters SQL query parameters.
     * @return A list of mapped objects.
     * @throws DaoException if a database error occurs.
     */
    protected List<T> queryForObjects(String query, GenericMapper<T> rowMapper, String... parameters)
            throws DaoException {
        List<T> items = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = setStatementParameters(statement, parameters).executeQuery()) {

            while (resultSet.next()) {
                items.add(rowMapper.rowMapper(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Error executing query: {}", query, e);
            throw new DaoException("Error executing query: " + query, e);
        }
        return items;
    }

    /**
     * Executes a query and returns a single object.
     *
     * @param query      The SQL query to be executed.
     * @param rowMapper  The mapper to convert a row into an object.
     * @param parameters SQL query parameters.
     * @return A single mapped object or {@code null} if no result is found.
     * @throws DaoException if a database error occurs.
     */
    protected T queryForObject(String query, GenericMapper<T> rowMapper, String... parameters)
            throws DaoException {
        List<T> items = queryForObjects(query, rowMapper, parameters);
        return items.size() == 1 ? items.get(0) : null;
    }

    /**
     * Executes an update query (INSERT, UPDATE, DELETE).
     *
     * @param query      The SQL query to be executed.
     * @param parameters SQL query parameters.
     * @return The number of affected rows.
     * @throws DaoException if a database error occurs.
     */
    protected int executeUpdate(String query, String... parameters) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return setStatementParameters(statement, parameters).executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error executing update: {}", query, e);
            throw new DaoException("Error executing update: " + query, e);
        }
    }

    /**
     * Sets parameters in a PreparedStatement.
     *
     * @param statement  The PreparedStatement to populate.
     * @param parameters The parameters to set.
     * @return The same PreparedStatement instance.
     * @throws SQLException if setting parameters fails.
     */
    private PreparedStatement setStatementParameters(PreparedStatement statement, String... parameters)
            throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }
        return statement;
    }
}
