package ar.edu.unlam.tallerweb1.infrastructure;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Evento;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEventoTest extends SpringTest {

    LocalDate fecha1 = LocalDate.of(2023, 5, 23);
    LocalDate fecha2 = LocalDate.of(2023, 7, 23);
    String localidad1 = "moron";
    String localidad2 = "nuñez";


    @Autowired
    private RepositorioEvento repositorio;


    @Test
    @Transactional
    @Rollback
    public void guardarUnEventoYPersistirlo(){
        Evento evento = dadoQueExisteUnEvento("Superclásico");
        Long id = cuandoGuardoEvento(evento);
        entoncesLoPuedoBuscarPorSuId(id);
    }

    @Test
    @Transactional @Rollback
    public void buscarEventoPorNombre(){
        Evento evento = dadoQueExisteUnEventoConNombre("Superclásico");
        Evento evento2 = dadoQueExisteUnEventoConNombre("Luis Miguel en Buenos Aires");

        Evento eventoBuscado = cuandoLoBuscoPorNombre("Superclásico");
        entoncesLoPuedoEncontrar(eventoBuscado);
    }

    @Test
    @Transactional @Rollback
    public void buscarEventosPorTipo(){
        dadoQuExistenEventos();
        List<Evento> eventos = cuandoLosBuscoPorTipo(TipoDeEvento.DEPORTIVO);
        entoncesLosPuedoEncontrar(eventos);
    }

    @Test
    @Transactional @Rollback
    public void buscarEventosPorTipoCultural(){
        dadoQuExistenEventos();
        List<Evento> eventos = cuandoLosBuscoPorTipo(TipoDeEvento.MUSICAL);
        entoncesLosPuedoEncontrarMusicales(eventos);
    }

    @Test
    @Transactional @Rollback
    public void buscarEventosPorFecha() {
        dadoQuExistenEventos();
        List<Evento> eventos = cuandoLosBuscoPorFecha(fecha1);
        entoncesLosEncuentroPorFecha(eventos);
    }

    @Test
    @Transactional @Rollback
    public void buscarEventosPorLocalidad() {
        dadoQuExistenEventos();
        List<Evento> eventos = cuandoLosBuscoPorLocalidad(localidad1);
        entoncesLosEncuentroPorLocalidad(eventos);
    }

    private void entoncesLosEncuentroPorLocalidad(List<Evento> eventos) {
        assertThat(eventos.size()).isEqualTo(4);
    }

    private List<Evento> cuandoLosBuscoPorLocalidad(String localidad) {
        return repositorio.buscarPorLocalidadDeEvento(localidad);
    }

    private void entoncesLosEncuentroPorFecha(List<Evento> eventos) {
        assertThat(eventos.size()).isEqualTo(4);
    }

    private List<Evento> cuandoLosBuscoPorFecha(LocalDate fecha1) {
        return repositorio.buscarPorFechaDeEvento(fecha1);
    }


    private void entoncesLosPuedoEncontrarMusicales(List<Evento> eventos) {
        assertThat(eventos).hasSize(5);
    }

    private void entoncesLosPuedoEncontrar(List<Evento> eventos) {
        assertThat(eventos).hasSize(4);
    }

    private List<Evento> cuandoLosBuscoPorTipo(TipoDeEvento tipoDeEvento) {
        return repositorio.buscarPorTipoDeEvento(tipoDeEvento);
    }

    private List<Evento> dadoQuExistenEventos() {
        return generarEventos();
    }

    private Evento dadoQueExisteUnEventoConNombre(String nombre) {
        Evento evento = new Evento();
        evento.setNombre(nombre);
        repositorio.save(evento);
        return evento;
    }

    private void entoncesLoPuedoEncontrar(Evento eventoBuscado) {
        assertThat(eventoBuscado).isNotNull();
        assertThat(eventoBuscado.getNombre()).isEqualTo("Superclásico");
    }

    private Evento cuandoLoBuscoPorNombre(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    private void entoncesLoPuedoBuscarPorSuId(Long id) {
        Evento eventoBuscado= repositorio.buscarPorId(id);
        assertThat(eventoBuscado).isNotNull();
    }

    private Long cuandoGuardoEvento(Evento evento) {
        repositorio.save(evento);
        return evento.getId();
    }

    private Evento dadoQueExisteUnEvento(String nombre) {
        Evento evento = new Evento();
        evento.setNombre(nombre);
        return evento;
    }

    public List<Evento> generarEventos() {
        List<Evento> eventos = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Evento evento = crearEventoDeportivo();
            eventos.add(evento);
        }

        for (int i = 0; i < 5; i++) {
            Evento evento = crearEventoCultural();
            eventos.add(evento);
        }

        return eventos;
    }

    private Evento crearEventoDeportivo() {
        Evento evento = new Evento();
        evento.setNombre("Partido Copa Libertadores");
        evento.setFecha(fecha1);
        evento.setTipo(TipoDeEvento.DEPORTIVO);
        evento.setLocalidad(localidad1);
        repositorio.save(evento);
        return evento;
    }

    private Evento crearEventoCultural() {
        Evento evento = new Evento();
        evento.setNombre("Recital");
        evento.setFecha(fecha2);
        evento.setTipo(TipoDeEvento.MUSICAL);
        evento.setLocalidad(localidad2);
        repositorio.save(evento);
        return evento;
    }

}