package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.Evento;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;


public class PersistenciaEventoTest extends SpringTest {

    @Test
    @Transactional @Rollback
    public void queSePuedaBuscarUnEventoPorId(){
        Evento superclasico = dadoQueExisteUnEvento();
        Long id = cuandoGuardoUnEvento(superclasico);
        entonocesLoPuedoBuscarPorId(id);
    }

    private void entonocesLoPuedoBuscarPorId(Long id) {
        Evento eventoBuscado = session().get(Evento.class, id);
        assertThat(eventoBuscado).isNotNull();
    }

    private Long cuandoGuardoUnEvento(Evento evento) {
        session().save(evento);
        return evento.getId();
    }

    private Evento dadoQueExisteUnEvento() {
        Evento evento = new Evento();
        evento.setNombre("Superclásico");
        return evento;
    }



}
