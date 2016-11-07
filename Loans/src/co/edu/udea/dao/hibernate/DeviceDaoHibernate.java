package co.edu.udea.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.dao.DeviceDao;
import co.edu.udea.dto.Device;
import co.edu.udea.exception.MyDaoException;

/**
 * Implementaci�n de la interface DeviceDao
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class DeviceDaoHibernate implements DeviceDao {
	
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
	 * @see co.edu.udea.dao.DeviceDao#getAll()
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> getAll() throws MyDaoException {
		Session session = null;
		List<Device> resultado = null;
		
		try{
			session = sessionFactory.openSession();
			
			Criteria crit = session.createCriteria(Device.class);
			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.dao.DeviceDao#get(java.lang.Long)
	 */
	
	@Override
	public Device get(Long id) throws MyDaoException {
		Session session = null;
		Device resultado = null;
		try{
			session = sessionFactory.openSession();
			resultado = (Device)session.get(Device.class, id);
			return resultado;
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.dao.DeviceDao#save(co.edu.udea.dto.Device)
	 */
	
	@Override
	public void save(Device device) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(device);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.dao.DeviceDao#update(co.edu.udea.dto.Device)
	 */
	
	@Override
	public void update(Device device) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(device);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}	

	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.dao.DeviceDao#delete(java.lang.Long)
	 */
	
	@Override
	public void delete(Long id) throws MyDaoException {
		Session session = null;
		Transaction tx = null;
		Device device = new Device();
		device.setId(id);	
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(device);
			tx.commit();
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}			

	}

}
