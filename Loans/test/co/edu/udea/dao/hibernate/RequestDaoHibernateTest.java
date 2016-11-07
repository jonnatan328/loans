package co.edu.udea.dao.hibernate;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dao.DeviceDao;
import co.edu.udea.dao.RequestDao;
import co.edu.udea.dao.UserDao;
import co.edu.udea.dto.Device;
import co.edu.udea.dto.Request;
import co.edu.udea.dto.User;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para el dao de Request
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class RequestDaoHibernateTest {

	@Autowired
	RequestDao dao;
	
	@Autowired
	DeviceDao deviceDao;
	
	@Autowired
	UserDao userDao;
	
	/**
	 * Prueba unitaria del metodo getAll
	 * @exception MyDaoException
	 */
	@Test
	public void testGetAll() {
		List<Request> requests;
		try{
			requests = dao.getAll();
			
			assertTrue(requests.size() > 0);
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
		Request request;
		try{
			request = dao.get(1L);
			assertEquals("2014-12-05", request.getDateRequest().toString().substring(0, 10));
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
		Request request = null;
		Device device = null;
		User researcher = null;
		
		Calendar startTime = GregorianCalendar.getInstance();
		Calendar endTime = GregorianCalendar.getInstance();
		@SuppressWarnings("deprecation")
		Date dateRequest = new Date(116, 9, 18);
		
		startTime.setTime(dateRequest);
		endTime.setTime(dateRequest);
		startTime.set(Calendar.HOUR, 12);
		startTime.set(Calendar.MINUTE, 30);
		endTime.set(Calendar.HOUR, 18);
		endTime.set(Calendar.MINUTE, 30);
		
		request = new Request();
		request.setState("pendiente");
		request.setDateRequest(dateRequest);
		request.setEndTime(endTime);
		request.setStartTime(startTime);
		
		try{
			device = deviceDao.get(1L);
			researcher = userDao.get("elver");
			assertNotNull(device);
			assertNotNull(researcher);
			request.setDevice(device);
			request.setResearcher(researcher);
			dao.save(request);
			Long id = request.getId();
			assertNotNull(id);
			Request newRequest = dao.get(id);
			assertEquals("2016-10-18",newRequest.getDateRequest().toString().substring(0,10));
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
		Request request = null;
		Device device = null;
		User researcher = null;
		Calendar startTime = GregorianCalendar.getInstance();
		Calendar endTime = GregorianCalendar.getInstance();
		@SuppressWarnings("deprecation")
		Date dateRequest = new Date(116, 9, 18);
		
		startTime.setTime(dateRequest);
		endTime.setTime(dateRequest);
		startTime.set(Calendar.HOUR, 12);
		startTime.set(Calendar.MINUTE, 30);
		endTime.set(Calendar.HOUR, 18);
		endTime.set(Calendar.MINUTE, 30);
		
		request = new Request();
		request.setId(5L);
		request.setDateRequest(dateRequest);
		request.setEndTime(endTime);
		request.setStartTime(startTime);
		request.setState("Pendiente");
		try{
			device = deviceDao.get(1L);
			researcher = userDao.get("elver");
			request.setDevice(device);
			request.setResearcher(researcher);
			dao.update(request);
			Long id = request.getId();
			assertNotNull(id);
			Request newRequest = dao.get(id);
			assertEquals("2016-10-18",newRequest.getDateRequest().toString().substring(0,10));
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
		Request requestDeleted = null;
		Long id = 6L;
		try{
			dao.delete(id);
			assertNotNull(id);
			requestDeleted = dao.get(id);
			assertEquals(null,requestDeleted);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}
	}

}
