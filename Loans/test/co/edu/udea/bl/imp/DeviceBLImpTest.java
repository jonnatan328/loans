package co.edu.udea.bl.imp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.bl.DeviceBL;
import co.edu.udea.dao.DeviceDao;
import co.edu.udea.dto.Device;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para la implementaci�n de la l�gica de negocios de Devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class DeviceBLImpTest {
	@Autowired
	DeviceBL BL;
	@Autowired
	DeviceDao dao;
	
	/**
	 * Prueba unitaria del metodo showDevices
	 * @exception MyDaoException
	 */
	@Test
	public void testShowDevices() {
		List<Device> devices;
		try{
			devices = BL.showDevices();
			
			assertTrue(devices.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Prueba unitaria del metodo createDevice
	 * @exception MyDaoException
	 */
	@Test
	public void testCreateDevice() {		
		Device device;
		try{			
			device = BL.createDevice("Camara", 7);
			assertNotNull(device);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba unitaria del metodo deleteDevice
	 * @exception MyDaoException
	 */
	@Test
	public void testDeleteDevice() {
		Long id = 4L;
		try{
			BL.deleteDevice(id);
			assertNotNull(id);
			Device deleteDevice = dao.get(id);
			assertEquals(false,deleteDevice.getState());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
}
