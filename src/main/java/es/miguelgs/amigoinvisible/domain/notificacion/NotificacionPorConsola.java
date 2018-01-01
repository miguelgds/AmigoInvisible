package es.miguelgs.amigoinvisible.domain.notificacion;

public class NotificacionPorConsola implements Notificacion {

	private String nombreRegalador;

	public NotificacionPorConsola(String nombreRegalador) {
		super();
		this.nombreRegalador = nombreRegalador;
	}

	@Override
	public void enviarNotificacion(String nombreRegalado) {
		System.out.println(String.format("%s este año le regalas a %s", nombreRegalador, nombreRegalado));
	}

}
