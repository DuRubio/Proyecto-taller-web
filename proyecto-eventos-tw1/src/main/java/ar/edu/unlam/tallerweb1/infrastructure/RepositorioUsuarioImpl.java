package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class RepositorioUsuarioImpl implements RepositorioUsuario  {

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioUsuarioImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void save(Usuario usuario) {
        sessionFactory.getCurrentSession().save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return sessionFactory.getCurrentSession().get(Usuario.class, id);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {

        return (Usuario) sessionFactory.getCurrentSession()
                .createCriteria(Usuario.class)
                .add(Restrictions.eq("correo", correo))
                .uniqueResult();
    }
}



