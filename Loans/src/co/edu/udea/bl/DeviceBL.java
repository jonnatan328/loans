package co.edu.udea.bl;

import java.util.List;

import co.edu.udea.dto.Device;
import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos de la l�gica del negocio de los devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public interface DeviceBL {
	/**
	 * Muestra los dispositivos disponibles que se encuentren en la base de datos
	 * @return List<Device>
	 */
	public List<Device> showDevices() throws MyDaoException;
	/**
	 * Crea un nuevo dispositivo en la base de datos
	 * @param nombre
	 */
	public Device createDevice(String name, int number) throws MyDaoException;
	/**
	 * Hace un borrado logico de un dispositivo en la base de datos
	 * @param id
	 */
	public void deleteDevice(Long id) throws MyDaoException;
	
}
