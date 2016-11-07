package co.edu.udea.bl;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.udea.dto.Request;
import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos de la l�gica del negocio de los requests
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public interface RequestBL {
	/**
	 * Crea una nueva solicitud en la base de datos
	 * @param dateRequest, startTime, endTime, state, device, researcher
	 */
	public Long createRequest(Date dateRequest, Calendar startTime, Calendar endTime, String state, Long device, String researcher) throws MyDaoException;
	/**
	 * Acepta una solicitud en la base de datos
	 * @param id
	 */
	public void acceptRequest(Long id) throws MyDaoException;
	/**
	 * Rechaza una solicitud en la base de datos
	 * @param id
	 */
	public void rejectRequest(Long id) throws MyDaoException;
	/**
	 * Muestra las solicitudes disponibles que se encuentren en la base de datos
	 * @return List<Request>
	 */
	public List<Request> showRequests() throws MyDaoException;
	/**
	 * Muestra las solicitudes disponibles que se encuentren en la base de datos en la fechas proporcionada
	 *  @param dateRequest
	 *  @return List<Request>
	 */
	public List<Request> searchRequest(Date dateRequest) throws MyDaoException;
	/**
	 * Muestra las solicitudes disponibles que se encuentren en la base de datos en la hora proporcionada
	 * @param startTime
	 * @return List<Request>
	 */
	public List<Request> searchRequest(Calendar startTime) throws MyDaoException;
	/**
	 * Muestra las solicitudes disponibles que se encuentren en la base de datos de el estado proporcionado
	 * @param state
	 * @return List<Request>
	 */
	public List<Request> searchRequest(String state) throws MyDaoException;
	/**
	 * Muestra las solicitudes disponibles que se encuentren en la base de datos de el dispositivo solicitado
	 * @param device
	 * @return List<Request>
	 */
	public List<Request> searchRequest(Long device) throws MyDaoException;
	/**
	 * valida que la hora de una solicitud no supere las 8 horas
	 * @param startTime, endTime
	 * @return true or false
	 */
	public boolean validateTime(Calendar startTime, Calendar endTime) throws MyDaoException;
	
}
