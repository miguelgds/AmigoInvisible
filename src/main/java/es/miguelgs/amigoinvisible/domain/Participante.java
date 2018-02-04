package es.miguelgs.amigoinvisible.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import es.miguelgs.amigoinvisible.domain.notificacion.Notificacion;

public class Participante implements Regalador, Regalado {
	private String nombre;
	private Collection<String> noPuedeRegalarA;
	private Notificacion notificador;

	public Participante(String nombre, Notificacion notificador) {
		this(nombre, notificador, Collections.emptyList());
	}
	
	public Participante(String nombre, Notificacion notificador, Collection<String> noPuedeRegalarA) {
		super();
		this.nombre = nombre;
		this.notificador = notificador;
		this.noPuedeRegalarA = noPuedeRegalarA;
	}
	
	@Override
	public String nombre() {
		return this.nombre;
	}
	
	public Collection<String> noPuedeRegalarA(){
		return new ArrayList<>(this.noPuedeRegalarA);
	}

	@Override
	public void notificarARegalado(String nombreRegalado) {
		this.notificador.enviarNotificacion(nombreRegalado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", noPuedeRegalarA=" + noPuedeRegalarA + ", notificador="
				+ notificador + "]";
	}

	
}
