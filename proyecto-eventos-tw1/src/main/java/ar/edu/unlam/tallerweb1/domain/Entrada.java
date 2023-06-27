package ar.edu.unlam.tallerweb1.domain;

import javax.persistence.*;

@Entity
public class Entrada {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Entrada (){};
    public Entrada (Long id){
        this.Id = id;
    };

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean asignarUsuarioYEvento(Usuario usuario, Evento evento) {
        //Entrada entrada = new Entrada();
        this.usuario=usuario;
        this.evento=evento;
        evento.asignarEntrada(this);
        usuario.asignarEntrada(this);

        return false;
    }
}
