package es.miguelgs.amigoinvisible.domain.notificacion;

import org.springframework.mail.javamail.JavaMailSender;

import freemarker.template.Configuration;

public class FactoriaNotificacionPorDefecto implements FactoriaNotificacion{
	private JavaMailSender mailSender;
	private Configuration templateConfiguration;

	public FactoriaNotificacionPorDefecto(JavaMailSender mailSender, Configuration templateConfiguration) {
		super();
		this.mailSender = mailSender;
		this.templateConfiguration = templateConfiguration;
	}
	
	public Notificacion notificacion(TipoNotificacion tipo, String receptor) {
		return tipo.notificacion(
					() -> new NotificacionPorEmail(this.mailSender, this.templateConfiguration, receptor), 
					() -> new NotificacionPorConsola(receptor));
	}

}
