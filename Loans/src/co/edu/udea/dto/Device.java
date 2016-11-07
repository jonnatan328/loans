package co.edu.udea.dto;

/**
 * DTO para la taba devices
 * @author Oscar Zapata, Jonnatan Ríos, Diego Álvarez
 *
 */

public class Device {
	private Long id;
	private String name;
	private int number;
	private boolean state;
	
	
	/**
	 * Obtiene el id de un Device
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Modifica el id de un Device
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Obtiene el nombre de un Device
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Modifica el nombre de un Device
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Obtiene el numero de un Device
	 * @return number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * Modifica el numero de un Device
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * Obtiene el estado de un Device
	 * @return state
	 */
	public boolean getState() {
		return state;
	}
	/**
	 * Modifica el estado de un Device
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
}
