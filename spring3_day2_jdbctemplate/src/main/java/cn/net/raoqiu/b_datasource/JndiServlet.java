package cn.net.raoqiu.b_datasource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JndiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 原始方式，加载spring环境
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext
				.getBean("jdbcTemplate");
		jdbcTemplate
				.execute("create table person(id int primary key,name varchar(20))");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
