package br.com.visualmix.database.api.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.visualmix.database.api.config.ApplicationConfig;

@Component
public class Funcoes {

	@Autowired
	ApplicationConfig appConf;
	static Properties props;
	static {
		try {                                      
			props = new Properties();
			FileInputStream file = new FileInputStream(Paths.get("/app","config", "VM_VisualStore_Adm.conf").toFile());
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reReadFileConf() {
		try {
			props = new Properties();
			FileInputStream file = new FileInputStream(Paths.get("/app","config", "VM_VisualStore_Adm.conf").toFile());
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
