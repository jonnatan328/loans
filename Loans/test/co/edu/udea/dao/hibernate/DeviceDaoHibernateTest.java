package co.edu.udea.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dao.DeviceDao;
import co.edu.udea.dto.Device;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para el dao de Devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class DeviceDaoHibernateTest {
	
	@Autowired
	DeviceDao dao;
	
	/**
	 * Prueba unitaria del metodo getAll
	 * @exception MyDaoException
	 */
	@Test
	public void testGetAll() {
		List<Device> devices;
		try{
			devices = dao.getAll();
			
			assertTrue(devices.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba unitaria del metodo get
	 * @exception MyDaoException
	 */
	@Test
	public void testGet() {
		Device device = null;
		try{
			device = dao.get(1L);
			assertEquals("Portatil", device.getName());
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
		Device device = null;
		device = new Device();
		device.setName("Camara");
		device.setNumber(7);
		try{
			dao.save(device);
			Long id = device.getId();
			assertNotNull(id);
			Device newDevice = dao.get(id);
			assertEquals("Camara",newDevice.getName());
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
		Device device = null;
		device = new Device();
		device.setId(5L);
		device.setName("Parlante");
		device.setNumber(5);
		device.setState(true);
		try{
			
			dao.update(device);
			Long id = device.getId();
			assertNotNull(id);
			Device newDevice = dao.get(id);
			assertEquals("Parlante",newDevice.getName());
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
		Device deviceDeleted = null;
		Long id = 13L;
		try{
			dao.delete(id);
			assertNotNull(id);
			deviceDeleted = dao.get(id);
			assertEquals(null,deviceDeleted);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}

}
