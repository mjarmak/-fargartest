package com.jarmak.fargartest;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TomcatConfiguration {

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatWebServer(tomcat);
            }

            @Override
            protected void postProcessContext(Context context) {
                System.out.println("Tomcat config runs");

                // context
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/myJndiResource");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "org.postgresql.Driver");

                resource.setProperty("url", "jdbc:postgresql://hostname:port/dbname");
                resource.setProperty("username", "username");
                resource.setProperty("password", "password");
                context.getNamingResources()
                        .addResource(resource);
            }
        };
    }

}
