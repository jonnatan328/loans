package co.edu.udea.dto;

/**
 * DTO para la tabla users
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */

public class User {
	private String username;
	private String names;
	private String lastnames;
	private String password;
	private Role role; /** Referencia a la tabla roles */
	
	/**
	 * Obtiene el username de un User
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Modifica el username de un User
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Obtiene los nombres de un User
	 * @return names
	 */
	public String getNames() {
		return names;
	}
	/**
	 * Modifica los nombres de un User
	 */
	public void setNames(String names) {
		this.names = names;
	}
	/**
	 * Obtiene los apellidos de un User
	 * @return lastnames
	 */
	public String getLastnames() {
		return lastnames;
	}
	/**
	 * Modifica los apellidos de un User
	 */
	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}
	/**
	 * Obtiene el password de un User
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Modifica el password de un User
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Obtiene el rol de un User
	 * @return role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * Modifica el rol de un User
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
