package co.edu.udea.dao;

import java.util.List;

import co.edu.udea.dto.Device;
import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos para acceder a los dispositivos
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public interface DeviceDao {
	
	/**
	 * Entrega la lista de dispositivos disponibles en la bd
	 * @return Lista de dispositivos
	 * @throws MyDaoException cuando hay alg�n problema en la conexi�n
	 */
	public List<Device> getAll() throws MyDaoException;
	
	/**
	 * Entrega los datos de un dispositivo dado su id
	 * @param id
	 * @return Device
	 * @throws MyDaoException
	 */
	public Device get(Long id) throws MyDaoException;
	
	/**
	 * Permite crear un nuevo dispositivo en la base de datos
	 * @param Device Dto con los datos del dispositivo a crear
	 * @throws MyDaoException
	 */
	public void save(Device device) throws MyDaoException;
	
	/**
	 * Actualiza la informaci�n de un dispositivo en la base de datos
	 * 
	 * @param Device informaci�n del dispositivo a modificar
	 * @throws MyDaoException
	 */
	public void update(Device device) throws MyDaoException;
	
	/**
	 * Elimna un dispositivo de la base de datos
	 * @param id del dispositivo
	 * @throws MyDaoException
	 */
	public void delete(Long id) throws MyDaoException;
}
