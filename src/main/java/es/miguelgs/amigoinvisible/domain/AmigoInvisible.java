package es.miguelgs.amigoinvisible.domain;

import java.util.ArrayList;
import java.util.List;

import rx.Completable;
import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

public class AmigoInvisible {
	private List<Participante> participantes;
	
	public AmigoInvisible(List<Participante> participantes) {
		super();
		this.participantes = new ArrayList<>(participantes);
	}

	public void sortear(){
		List<Emparejamiento> emparejamientos = new ArrayList<>();
		
		Bombo bomboRegaladores = new Bombo(participantes);
		Bombo bomboRegalados = new Bombo(participantes);
		
		while(bomboRegaladores.quedanParticipantes()){
			emparejamientos.add(new SorteoEmparejamiento(bomboRegaladores, bomboRegalados)
									.emparejamiento());
		}
		notificarEmparejamientos(emparejamientos);
	}
	
	private void notificarEmparejamientos(List<Emparejamiento> emparejamientos) {
		TestSubscriber<Object> ts = new TestSubscriber<>();

		Observable.from(emparejamientos)
				  .flatMap(emparejamiento -> Completable.fromAction(() -> emparejamiento.notificar())
						  								.subscribeOn(Schedulers.io())
						  								.toObservable())
				  .subscribe(ts);
		
		ts.awaitTerminalEvent();
	}
	
}
