package cn.net.raoqiu.c_dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class BookDAOTest {

	@Autowired
	private BookDAO bookDAO;

	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("一万个为什么");
		book.setPrice(80);

		bookDAO.save(book);
	}

	@Test
	public void testUpdate() {
		Book book = new Book();
		book.setId(1);
		book.setName("一千个为什么");
		book.setPrice(50);

		bookDAO.update(book);
	}

	@Test
	public void testDelete() {
		Book book = new Book();
		book.setId(3);
		
		bookDAO.delete(book);
	}

	@Test
	public void testSimpleQuery(){
		System.out.println(bookDAO.findTotalCount());
		System.out.println(bookDAO.findNameById(4));
	}
	
	@Test
	public void testComplexQuery(){
		System.out.println(bookDAO.findById(4));
		System.out.println(bookDAO.findAll());
	}
}
