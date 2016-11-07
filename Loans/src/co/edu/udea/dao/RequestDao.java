package co.edu.udea.dao;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.udea.dto.Device;
import co.edu.udea.dto.Request;
import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos para acceder a las solicitudes
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public interface RequestDao {
	
	/**
	 * Entrega la lista de solicitudes disponibles en la bd
	 * @return Lista de solicitudes
	 * @throws MyDaoException cuando hay alg�n problema en la conexi�n
	 */
	public List<Request> getAll() throws MyDaoException;
	
	/**
	 * Entrega los datos de una solicitud dado su id
	 * @param id
	 * @return
	 * @throws MyDaoException
	 */
	public Request get(Long id) throws MyDaoException;
	
	/**
	 * Entrega  la lista de solicitudes disponibles en la bd dado su dateRequest
	 * @param dateRequest
	 * @return
	 * @throws MyDaoException
	 */
	public List<Request> getAllDateRequest(Date dateRequest) throws MyDaoException;
	
	/**
	 * Entrega  la lista de solicitudes disponibles en la bd dado su startTime
	 * @param startTime
	 * @return
	 * @throws MyDaoException
	 */
	public List<Request> getAllStartTime(Calendar startTime) throws MyDaoException;
	
	/**
	 * Entrega la lista de solicitudes disponibles en la bd dado su state
	 * @param state
	 * @return
	 * @throws MyDaoException
	 */
	public List<Request> getAllState(String state) throws MyDaoException;
	
	/**
	 * Entrega  la lista de solicitudes disponibles en la bd dado su device
	 * @param device
	 * @return
	 * @throws MyDaoException
	 */
	public List<Request> getAllDevice(Device device) throws MyDaoException;
	
	/**
	 * Permite crear una nueva solicitud en la base de datos
	 * @param Request Dto con los datos de la solicitud a crear
	 * @throws MyDaoException
	 */
	public void save(Request request) throws MyDaoException;
	
	/**
	 * Actualiza la informaci�n de una solicitud en la base de datos
	 * 
	 * @param Request informaci�n de la solicitud a modificar
	 * @throws MyDaoException
	 */
	public void update(Request request) throws MyDaoException;
	
	/**
	 * Elimna una solicitud de la base de datos
	 * @param id de la solicitud
	 * @throws MyDaoException
	 */
	public void delete(Long id) throws MyDaoException;
}
