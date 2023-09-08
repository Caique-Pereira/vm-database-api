package br.com.visualmix.database.api.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.visualmix.database.api.config.ApplicationConfig;
import jakarta.annotation.PostConstruct;

@Component
public class Funcoes {

	@Autowired
	ApplicationConfig appConf;
	static Properties props;

	static {
		try {
			props = new Properties();
			FileInputStream file = new FileInputStream(ApplicationConfig.CONFIG_PATH + ApplicationConfig.CONFIG_FILE);
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getParam(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

	public static String getParam(String key) {
		return props.getProperty(key);
	}
}
