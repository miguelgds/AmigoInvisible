package es.miguelgs.amigoinvisible.domain;

public class Emparejamiento {
	private Regalador regalador;
	private Regalado regalado;

	public Emparejamiento(Regalador regalador, Regalado regalado) {
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
