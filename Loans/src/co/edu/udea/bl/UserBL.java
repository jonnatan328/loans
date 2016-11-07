package co.edu.udea.bl;

import co.edu.udea.exception.MyDaoException;

/**
 * Define los metodos de la l�gica del negocio de los users
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public interface UserBL {
	/**
	 * Regista un nuevo usuario en la bd
	 * @param username, password, names, lastnames, password, role
	 * @return true or false
	 */
	public String register(String username, String names, String lastnames, String password, String role) throws MyDaoException;
	/**
	 * Valida que los campos nombre y password ingresados por el usuario esten en la bd
	 * @param username, password
	 * @return true or false
	 */
	public boolean signIn(String username, String pws) throws MyDaoException;
	
}
