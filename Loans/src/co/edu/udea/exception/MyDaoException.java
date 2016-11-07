package co.edu.udea.exception;

import org.apache.log4j.Logger;
/**
 * Clase para controlar excepciones propias.
 * @author Oscar Zapata, Jonnatan Ríos, Diego Álvarez
 *
 */
public class MyDaoException extends Exception {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());

	public MyDaoException(String message, Throwable cause) {
		super(message, cause);
		log.error(message);
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}
}
