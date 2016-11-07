package co.edu.udea.exception;

import org.apache.log4j.Logger;
/**
 * Clase para controlar excepciones propias.
 * @author Oscar Zapata, Jonnatan R�os, Diego �lvarez
 *
 */
public class MyBLException extends Exception {
	private static final long serialVersionUID = 2L;
	Logger log = Logger.getLogger(this.getClass());

	public MyBLException(String message, Throwable cause) {
		super(message, cause);
		log.error(message);
	}

	public MyBLException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}
}
