package br.com.envioemail.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Ignore;
import org.junit.Test;

public class ServicoEmail {
	
@Test	
public void emailComHtml() {
		
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(false);
		email.setHostName( "smtp.sendgrid.net" );
		email.setDebug(true);
		email.setSmtpPort(587);
		email.setAuthenticator( new DefaultAuthenticator( "usuarioSendGrid" ,  "senhaSenGrid" ) );
		try {
		    email.setFrom( "enviando_email@com.br" , "Serviço de Email");
		    email.setDebug(true); 
		    email.setSubject( "Email com anexo" );
		   
		    EmailAttachment anexo = new EmailAttachment();
		    anexo.setPath("Email.jpg");
		    anexo.setDisposition(EmailAttachment.ATTACHMENT);
		    anexo.setName("foto.png");		             
		   
		    
		    StringBuilder builder = new StringBuilder();
		    builder.append("<html>"
		    		+ "<body>"
		    		+ "<h1>E-mail com anexo</h1>"
		    		+ "<p>Olá Usuário,<br/> Enviando e-mail usando HTML com anexo <br/> Atenciosamente.<br/></p>"
		    		+ "<p>Usuário</p>"
		    		+ "<img src=\"https://commons.apache.org/proper/commons-email/images/email-logo-white.png\">"
		    		+ "<body>"
		    		+ "<html>");
		    
		    email.attach(anexo);
		    email.setHtmlMsg( builder.toString() );
		    email.addTo("emaildodestino@.com");
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
		
	}
@Test
@Ignore
  public void emailSimples(){
	  SimpleEmail emailSimples = new SimpleEmail();
	  try {
	  emailSimples.setHostName("smtp.sendgrid.net");
	  emailSimples.setSmtpPort(587);
	  emailSimples.setAuthentication("usuarioSendGrid", "senhaSenGrid");
		emailSimples.setFrom("emailsimples@com.br", "E-mail simples");
	  emailSimples.setDebug(true);
	  emailSimples.setSubject("Email Simples");
	  emailSimples.addTo("emaildodestino@.com");
	  emailSimples.setMsg("Enviando e-mail simples");
	  emailSimples.send();
	  } catch (EmailException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
  }

@Test
@Ignore
public void emailComAnexo(){
	
	  try {  
		  EmailAttachment anexo = new EmailAttachment();
		    anexo.setPath("arquivo.txt");
		    anexo.setDisposition(EmailAttachment.ATTACHMENT);
		    anexo.setName("arquivo texto");
		    
          MultiPartEmail email = new MultiPartEmail();  
          email.setDebug(true);  
          email.setHostName("smtp.sendgrid.net");  
          email.setSmtpPort(587);
          email.setAuthentication("senhaSenGrid","senhaSenGrid");  
          email.setDebug(true);
          email.addTo("emaildodestino@.com"); 
          email.setFrom("emailanexo@com.br");
          email.setSubject("Teste anexo");  
          email.setMsg("Enviando e-mail com anexo");  
          email.attach(anexo);   
          email.send();  
      } catch (EmailException e) {  
          e.printStackTrace();  
      }  
  }  
	
}
