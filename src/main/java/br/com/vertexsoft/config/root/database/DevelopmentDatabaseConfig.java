package br.com.vertexsoft.config.root.database;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.com.vertexsoft.config.root.annotation.DevelopmentEnvironment;

@DevelopmentEnvironment
@Configuration
public class DevelopmentDatabaseConfig implements DatabaseConfig {

	@Bean
	@Override
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("mysql");
		factoryBean.setDataSource(dataSource());
		return factoryBean;
	}

	@Bean
	@Override
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/mycash");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(1800000);
		dataSource.setNumTestsPerEvictionRun(3);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		dataSource.setInitialSize(4);
		dataSource.setMaxActive(20);
		dataSource.setMaxIdle(20);

		return dataSource;
	}

}
