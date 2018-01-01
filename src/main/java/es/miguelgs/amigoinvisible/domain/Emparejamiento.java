package es.miguelgs.amigoinvisible.domain;

public class Emparejamiento {
	private Participante regalador;
	private Participante regalado;

	public Emparejamiento(Participante regalador, Participante regalado) {
		super();
		this.regalador = regalador;
		this.regalado = regalado;
	}

	public void notificar() {
		regalador.notificarARegalado(regalado.nombre());
	}
	
	@Override
	public String toString() {
		return "Emparejamiento [regalador=" + regalador + ", regalado=" + regalado + "]";
	}
	
}
