package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Evento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class RepositorioEventoImpl implements RepositorioEvento {

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

    @Override
    public List<Evento> listarEventos() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Evento> criteriaQuery = builder.createQuery(Evento.class);
            Root<Evento> root = criteriaQuery.from(Evento.class);
            criteriaQuery.select(root);
            Query<Evento> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
        /*Session session = this.sessionFactory.getCurrentSession();
        Query<Evento> query = session.createQuery("FROM Evento", Evento.class);
        return query.getResultList();*/

}
