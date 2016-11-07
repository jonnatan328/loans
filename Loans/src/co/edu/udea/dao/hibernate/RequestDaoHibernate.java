/**
 * 
 */
package co.edu.udea.dao.hibernate;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.dao.RequestDao;
import co.edu.udea.dto.Device;
import co.edu.udea.dto.Request;
import co.edu.udea.exception.MyDaoException;

/**
 * Implementaci�n de la interface RequestDao
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class RequestDaoHibernate implements RequestDao {

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
	 * @see co.edu.udea.dao.RequestDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAll() throws MyDaoException {
		Session session = null;
		List<Request> resultado = null;
		
		try{
			session = sessionFactory.openSession();			
			Criteria crit = session.createCriteria(Request.class);			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#get(java.lang.Long)
	 */
	@Override
	public Request get(Long id) throws MyDaoException {
		Session session = null;
		Request resultado = null;
		try{
			session = sessionFactory.openSession();
			resultado = (Request)session.get(Request.class, id);
			return resultado;
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#save(co.edu.udea.dto.Request)
	 */
	@Override
	public void save(Request request) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(request);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#update(co.edu.udea.dto.Request)
	 */
	@Override
	public void update(Request request) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(request);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		Request request = new Request();
		request.setId(id);
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(request);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}		


	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#getAllDateRequest()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAllDateRequest(Date dateRequest) throws MyDaoException {
		Session session = null;
		List<Request> resultado = null;
		
		try{
			session = sessionFactory.openSession();			
			Criteria crit = session.createCriteria(Request.class);	
			crit.add(Restrictions.eq("dateRequest", dateRequest));
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#getAllStartTime()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAllStartTime(Calendar startTime) throws MyDaoException {
		Session session = null;
		List<Request> resultado = null;
		
		try{
			session = sessionFactory.openSession();			
			Criteria crit = session.createCriteria(Request.class);	
			crit.add(Restrictions.eq("startTime", startTime));
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#getAllState()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAllState(String state) throws MyDaoException {
		Session session = null;
		List<Request> resultado = null;
		
		try{
			session = sessionFactory.openSession();			
			Criteria crit = session.createCriteria(Request.class);	
			crit.add(Restrictions.eq("state", state));
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.RequestDao#getAllDevice()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAllDevice(Device device) throws MyDaoException {
		Session session = null;
		List<Request> resultado = null;
		
		try{
			session = sessionFactory.openSession();			
			Criteria crit = session.createCriteria(Request.class);	
			crit.add(Restrictions.eq("device", device));
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;	}

}
