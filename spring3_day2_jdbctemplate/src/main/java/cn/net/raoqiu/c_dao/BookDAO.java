package cn.net.raoqiu.c_dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//继承DaoSupport，继承设置模板的代码
public class BookDAO extends JdbcDaoSupport {
	// 在配置文件中，将DataSource注入给DAO，自动创建JdbcTemple
	public void save(Book book) {
		String sql = "insert into book values(null,?,?)";
		super.getJdbcTemplate().update(sql, book.getName(), book.getPrice());
	}

	public void update(Book book) {
		String sql = "update book set name=?,price=? where id=?";
		super.getJdbcTemplate().update(sql, book.getName(), book.getPrice(),
				book.getId());
	}

	public void delete(Book book) {
		String sql = "delete from book where id=?";
		super.getJdbcTemplate().update(sql, book.getId());
	}

	//查询总数
	public int findTotalCount() {
		String sql = "select count(*) from book";
		return super.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
	//查询书名
	public String findNameById(int id){
		String sql="select name from book where id=?";
		return super.getJdbcTemplate().queryForObject(sql, String.class,id);
	}
	
	//查询所有图书
	public List<Book> findAll(){
		String sql="select * from book";
		return super.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Book>(Book.class));
	}
	
	//查询某本书
	public Book findById(int id){
		String sql="select * from book where id=?";
		return super.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
	}
}
