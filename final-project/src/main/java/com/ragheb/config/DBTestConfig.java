package com.ragheb.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBTestConfig {

    public static final Logger LOGGER = LogManager.getLogger();

    public Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            LOGGER.error("Failed to get connection from datasource", e);
            throw new RuntimeException("Unable to connect to the database. Please check your configuration. Check logs for more details.  Hint: Ensure your postgres server is running and accessible.  " +
                    "Ensure you have proper database credentials in your application");
        }
        //return null;
    }

    private DataSource getDataSource(){
        DataSource dataSource = null;
        EmbeddedPostgres postgres = null;
        try {
            postgres = EmbeddedPostgres.builder().start();
            dataSource = postgres.getPostgresDatabase();
        }catch (IOException e){
            LOGGER.error("Failed to start embedded postgres", e);
        }
        Flyway flyway = getFlyway(dataSource);
        flyway.clean();
        flyway.migrate();
        return dataSource;
    }

    private Flyway getFlyway(DataSource dataSource){
        FluentConfiguration configuration = Flyway.configure()
               .dataSource(dataSource);
        return new Flyway(configuration);
    }
}
