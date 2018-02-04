package es.miguelgs.amigoinvisible.domain;

import java.util.Collection;

public interface Regalador {

	void notificarARegalado(String nombreRegalado);
	Collection<String> noPuedeRegalarA();
}
