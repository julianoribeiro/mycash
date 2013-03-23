package br.com.vertexsoft.config.root.database;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import br.com.vertexsoft.config.root.annotation.ProductionEnvironment;

@ProductionEnvironment
@Configuration
public class ProductionDatabaseConfig implements DatabaseConfig {

	@Bean
	@Override
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("postgresql");
		factoryBean.setDataSource(dataSource());
		return factoryBean;
	}

	@Bean
	@Override
	public DataSource dataSource() {
		try {
			URI dbUri = new URI(System.getenv("DATABASE_URL"));

			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl(dbUrl);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setTestOnBorrow(true);
			dataSource.setTestOnReturn(true);
			dataSource.setTestWhileIdle(true);
			dataSource.setTimeBetweenEvictionRunsMillis(1800000);
			dataSource.setNumTestsPerEvictionRun(3);
			dataSource.setMinEvictableIdleTimeMillis(1800000);
			return dataSource;
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}