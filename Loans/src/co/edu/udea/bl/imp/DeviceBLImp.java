package co.edu.udea.bl.imp;

import java.util.List;

import co.edu.udea.bl.DeviceBL;
import co.edu.udea.dao.DeviceDao;
import co.edu.udea.exception.MyDaoException;
import co.edu.udea.dto.Device;

/**
 * Implementa los metodos de la l�gica del negocio de los devices
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class DeviceBLImp implements DeviceBL {
	/**
	 * @param device
	 * @throw MyDaoException, {@link NullPointerException}
	 */
	
	private DeviceDao deviceDao;
	
	/**
	 * Obtiene el deviceDao
	 * @return deviceDao
	 */
	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	/**
	 * Modifica el deviceDao
	 * @return deviceDao
	 */
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}


	/* (non-Javadoc)
	 * @see co.edu.udea.bl.DeviceBL#showDevices()
	 */	
	@Override
	public List<Device> showDevices() throws MyDaoException {
		List<Device> devices = null;
		devices = deviceDao.getAll();
		return devices;
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.bl.DeviceBL#createDevice()
	 */	
	@Override
	public Device createDevice(String name, int number) throws MyDaoException {
		if(name == null || "".equals(name.trim())){
			throw new MyDaoException("Debe especificar el nombre", null);
		}
		if(number <=0 || "".equals(number)){
			throw new MyDaoException("Debe especificar la cantidad", null);
		}
		
		Device device = new Device();
		device.setName(name);
		device.setNumber(number);
		
		deviceDao.save(device);
		return device;
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.bl.DeviceBL#deleteDevice()
	 */
	@Override
	public void deleteDevice(Long id) throws MyDaoException {
		Device device = null;
		if(id <=0 || "".equals(id)){
			throw new MyDaoException("Debe especificar el dispositivo", null);
		}
		device = deviceDao.get(id);
		device.setState(false);
		deviceDao.update(device);
	}

}
