package es.miguelgs.amigoinvisible.domain.lectura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import es.miguelgs.amigoinvisible.domain.Participante;
import es.miguelgs.amigoinvisible.domain.notificacion.FactoriaNotificacion;

public class FicheroParticipantes {
	private String ruta;
	private FactoriaNotificacion factoriaNotificacion;

	public FicheroParticipantes(String ruta, FactoriaNotificacion factoriaNotificacion) {
		super();
		this.ruta = ruta;
		this.factoriaNotificacion = factoriaNotificacion;
	}
	
	public List<Participante> participantes(){
		return this.filasFichero()
				   .map(FilaFicheroParticipantes::new)
				   .map(FilaFicheroParticipantes::participanteFila)
				   .map(participanteFila -> participanteFila.participante(this.factoriaNotificacion))
				   .collect(Collectors.toList());
	}
	
	private Stream<String> filasFichero(){
		try {
			return Files.lines(Paths.get(ruta));
		} catch (IOException e) {
			throw new RuntimeException("No se puede leer el fichero", e);
		}
	}
}
