package co.edu.udea.bl.imp;

import co.edu.udea.bl.UserBL;
import co.edu.udea.dao.RoleDao;
import co.edu.udea.dao.UserDao;
import co.edu.udea.exception.MyDaoException;
import co.edu.udea.dto.Role;
import co.edu.udea.dto.User;
import co.edu.udea.utils.Cifrar;

/**
 * Implementa los metodos de la l�gica del negocio de los users
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class UserBLImp implements UserBL {
	private UserDao userDao;
	private RoleDao roleDao;
	
	/**
	 * Obtiene el userDao
	 * @return userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * Modifica el userDao
	 * @return userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * Obtiene el roleDao
	 * @return roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * Modifica el roleDao
	 * @return roleDao
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.bl.UserBL#signIn()
	 */
	@Override
	public boolean signIn(String username, String pws) throws MyDaoException {
		User user;
		boolean signin;
		signin = false;
		try{
			if(username == null || "".equals(username.trim())){
				throw new MyDaoException("Debe especificar el username", null);
			}
			user = userDao.get(username);
			if(user==null){
				return signin;
			}else{
				String contrasenaCifrada = Cifrar.cifrar(pws);
				if(user.getPassword().equals(contrasenaCifrada)){
					signin = true;
					return signin;
				}
				else{
					return signin;
				}
			}	
		}catch(MyDaoException e){
			throw new MyDaoException(e);
		}
	}

	@Override
	public String register(String username, String names, String lastnames, String password, String role) throws MyDaoException {
		if(username == null || "".equals(username.trim())){
			throw new MyDaoException("Debe especificar el username", null);
		}
		if(names == null || "".equals(names.trim())){
			throw new MyDaoException("Debe especificar los nombres", null);
		}
		if(lastnames == null || "".equals(lastnames.trim())){
			throw new MyDaoException("Debe especificar los apellidos", null);
		}
		if(password == null || "".equals(password.trim())){
			throw new MyDaoException("Debe especificar la contraseña", null);
		}
		if(role == null || "".equals(role.trim())){
			throw new MyDaoException("Debe especificar el rol", null);
		}
		
		Role roleDb = roleDao.get(role);
		
		if(roleDb == null){
			throw new MyDaoException("El rol no se encuentra en la base de datos", null);
		}
		
		User user = null;
		String encryptedPassword = null;
		user = new User();
		
		encryptedPassword = Cifrar.cifrar(password);
		user.setUsername(username);
		user.setNames(names);
		user.setLastnames(lastnames);
		user.setPassword(encryptedPassword);
		user.setRole(roleDb);
		
		userDao.save(user);
		
		return user.getUsername();
	}

	@Override
	public User getUser(String username) throws MyDaoException {
		User user;
		try{
			if(username == null || "".equals(username.trim())){
				throw new MyDaoException("Debe especificar el username", null);
			}
			user = userDao.get(username);
			return user;
		}catch(MyDaoException e){
			throw new MyDaoException(e);
		}
	}

}
