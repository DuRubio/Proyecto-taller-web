package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Entrada;
import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    
	@Override
	public List<Entrada> buscarMisEntradas(Long usuarioId) {
		Session session = sessionFactory.getCurrentSession();
	    Criteria criteria = session.createCriteria(Entrada.class);
	    criteria.createAlias("usuario", "u");
	    criteria.add(Restrictions.eq("u.id", usuarioId));
	    List<Entrada> entradas = criteria.list();
	    return entradas;
	}
}
