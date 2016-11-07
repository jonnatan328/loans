package co.edu.udea.dao;

import co.edu.udea.dto.Role;
import co.edu.udea.exception.MyDaoException;

/**
* Define los metodos para acceder a los roles
* @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
*
*/
public interface RoleDao {
	/**
	 * Entrega los datos de un rol dado su id
	 * @param id
	 * @return Role
	 * @throws MyDaoException
	 */
	public Role get(String id) throws MyDaoException;
}
