package co.edu.udea.bl.imp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.bl.UserBL;
import co.edu.udea.dao.UserDao;
import co.edu.udea.dto.User;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para la implementaci�n de la l�gica de negocios de Devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class UserBLImpTest {
	@Autowired
	UserBL BL;
	
	@Autowired
	UserDao userDao;
	
	/**
	 * Prueba unitaria del metodo signIn
	 * @exception MyDaoException
	 */
	@Test
	public void testSignIn() {
		try{			
			assertTrue(BL.signIn("diego", "1234"));
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		
		
	}
	/**
	 * Prueba unitaria del metodo register
	 */
	@Test
	public void testRegister() {
		String username = null;
		User userDb = null;
		try{
			username = BL.register("pedro", "Pedro", "Carmona", "pedro", "INV");
			userDb = userDao.get(username);
			assertEquals("Pedro",userDb.getNames());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		
		
	}
}
