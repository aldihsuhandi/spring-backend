package com.project.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:application-context.xml"})
public class XmlConfiguration {
}
