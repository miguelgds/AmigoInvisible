package es.miguelgs.amigoinvisible;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import es.miguelgs.amigoinvisible.domain.AmigoInvisible;
import es.miguelgs.amigoinvisible.domain.lectura.FicheroParticipantes;
import es.miguelgs.amigoinvisible.domain.notificacion.FactoriaNotificacionPorDefecto;
import freemarker.template.Configuration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmigoInvisibleTest {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration templateConfiguration;
	
	@Test
	public void sortearAmigoInvisible() {
		new AmigoInvisible(new FicheroParticipantes("/Users/Miguel/Desktop/amigoinvisible.txt", 
													new FactoriaNotificacionPorDefecto(this.mailSender, this.templateConfiguration))
							   .participantes())
		    .sortear();
	}

}
