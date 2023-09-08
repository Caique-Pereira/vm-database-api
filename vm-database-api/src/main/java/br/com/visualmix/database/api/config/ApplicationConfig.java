package br.com.visualmix.database.api.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
@EnableAspectJAutoProxy
public class ApplicationConfig {



    public final static String CONFIG_PATH = System.getenv("VMIX_HOME");
    public final static String CONFIG_FILE = "config\\VM_VisualStore_Adm.conf";
}
