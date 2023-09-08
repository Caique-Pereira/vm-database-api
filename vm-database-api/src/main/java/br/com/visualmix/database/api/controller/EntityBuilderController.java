package br.com.visualmix.database.api.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.visualmix.entity.builder.AppInit;

@Controller
@RequestMapping("api/build_entity")
public class EntityBuilderController {

	
	@Autowired
	DataSource dataSource;
	Connection connection;
	
	AppInit app = new AppInit();
	
	@GetMapping("/teste")
	public String generateEntity() throws SQLException {
		connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		return  app.execute(metaData);
	}
	
	
	
	
}
