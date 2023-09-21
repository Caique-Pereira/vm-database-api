package br.com.visualmix.database.api.manager.health;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.Health;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class EstatisticaDataBaseHealthCheck {
	
	@Autowired
	@Qualifier("EstatisticaDataSource")
	DataSource dataSource;
	
	@Autowired
	@Qualifier("EstatisticaJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	public boolean isDatabaseOffline = false;

    
    public Health checkHealth() {
        try (Connection connection = dataSource.getConnection()) {
             isDatabaseOffline = "H2".equalsIgnoreCase(connection.getMetaData().getDatabaseProductName());

            if (connection.isValid(1000) && !isDatabaseOffline) {
                return Health.up()
                        .withDetail("Database Name", "Estatistica Database")
                        .withDetail("Status", "Up and Running")
                        .withDetail("Last Checked", LocalDateTime.now())
                        .build();
            } else {
                return Health.down()
                        .withDetail("Status", "Connection is not valid or database is offline")
                        .build();
            }
        } catch (SQLException e) {
            return Health.down()
                    .withDetail("Status", "Error while checking database connection")
                    .withDetail("Error Message", e.getMessage())
                    .build();
        }
    }
}