package es.miguelgs.amigoinvisible.domain.notificacion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class TipoNotificacion {

	private static final String NOTIFICACION_POR_EMAIL = "EMAIL";
	private static final String NOTIFICACION_POR_CONSOLA = "CONSOLA";
	private static final List<String> tiposNotificacionSoportadas = Arrays.asList(NOTIFICACION_POR_CONSOLA, NOTIFICACION_POR_EMAIL); 
	private String tipoNotificacion;

	public TipoNotificacion(String tipoNotificacion) {
		super();
		if(!tiposNotificacionSoportadas.contains(tipoNotificacion)) {
			throw new IllegalArgumentException("El tipo de notificacion " + tipoNotificacion + " no está soportada");
		}
		this.tipoNotificacion = tipoNotificacion;
	}
	
	public Notificacion notificacion(Supplier<NotificacionPorEmail> constructorNotificacionPorEmail, 
									 Supplier<NotificacionPorConsola> constructorNotificacionPorConsola) {
		if(NOTIFICACION_POR_CONSOLA.equals(this.tipoNotificacion)) {
			return constructorNotificacionPorConsola.get();
		} else if(NOTIFICACION_POR_EMAIL.equals(this.tipoNotificacion)) {
			return constructorNotificacionPorEmail.get();
		} else {
			throw new IllegalArgumentException("El tipo de notificacion " + this.tipoNotificacion + " no está soportada");
		}
	}
	
}
