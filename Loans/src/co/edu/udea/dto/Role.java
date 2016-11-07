package co.edu.udea.dto;
/**
 * DTO para la tabla roles
 * @author Oscar Zapata, Jonnatan Ríos, Diego Álvarez
 *
 */
public class Role {
	private String id;
	private String name;
	
	/**
	 * Obtiene el id de un Role
	 * @return id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Modifica el id de un Role
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Obtiene el nombre de un Role
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Modifica el nombre de un Role
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
