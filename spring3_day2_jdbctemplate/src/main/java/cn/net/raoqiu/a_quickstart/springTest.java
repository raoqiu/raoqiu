package cn.net.raoqiu.a_quickstart;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//JdbcTemplate 快速入门
public class springTest {
	@Test
	// 零配置文件入门案例
	public void testQuickStart() {
		// 连接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// 设置Jdbc连接参数
		dataSource.setUrl("jdbc:mysql://115.28.91.5/spring3_day2");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		// 创建JdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// 执行操作
		jdbcTemplate
				.execute("create table person(id int primary key,name varchar(20))");
	}
}
