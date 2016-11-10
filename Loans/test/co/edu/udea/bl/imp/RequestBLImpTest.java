package co.edu.udea.bl.imp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.bl.RequestBL;
import co.edu.udea.dao.RequestDao;
import co.edu.udea.dto.Request;
import co.edu.udea.exception.MyDaoException;

/**
 * Prueba unitaria para la implementaci�n de la l�gica de negocios de Devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuration.xml"))
public class RequestBLImpTest {
	@Autowired
	RequestBL BL;
	@Autowired
	RequestDao dao;
	
	/**
	 * Prueba unitaria del metodo createRequest
	 * @exception MyDaoException
	 */
	@Test
	public void testCreateRequest() {
		Calendar startTime = new GregorianCalendar();
		Calendar endTime = new GregorianCalendar();
		@SuppressWarnings("deprecation")
		Date dateRequest = new Date(116, 9, 18);
		Long id = null;
		startTime.clear();
		startTime.set(Calendar.HOUR_OF_DAY, 9);
		startTime.set(Calendar.MINUTE, 0);
		endTime.set(Calendar.HOUR_OF_DAY, 14);
		endTime.set(Calendar.MINUTE, 0);
		System.out.println(startTime);
		
		try{			
			id = BL.createRequest(dateRequest, startTime, endTime,"pendiente", 3L , "andres");
			assertNotNull(id);
			Request newRequest = dao.get(id);
			assertEquals("2016-10-18", newRequest.getDateRequest().toString().substring(0,10));
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
		
	}
	
	/**
	 * Prueba unitaria del metodo acceptRequest
	 * @exception MyDaoException
	 */
	@Test
	public void testAcceptRequest() {
		Request request;
		Long id = 5L;
		try{
			BL.acceptRequest(id);	
			request = dao.get(id);
			assertEquals("aceptado", request.getState());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Prueba unitaria del metodo rejectRequest
	 * @exception MyDaoException
	 */
	@Test
	public void testRejectRequest() {
		Request request;
		Long id = 4L;
		try{
			BL.rejectRequest(id);	
			request = dao.get(id);
			assertEquals("rechazado", request.getState());
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Prueba unitaria del metodo showRequests
	 * @exception MyDaoException
	 */
	@Test
	public void testShowRequests() {
		List<Request> requests;
		try{
			requests = BL.showRequests();
			assertTrue(requests.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Prueba unitaria del metodo searchRequestDate
	 * @exception MyDaoException
	 */
	@Test
	public void testSearchRequestDate() {
		@SuppressWarnings("deprecation")
		Date dateRequest = new Date(116, 9, 18);
		List<Request> requests;		
		try{
			requests = BL.searchRequest(dateRequest);
			assertTrue(requests.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		
	}
	
	/**
	 * Prueba unitaria del metodo searchRequestStartTime
	 * @exception MyDaoException
	 */
	@Test
	public void testSearchRequestStartTime() throws MyDaoException {
		Calendar startTime = new GregorianCalendar();
		startTime.clear();
		startTime.set(Calendar.HOUR_OF_DAY, 9);
		startTime.set(Calendar.MINUTE, 0);
		Request request = dao.get(14L);
		List<Request> requests;
		try{
			requests = BL.searchRequest(startTime);
			assertTrue(requests.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
			throw new MyDaoException(e);
		}		
	}
	
	/**
	 * Prueba unitaria del metodo searchRequestState
	 * @exception MyDaoException
	 */
	@Test
	public void testSearchRequestState() {
		List<Request> requests;
		try{
			requests = BL.searchRequest("pendiente");
			assertTrue(requests.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		}
	
	/**
	 * Prueba unitaria del metodo searchRequestDevice
	 * @exception MyDaoException
	 */
	@Test
	public void testSearchRequestDevice() {
		List<Request> requests;
		Long device = 2L;
		try{
			requests = BL.searchRequest(device);
			assertTrue(requests.size() > 0);
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		}
	/**
	 * Prueba unitaria del metodo validateTime
	 * @exception MyDaoException
	 */
	@Test
	public void testValidateTime() {
		Calendar startTime = new GregorianCalendar();
		Calendar endTime = new GregorianCalendar();
		startTime.set(Calendar.HOUR_OF_DAY, 12);
		endTime.set(Calendar.HOUR_OF_DAY, 20);
		try{
			assertTrue(BL.validateTime(startTime,endTime));
		}catch(MyDaoException e){
			fail(e.getMessage());
		}		
	}	
}
