package co.edu.udea.dto;

import java.util.Calendar;
import java.util.Date;

import co.edu.udea.dto.Device;
import co.edu.udea.dto.User;

/**
 * DTO para la tabla requests
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

public class Request {
	private Long id;
	private Date dateRequest;
	private Calendar startTime;
	private Calendar endTime;
	private String state;
	private Device device; /** Referencia a la tabla devices */
	private User researcher; /** Referencia a la tabla users */
	
	/**
	 * Obtiene el id de un Request
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Modifica el id de un Request
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Obtiene la fecha de solicitud de un Request
	 * @return dateRequest
	 */
	public Date getDateRequest() {
		return dateRequest;
	}
	/**
	 * Modifica la fecha de solicitud de un Request
	 */
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	/**
	 * Obtiene el tiempo de inicio de un Request
	 * @return startTime
	 */
	public Calendar getStartTime() {
		return startTime;
	}
	/**
	 * Modifica el tiempo de inicio de un Request
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	/**
	 * Obtiene el tiempo de finalizaci�n de un Request
	 * @return endTime
	 */
	public Calendar getEndTime() {
		return endTime;
	}
	/**
	 * Modifica el tiempo de finalizaci�n de un Request
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	/**
	 * Obtiene el estado de un Request
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * Modifica el estado de un Request
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * Obtiene el dispositivo de un Request
	 * @return device
	 */
	public Device getDevice() {
		return device;
	}
	/**
	 * Modifica el dispositivo de un Request
	 */
	public void setDevice(Device device) {
		this.device = device;
	}
	/**
	 * Obtiene el investigador de un Request
	 * @return reseracher
	 */
	public User getResearcher() {
		return researcher;
	}
	/**
	 * Modifica el investigador de un Request
	 */
	public void setResearcher(User researcher) {
		this.researcher = researcher;
	}
	
}
