package br.com.visualmix.database.api.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;



@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
@EnableAspectJAutoProxy
@PropertySource("file:/app/config/VM_VisualStore_Adm.conf")
@EnableScheduling
public class ApplicationConfig {
    public final static String CONFIG_PATH = System.getenv("VMIX_HOME");
    public final static String CONFIG_FILE = "config\\VM_VisualStore_Adm.conf";
}
