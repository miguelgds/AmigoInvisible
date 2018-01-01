package es.miguelgs.amigoinvisible.domain.notificacion;

public interface FactoriaNotificacion {
	Notificacion notificacion(TipoNotificacion tipo, String receptor);
}
