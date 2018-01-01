package es.miguelgs.amigoinvisible.domain.lectura;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilaFicheroParticipantes {

	private String filaFichero;

	public FilaFicheroParticipantes(String filaFichero) {
		super();
		validarFormatoFila(filaFichero);
		this.filaFichero = filaFichero;
	}
	
	public ParticipanteFila participanteFila() {
		List<String> noPuedeRegalarA = new ArrayList<>();
		
		String[] params = filaFichero.split("#");
		String nombre = params[0].trim();
		String tipoNotificacion = params[1].trim();
		String email = params[2].trim();		
		
		if(params.length == 4) {
			String restricciones = params[3].trim();
			noPuedeRegalarA.addAll(Arrays.asList(restricciones.split(",")));
		}
		return new ParticipanteFila(nombre, email, tipoNotificacion, noPuedeRegalarA);
	}
	
	private void validarFormatoFila(String fila){
		int numeroArgumentos = fila.split("#").length;
		if(numeroArgumentos < 3 || numeroArgumentos > 4) {
			throw new IllegalArgumentException("La fila no cumple el formato especificado: nombre # tipoNotificacion # email [# restriccion1, ..., restriccionN]");
		}
	}
}
