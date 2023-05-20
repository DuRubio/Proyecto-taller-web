package ar.edu.unlam.tallerweb1.infrastructure;


import ar.edu.unlam.tallerweb1.domain.Usuario;

public interface RepositorioUsuario {

    void save(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCorreo(String correo);
}
