package ar.edu.unlam.tallerweb1.domain;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Entrada {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;


    public Entrada (){};
    public Entrada (Long id){
        this.Id = id;
    };

    public Entrada (Usuario usuario, Evento evento){
        this.usuario = usuario;
        this.evento = evento;
    }

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
	@Override
	public int hashCode() {
		return Objects.hash(Id, evento, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(evento, other.evento)
				&& Objects.equals(usuario, other.usuario);
	}


}
