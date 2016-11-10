package co.edu.udea.bl.imp;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.udea.bl.RequestBL;
import co.edu.udea.dao.DeviceDao;
import co.edu.udea.dao.RequestDao;
import co.edu.udea.dao.UserDao;
import co.edu.udea.dto.Device;
import co.edu.udea.dto.Request;
import co.edu.udea.dto.User;
import co.edu.udea.exception.MyDaoException;


/**
 * Implementa los metodos de la l�gica del negocio de los requests
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class RequestBLImp implements RequestBL {
	/**
	 * @param request
	 * @throw MyDaoException, {@link NullPointerException}
	 */
	
	private RequestDao requestDao;
	private UserDao userDao;
	private DeviceDao deviceDao;
	
	/**
	 * Constructor para la clase que implementa la l�gica de negocio de las solicitudes
	 * @param requestDao, userDao, deviceDao
	 */
	public RequestBLImp(RequestDao requestDao, UserDao userDao, DeviceDao deviceDao ){
		this.requestDao = requestDao;
		this.userDao = userDao;
		this.deviceDao = deviceDao;
	}	

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#createRequest()
	 */
	@Override
	public Long createRequest(Date dateRequest, Calendar startTime, Calendar endTime, String state, Long device,
			String researcher) throws MyDaoException {
		int startHour = startTime.get(Calendar.HOUR_OF_DAY);
		int endHour = endTime.get(Calendar.HOUR_OF_DAY);
		if(startHour < 6 || startHour > 20 || endHour < 6 || endHour > 21){
			throw new MyDaoException("Debe reservar un dispositivo en el horario adecuado", null);
		}
		if(dateRequest == null || "".equals(dateRequest)){
			throw new MyDaoException("Debe especificar la fecha de solicitud", null);
		}
		if(startTime == null || "".equals(startTime)){
			throw new MyDaoException("Debe especificar la hora de inicio del prestamo", null);
		}
		if(endTime == null || "".equals(endTime)){
			throw new MyDaoException("Debe especificar la hora de finalizacion del prestamo", null);
		}
		if(state == null || "".equals(state.trim())){
			throw new MyDaoException("Debe especificar el estado", null);
		}
		if(device == null || "".equals(device)){
			throw new MyDaoException("Debe especificar el dispositivo ", null);
		}
		if(researcher == null || "".equals(researcher.trim())){
			throw new MyDaoException("Debe especificar el investigador ", null);
		}
		
		Device deviceDb = deviceDao.get(device);
		User userDb = userDao.get(researcher.toLowerCase());
		
		if(deviceDb == null){
			throw new MyDaoException("El dispositivo no se encuentra en la base de datos", null);
		}
		
		if(userDb == null){
			throw new MyDaoException("El usuario no se encuentra en la base de datos", null);
		}
		
		Request request = new Request();
		request.setDateRequest(dateRequest);
		request.setStartTime(startTime);
		request.setEndTime(endTime);
		request.setState("pendiente");
		request.setDevice(deviceDb);
		request.setResearcher(userDb);
		
		requestDao.save(request);
		
		return request.getId(); 
		
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#acceptRequest()
	 */
	@Override
	public void acceptRequest(Long id) throws MyDaoException {
		if(id <=0 || "".equals(id)){
			throw new MyDaoException("Debe especificar el request", null);
		}
		Request requestDb = requestDao.get(id);
		if(requestDb == null){
			throw new MyDaoException("La solicitud no se encuentra en la base de datos", null);
		}
		requestDb.setState("aceptado");
		requestDao.update(requestDb);
		
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#rejectRequest()
	 */
	@Override
	public void rejectRequest(Long id) throws MyDaoException {
		if(id <=0 || "".equals(id)){
			throw new MyDaoException("Debe especificar el request", null);
		}
		Request requestDb = requestDao.get(id);
		if(requestDb == null){
			throw new MyDaoException("La solicitud no se encuentra en la base de datos", null);
		}
		requestDb.setState("rechazado");
		requestDao.update(requestDb);
		
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#showRequests()
	 */
	@Override
	public List<Request> showRequests() throws MyDaoException {
		List<Request> requests = null;
		requests = requestDao.getAll();		
		return requests;
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#searchRequest()
	 */
	@Override
	public List<Request> searchRequest(Date dateRequest) throws MyDaoException {
		if(dateRequest == null || "".equals(dateRequest)){
			throw new MyDaoException("Debe especificar la fecha de solicitud", null);
		}
		List<Request> requests = null;
		requests = requestDao.getAllDateRequest(dateRequest);
		return requests;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#searchRequest()
	 */
	@Override
	public List<Request> searchRequest(Calendar startTime) throws MyDaoException {
		if(startTime == null || "".equals(startTime)){
			throw new MyDaoException("Debe especificar la hora de inicio del prestamo", null);
		}
		List<Request> requests = null;
		requests = requestDao.getAllStartTime(startTime);	
		return requests;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#searchRequest()
	 */
	@Override
	public List<Request> searchRequest(String state) throws MyDaoException {
		if(state == null || "".equals(state.trim())){
			throw new MyDaoException("Debe especificar el estado", null);
		}
		List<Request> requests = null;
		requests = requestDao.getAllState(state);
		return requests;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#searchRequest()
	 */
	@Override
	public List<Request> searchRequest(Long device) throws MyDaoException {
		if(device == null || "".equals(device)){
			throw new MyDaoException("Debe especificar el dispositivo ", null);
		}
		List<Request> requests = null;
		Device deviceDb = deviceDao.get(device);
		if(deviceDb == null){
			throw new MyDaoException("El dispositivo no se encuentra en la base de datos", null);
		}
		requests = requestDao.getAllDevice(deviceDb);
		
		return requests;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.RequestBL#validateTime()
	 */
	@Override
	public boolean validateTime(Calendar startTime, Calendar endTime) throws MyDaoException {
		int endHour = endTime.get(Calendar.HOUR_OF_DAY);
		int startHour = startTime.get(Calendar.HOUR_OF_DAY);
		int endMinutes = endTime.get(Calendar.MINUTE);
		int startMinutes = startTime.get(Calendar.MINUTE);
		int difHours = endHour - startHour;
		if(startTime == null || "".equals(startTime)){
			throw new MyDaoException("Debe especificar la hora de inicio del prestamo", null);
		}
		if(endTime == null || "".equals(endTime)){
			throw new MyDaoException("Debe especificar la hora de finalizacion del prestamo", null);
		}
		if( difHours  > 8 || (difHours == 8 && endMinutes > startMinutes)){
			return false;
		}
		return true;
	}

}
