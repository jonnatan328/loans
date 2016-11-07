package co.edu.udea.dao;

import java.util.List;

import co.edu.udea.dto.User;
import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos para acceder a los usuarios
 * @author Oscar Zapata, Jonnatan Ríos, Diego Álvarez
 *
 */
public interface UserDao {
	
	/**
	 * Entrega la lista de usuarios disponibles en la bd
	 * @return Lista de usuarios
	 * @throws MyDaoException cuando hay algï¿½n problema en la conexiï¿½n
	 */
	public List<User> getAll() throws MyDaoException;
	
	/**
	 * Entrega los datos de un usuario dado su username
	 * @param username
	 * @return
	 * @throws MyDaoException
	 */
	public User get(String username) throws MyDaoException;
	
	/**
	 * Permite crear un nuevo usuario en la base de datos
	 * @param User Dto con los datos del usuario a crear
	 * @throws MyDaoException
	 */
	public void save(User user) throws MyDaoException;
	
	/**
	 * Actualiza la informaciï¿½n de un usuario en la base de datos
	 * 
	 * @param User informaciï¿½n de usuario a modificar
	 * @throws MyDaoException
	 */
	public void update(User user) throws MyDaoException;
	
	/**
	 * Elimna un usuario de la base de datos
	 * @param username de la solicitud
	 * @throws MyDaoException
	 */
	public void delete(String username) throws MyDaoException;

}
