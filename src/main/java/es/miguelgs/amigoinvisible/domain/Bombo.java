package es.miguelgs.amigoinvisible.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.vavr.control.Option;

public class Bombo {
	private List<Participante> participantes = new ArrayList<>();

	public Bombo(List<Participante> participantes) {
		super();
		this.participantes.addAll(participantes);
	}

	public Participante sacarAlguno() {		
		return Option.ofOptional(participantes.stream()
					 						  .findAny())
					 .peek(participantes::remove)
					 .getOrElseThrow(() -> new IllegalStateException("No se ha podido encontrar un participante"));
	}
	
	public Participante sacarAlgunoConExcepciones(Participante participanteExcluido) {
		return Option.ofOptional(participantes.stream()
					 						  .filter(p -> !p.equals(participanteExcluido))
					 						  .filter(p -> !participanteExcluido.noPuedeRegalarA().contains(p.nombre()))
					 						  .findAny())
					.peek(participantes::remove)
					.getOrElseThrow(() -> new IllegalStateException("No se ha podido encontrar un participante"));
	}

	public void mezclar(){
		if(participantes.size() > 1) {
			Collections.shuffle(participantes);
		}
	}
	
	public boolean quedanParticipantes() {
		return !participantes.isEmpty();
	}
}
