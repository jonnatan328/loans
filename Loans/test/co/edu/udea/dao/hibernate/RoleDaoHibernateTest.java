package co.edu.udea.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dao.RoleDao;
import co.edu.udea.dto.Device;
import co.edu.udea.dto.Role;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para el dao de Roles
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class RoleDaoHibernateTest {

	@Autowired
	RoleDao roleDao;
	
	/**
	 * Prueba unitaria del metodo get
	 * @exception MyDaoException
	 */
	@Test
	public void testGet() {
		Role role = null;
		try{
			role = roleDao.get("INV");
			assertEquals("Investigador", role.getName());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}

}
