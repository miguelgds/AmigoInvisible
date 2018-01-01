package es.miguelgs.amigoinvisible.domain.lectura;

import java.util.List;

import es.miguelgs.amigoinvisible.domain.Participante;
import es.miguelgs.amigoinvisible.domain.notificacion.FactoriaNotificacion;
import es.miguelgs.amigoinvisible.domain.notificacion.TipoNotificacion;

public class ParticipanteFila {

	private String nombre;
	private String email;
	private String tipoNotificacion;
	private List<String> restricciones;

	public ParticipanteFila(String nombre, String email, String tipoNotificacion, List<String> restricciones) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.tipoNotificacion = tipoNotificacion;
		this.restricciones = restricciones;
	}

	public Participante participante(FactoriaNotificacion factoriaNotificacion) {
		return new Participante(this.nombre, 
								factoriaNotificacion.notificacion(new TipoNotificacion(this.tipoNotificacion), this.email), 
								this.restricciones);
	}
}
