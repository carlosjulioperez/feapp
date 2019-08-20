package ec.cjpq.cjfews.util;

import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.fe.util.Util;

public class EmailUtil{

	private static final Logger log = LogManager.getLogger(EmailUtil.class);

    public boolean sendEmail(Configuracion configuracion, Map <String, String>p){
 
    	boolean valor = false;
    	
    	try {
    		String cuerpoMensaje	= p.get("cuerpoMensaje");
    		String emailDestino		= p.get("emailDestino"); 
    		String nombreAdjunto	= p.get("nombreAdjunto");
    		String xmlAdjunto		= p.get("xmlAdjunto");
    		String pdfAdjunto		= p.get("pdfAdjunto");

    		String asunto 			= configuracion.getEmailAsunto();
    		String razonSocial 		= configuracion.getEmisorRazonSocial();
    		String puerto 			= ""+configuracion.getEmailPuertoTsl();
			String host 			= configuracion.getEmailHost();
			final String user 		= configuracion.getEmailUser();
			final String password	= configuracion.getEmailPassword();
			String emailCC			= configuracion.getEmailCc();
			String emailBCC			= configuracion.getEmailBcc();
			
			String starttls_enable	= configuracion.getEmailStartTlsEnable();
			starttls_enable = starttls_enable.equals("S") ? "true": "false";

			Properties mailProp  = new Properties();
			mailProp.put("mail.smtp.host", 				host); // 
			mailProp.put("mail.smtp.port", 				puerto); // TLS Port
			mailProp.put("mail.smtp.auth", 				"true"); // Enable Authentication
			mailProp.put("mail.transport.protocol", 	"smtp");
			mailProp.put("mail.smtp.starttls.enable", 	starttls_enable); // Enable StartTLS
			
//			Authenticator auth = new SMTPAuthenticator(); //2014-12-23
//			Session session = Session.getDefaultInstance(mailProp, auth); //2014-12-23
   
			Session session = Session.getInstance(mailProp, 
				new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(user ,password);
	                }
				}
			);
			
			MimeMessage msg = new MimeMessage(session);
			msg.setHeader("Content-type", "text/html; charset=UTF-8");

			//2014-12-26
			msg.setFrom(new InternetAddress(user));
			
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));
			
			if (emailCC != null && emailCC.length() > 0)
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(emailCC));
				
			if (emailBCC != null && emailBCC.length() > 0)
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(emailBCC));
			//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("carlosjulio3ec@yahoo.com"));
			
			String mensajeAsunto = asunto+" "+razonSocial;
			msg.setSubject(mensajeAsunto, "UTF-8");
			msg.setSentDate(new Date());
			
			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Cuerpo del mensaje
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(cuerpoMensaje, "text/html");
			multipart.addBodyPart(messageBodyPart);
			
			// Archivo adjunto XML
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(xmlAdjunto);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(nombreAdjunto+".xml");
			multipart.addBodyPart(messageBodyPart);

			// Archivo adjunto PDF
			messageBodyPart = new MimeBodyPart();
			source = new FileDataSource(pdfAdjunto);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(nombreAdjunto+".pdf");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);			
			
			//Step3 System.out.println("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = session.getTransport();
			transport.connect();
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			valor = true;
		} catch (Exception e) {
			log.warn(Util.stack2String(e));
		}
    	return valor;
    }

}
