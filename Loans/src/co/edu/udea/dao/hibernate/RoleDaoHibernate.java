/**
 * 
 */
package co.edu.udea.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.dao.RoleDao;
import co.edu.udea.dto.Device;
import co.edu.udea.dto.Role;
import co.edu.udea.exception.MyDaoException;

/**
 * Implementaci�n de la interface RoleDao
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class RoleDaoHibernate implements RoleDao {
private SessionFactory sessionFactory;
	
	/**
	 * Obtiene el sessionFactory
	 * @return sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Modifica el sessionFactory
	 * @return sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RoleDao#get(java.lang.String)
	 */
	@Override
	public Role get(String id) throws MyDaoException {
		Session session = null;
		Role resultado = null;
		try{
			session = sessionFactory.openSession();
			resultado = (Role)session.get(Role.class, id);
			return resultado;
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
	}

}
