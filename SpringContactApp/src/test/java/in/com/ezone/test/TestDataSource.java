package in.com.ezone.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.com.ezone.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		DataSource ds = cx.getBean(DataSource.class);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		String sql="INSERT INTO user( name, phone, email, address, loginName, password) VALUES(?,?,?,?,?,?)";

		
		
		Object object = new Object[] {"akash","1212121212","a@gmail.com","naigaon","akash","Akash@123"};
		jdbcTemplate.update(sql,object);
		
		System.out.println("--------AQL Executed----------");
	}
}
