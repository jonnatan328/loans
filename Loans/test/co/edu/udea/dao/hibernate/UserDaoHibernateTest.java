package co.edu.udea.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.exception.MyDaoException;
import co.edu.udea.dto.Request;
import co.edu.udea.dto.Role;
import co.edu.udea.dto.User;
import co.edu.udea.dao.UserDao;

/**
 * Prueba unitaria para el dao de User
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class UserDaoHibernateTest {
	
	@Autowired
	UserDao dao;
	/**
	 * Prueba unitaria del metodo getAll
	 * @exception MyDaoException
	 */
	@Test
	public void testGetAll() {
		List<User> users;
		try{
			users = dao.getAll();
			
			assertTrue(users.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	}
	
	/**
	 * Prueba unitaria del metodo get
	 * @exception MyDaoException
	 */
	@Test
	public void testGet() {
		User user;
		try{
			user = dao.get("elver");
			assertEquals("Suarez", user.getLastnames());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba unitaria del metodo save
	 * @exception MyDaoException
	 */

	@Test
	public void testSave() {
		User user = null;
		Role role = null;
		String username = null;
		user = new User();
		role = new Role();
		role.setId("INV");
		role.setName("Investigador");
		user.setUsername("carlos");
		user.setNames("Carlos");
		user.setLastnames("Vasquez");
		user.setPassword("123");
		user.setRole(role);
		try{
			dao.save(user);
			username = user.getUsername();
			assertNotNull(username);
			User newUser = dao.get(username);
			assertEquals("carlos", newUser.getUsername());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Prueba unitaria del metodo update
	 * @exception MyDaoException
	 */
	@Test
	public void testUpdate() {
		User user = null;
		Role role = null;
		role = new Role();
		user = new User();
		role.setId("INV");
		role.setName("Investigador");
		user.setUsername("andres");
		user.setNames("Andres");
		user.setLastnames("Zapata");
		user.setPassword("12345");
		user.setRole(role);
		try{
			dao.update(user);
			String username = user.getUsername();
			assertNotNull(username);
			User newUser = dao.get(username);
			assertEquals("andres", newUser.getUsername());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
		
	}
	
	/**
	 * Prueba unitaria del metodo delete
	 * @exception MyDaoException
	 */
	@Test
	public void testDelete() {
		User userDeleted = null;
		String username = "elver";		
		try{
			dao.delete(username);			
			assertNotNull(username);
			userDeleted = dao.get(username);
			assertEquals(null, userDeleted);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}			
	}

}
