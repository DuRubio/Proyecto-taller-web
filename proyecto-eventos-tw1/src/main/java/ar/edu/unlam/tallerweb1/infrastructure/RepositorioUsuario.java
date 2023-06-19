package ar.edu.unlam.tallerweb1.infrastructure;


import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.springframework.stereotype.Repository;


public interface RepositorioUsuario {

    void save(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCorreo(String correo);


    void hacerAdminEnBdd(Usuario usuario);

	void update(Usuario usuario);
}
