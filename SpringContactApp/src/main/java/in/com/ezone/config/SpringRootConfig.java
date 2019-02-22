package in.com.ezone.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "in.com.ezone.dao","in.com.ezone.service" })
public class SpringRootConfig {

	@Bean
	public BasicDataSource getDataSource() {

		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3310/contactapp");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setMaxTotal(2);
		basicDataSource.setInitialSize(1);
		basicDataSource.setTestOnBorrow(true);
		basicDataSource.setValidationQuery("SELECT 1");
		basicDataSource.setDefaultAutoCommit(true);

		return basicDataSource;
	}
}
