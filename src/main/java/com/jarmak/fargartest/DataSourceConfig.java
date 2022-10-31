package com.jarmak.fargartest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    //@Bean
    public DataSource datasource() {
        logger.info("Datasource config runs");
        try {
            JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
            bean.setJndiName("java:comp/env/jdbc/CasperDataSource");
            bean.setProxyInterface(DataSource.class);
            bean.setLookupOnStartup(false);
            bean.afterPropertiesSet();
            return (DataSource) bean.getObject();

//            return DataSourceBuilder.create()
//                    .driverClassName("oracle.jdbc.OracleDriver")
//                    .url(url)
//                    .username(username)
//                    .password(password)
//                    .build();

        //    InitialContext initialContext = new InitialContext();
        //    DataSource datasource = (DataSource) initialContext.lookup("java:comp/env/jdbc/CasperDataSource");
        //    return datasource;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}