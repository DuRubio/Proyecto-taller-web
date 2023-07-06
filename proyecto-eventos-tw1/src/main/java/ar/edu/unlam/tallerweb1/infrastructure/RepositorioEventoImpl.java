package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.delivery.TipoDeEvento;
import ar.edu.unlam.tallerweb1.domain.Categoria;
import ar.edu.unlam.tallerweb1.domain.Evento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

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
       /* Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Evento> criteriaQuery = criteriaBuilder.createQuery(Evento.class);
        criteriaQuery.from(Evento.class);
        return session.createQuery(criteriaQuery).getResultList();*/

        String hql = "FROM Evento WHERE eventoActivo = true ORDER BY id";
        return (List<Evento>)sessionFactory.getCurrentSession()
                .createQuery(hql, Evento.class).list();
    }

    @Override
    public List<Evento> buscarEventosConFiltros(LocalDate fecha, String ciudad, TipoDeEvento tipo) {
        return null;
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
    public List<Evento> buscarPorTipoDeEvento(Long categoria) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Evento.class);
        criteria.createAlias("categoria", "c");
        criteria.add(Restrictions.eq("c.id", categoria));
        criteria.add(Restrictions.eq("eventoActivo", true));
        List<Evento> eventos = criteria.list();
        return eventos;
    }

    @Override
    public List<Evento> buscarPorFechaDeEvento(LocalDate fecha) {
    	Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Evento.class);
        criteria.add(Restrictions.eq("fecha", fecha));
        criteria.add(Restrictions.eq("eventoActivo", true));
        List<Evento> eventos = criteria.list();
        return eventos;
    }
       @Override
    public List<Evento> buscarPorLocalidadDeEvento(String localidad) {
           List<Evento> eventos = this.sessionFactory.getCurrentSession().createCriteria(Evento.class)
                   .add(Restrictions.eq("localidad", localidad))
                   .add(Restrictions.eq("eventoActivo", true))
                   .list();
           return eventos;
       }

    @Override
    public List<Evento> findFirst4Events() {
    	String hql = "FROM Evento WHERE eventoActivo = true ORDER BY id";
		return (List<Evento>)sessionFactory.getCurrentSession()
				.createQuery(hql, Evento.class).setMaxResults(4).list();
    }

    
    @Override
    public List<Evento> buscarEventosPorPreferencias(Long idUsuario) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Evento.class);

        // Crea una subcriteria para obtener los IDs de categor�as que coinciden con el ID de usuario
        Criteria subCriteria = criteria.createCriteria("categoria", "c");
        subCriteria.createAlias("usuariosPreferencia", "u");
        subCriteria.add(Restrictions.eq("u.id", idUsuario));

        // Obt�n la lista de eventos
        List<Evento> eventos = criteria.list();

        return eventos;
    }
    @Override
    public void setInactivo(Evento evento) {
        Session session = sessionFactory.getCurrentSession();
        evento.setEventoActivo(false);
        session.update(evento);
    }

    
    /*
    @Override
    public List<Evento> buscarEventosPorPreferencias(List<Long> idsCategorias) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Evento.class);
        
        // Crea un alias para la asociaci�n de Evento con Categoria
        criteria.createAlias("categoria", "c");
        
        // Agrega una restricci�n para que el ID de la categor�a est� en el listado de idsCategorias
        criteria.add(Restrictions.in("c.id", idsCategorias));
        
        // Obt�n la lista de eventos
        List<Evento> eventos = criteria.list();
        
        return eventos;
    }
    */


}
