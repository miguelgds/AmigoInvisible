package es.miguelgs.amigoinvisible.domain;

public class SorteoEmparejamiento {

	private Bombo bomboRegaladores;
	private Bombo bomboRegalados;

	public SorteoEmparejamiento(Bombo bomboRegaladores, Bombo bomboRegalados) {
		super();
		this.bomboRegaladores = bomboRegaladores;
		this.bomboRegalados = bomboRegalados;
	}

	public Emparejamiento emparejamiento(){
		this.bomboRegaladores.mezclar();
		Participante regalador = this.bomboRegaladores.sacarAlguno();
		
		this.bomboRegalados.mezclar();
		Participante regalado = this.bomboRegalados.sacarAlgunoConExcepciones(regalador);
		
		return new Emparejamiento(regalador, regalado);		
	}
}
