package cn.net.raoqiu.datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//基于配置使用JdbcTemplate
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class SpringTest {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCreatDB(){
		jdbcTemplate
		.execute("create table person(id int primary key,name varchar(20))");
	}
}
