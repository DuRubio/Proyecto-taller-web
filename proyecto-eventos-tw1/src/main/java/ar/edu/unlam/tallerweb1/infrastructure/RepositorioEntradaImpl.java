package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Entrada;
import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public class RepositorioEntradaImpl implements RepositorioEntrada{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEntradaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void save(Entrada entrada) {
        sessionFactory.getCurrentSession().save(entrada);
    }

    @Override
    public Entrada buscarPorId(Long id) {
        return sessionFactory.getCurrentSession().get(Entrada.class, id);
    }
}
