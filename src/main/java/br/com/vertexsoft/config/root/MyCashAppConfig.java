package br.com.vertexsoft.config.root;

import org.springframework.beans.factory.aspectj.EnableSpringConfigured;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@EnableSpringConfigured
@Configuration
@ComponentScan(basePackages = { "br.com.vertexsoft.config", "br.com.vertexsoft.mycash" }, scopedProxy = ScopedProxyMode.TARGET_CLASS, excludeFilters = @Filter(Controller.class))
public class MyCashAppConfig {

}
