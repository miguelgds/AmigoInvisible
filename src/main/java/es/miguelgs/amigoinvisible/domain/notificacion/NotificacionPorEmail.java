package es.miguelgs.amigoinvisible.domain.notificacion;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class NotificacionPorEmail implements Notificacion{
	
	private JavaMailSender mailSender;
	private Configuration templateConfiguration;
	private String email;

	public NotificacionPorEmail(JavaMailSender mailSender, Configuration templateConfiguration, String email) {
		super();
		this.mailSender = mailSender;
		this.templateConfiguration = templateConfiguration;
		this.email = email;
	}
	
	@Override
	public void enviarNotificacion(String nombreRegalado) { 
		try {
			MimeMessage message = mailSender.createMimeMessage();
			 
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	      
	        templateConfiguration.setClassForTemplateLoading(this.getClass(), "/templates");
	        
	        Template t = templateConfiguration.getTemplate("amigoinvisible.ftl");
			
	        Map<String, Object> templateParams = new HashMap<>();
	        templateParams.put("regalado", nombreRegalado);
	        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, templateParams);
	        
	        helper.setFrom("Amigo Invisible <mail@email.com>");
	        helper.setTo(email);
	        helper.setText(text, true);
	        helper.setSubject("Sorteo del amigo invisible " + LocalDate.now().getYear());
	 
	        mailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return "NotificacionPorEmail [mailSender=" + mailSender + ", templateConfiguration=" + templateConfiguration
				+ ", email=" + email + "]";
	}
	
	
}
