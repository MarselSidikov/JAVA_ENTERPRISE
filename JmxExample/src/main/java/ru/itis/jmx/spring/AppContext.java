package ru.itis.jmx.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import java.util.Collections;

/**
 * 05.09.2018
 * AppContext
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Configuration
@ComponentScan("ru.itis.jmx.spring")
public class AppContext {

    @Autowired
    private SpringCache springCache;

    @Bean
    public MBeanExporter exporter() {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setBeans(Collections
                .singletonMap("ru.itis.jmx.spring:type=cache2", springCache));
        return exporter;
    }

    @Bean
    public MBeanServerFactoryBean mBeanServer() {
        return new MBeanServerFactoryBean();
    }
}
