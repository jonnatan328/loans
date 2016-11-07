package co.edu.udea.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Define metodos de utilidad para la aplicación
 * @author Oscar Zapata, Jonnatan Ríos, Diego Álvarez
 *
 */

public class Cifrar {
	
	/**
	 * cifra la cadena de caracteres ingresada como parametro
	 * @author Jonnatan Rios - jrios328@gmail.com
	 *
	 */
	public static String cifrar(String pws){
		String sha1;
		sha1 = DigestUtils.sha1Hex(pws);
		return sha1;
	}
}
