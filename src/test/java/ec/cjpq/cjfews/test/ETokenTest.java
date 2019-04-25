package ec.cjpq.cjfews.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.sun.security.auth.callback.TextCallbackHandler;

import ec.cjpq.cjfews.util.X509Utils;
import ec.cjpq.util.Utileria;
import ec.gob.sri.firmaxades.test.FirmasGenericasXAdES;

public class ETokenTest {

	private static Logger log = LogManager.getLogger(ETokenTest.class);
	private String archivo 	= "/usr/local/fe/dir/cg/FA-1791867726001-29062009-001001000000001.xml";
	private String dirCF	= "/usr/local/fe/dir/cf";
	private String tokenID 	= "BCE_IKEY2032";
	private String rucApra	= "0992179155001";
	private String password	= "Aecb1959";

	public String abrirTokenLinux(String password){
		// "config" contains the same data as "keytool-etoken.cfg"
		//RUC DE LLAVE 099217914700
		String resultado = "OK";
		try {
			byte[] config = "name=eToken\nlibrary=/usr/lib/libeTPkcs11.so\n".getBytes("ISO-8859-1");
			//char[] clave = password.toCharArray();  // "token password"
			Provider provider = new sun.security.pkcs11.SunPKCS11(new ByteArrayInputStream(config));
			KeyStore ks = KeyStore.getInstance("PKCS11", provider);
			//ks.load(null, clave);
			ks.load(null, password.toCharArray());
			
			
			KeyStore.CallbackHandlerProtection pinHandler = new KeyStore.CallbackHandlerProtection(new TextCallbackHandler());
			Enumeration<String> keyAliases = ks.aliases();
		    while(keyAliases.hasMoreElements()){
		      String alias = keyAliases.nextElement();
		      log.warn("*** "+alias);
		      System.out.println(ks.getEntry(alias, pinHandler));
		    }

		    String aliaskey = "User Certificate"; // Signing Certificate, User Certificate
		    PrivateKey clavePrivada = (PrivateKey)ks.getKey(aliaskey, password.toCharArray());

	        FirmasGenericasXAdES firmador = new FirmasGenericasXAdES();
	        X509Certificate certificado = (X509Certificate)ks.getCertificate(aliaskey);
	        //certificado.checkValidity(new GregorianCalendar().getTime());

			log.warn("Mensaje...");
		} catch (Exception e) {
			resultado = Utileria.stack2String(e);
		}
		return resultado;
	}
	
	public void firmar(){
		String respuestaFirma = null;
		respuestaFirma = X509Utils.firmaValidaArchivo(new File(archivo), dirCF, "0992179147001", tokenID, password);
		if (respuestaFirma==null)
			System.out.println("Firma con token OK...");
			
	}

	@Test
	public void ejecutar(){
		//log.warn( abrirTokenLinux(password) );
		//firmar();
	}
}
