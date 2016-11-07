
package co.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.dao.UserDao;
import co.edu.udea.dto.User;
import co.edu.udea.exception.MyDaoException;

/**
 * Implementaci�n de la interface UserDao
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class UserDaoHibernate implements UserDao {
	
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
	 * @see co.edu.udea.dao.UserDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() throws MyDaoException {
		Session session = null;
		List<User> resultado = null;
		
		try{
			session = sessionFactory.openSession();
			
			Criteria crit = session.createCriteria(User.class);
			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.UserDao#get(java.lang.String)
	 */
	@Override
	public User get(String username) throws MyDaoException {
		Session session = null;
		User resultado = null;
		try{
			session = sessionFactory.openSession();
			resultado = (User)session.get(User.class, username);
			return resultado;
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.UserDao#save(co.edu.udea.dto.User)
	 */
	@Override
	public void save(User user) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.UserDao#update(co.edu.udea.dto.User)
	 */
	@Override
	public void update(User user) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}	

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.UserDao#delete(java.lang.String)
	 */
	@Override
	public void delete(String username) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		User user = new User();
		user.setUsername(username);
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}		

	}

}
