package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Evento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Transactional
@Repository
public class RepositorioEventoImpl  implements RepositorioEvento{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEventoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Evento evento) {
        this.sessionFactory.getCurrentSession().save(evento);
    }

    @Override
    public List<Evento> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Evento> criteriaQuery = criteriaBuilder.createQuery(Evento.class);
        criteriaQuery.from(Evento.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return this.sessionFactory.getCurrentSession().get(Evento.class, id);
    }

    @Override
    public Evento buscarPorNombre(String nombre) {
        return (Evento) this.sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    @Override
    public List<Evento> buscarPorTipoDeEvento(TipoDeEvento tipoDeEvento) {
        List<Evento> eventos = this.sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .add(Restrictions.eq("tipo", tipoDeEvento))
                .list();
        return eventos;
    }

    @Override
    public List<Evento> buscarPorFechaDeEvento(Date fecha) {
        List<Evento> eventos = this.sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .add(Restrictions.eq("fecha", fecha))
                .list();
        return eventos;
    }

    @Override
    public List<Evento> buscarPorLocalidadDeEvento(String localidad) {
        List<Evento> eventos = this.sessionFactory.getCurrentSession().createCriteria(Evento.class)
                .add(Restrictions.eq("localidad", localidad))
                .list();
        return eventos;
    }


        /*Session session = this.sessionFactory.getCurrentSession();
        Query<Evento> query = session.createQuery("FROM Evento", Evento.class);
        return query.getResultList();*/

}
