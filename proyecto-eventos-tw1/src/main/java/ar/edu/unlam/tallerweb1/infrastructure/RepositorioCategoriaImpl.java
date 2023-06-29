package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.Categoria;
import ar.edu.unlam.tallerweb1.domain.Evento;

@Transactional
@Repository
public class RepositorioCategoriaImpl implements RepositorioCategoria{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioCategoriaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public Categoria buscarPorId(Long id) {
        return this.sessionFactory.getCurrentSession().get(Categoria.class, id);
    }

    @Override
    public Categoria buscarPorNombre(String nombre) {
        return (Categoria) this.sessionFactory.getCurrentSession().createCriteria(Categoria.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

	@Override
	public List<Categoria> findAll() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Categoria> criteriaQuery = criteriaBuilder.createQuery(Categoria.class);
        criteriaQuery.from(Categoria.class);
        return session.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Categoria> findById(List<Long> ids) {
	    Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<Categoria> query = criteriaBuilder.createQuery(Categoria.class);
	    Root<Categoria> root = query.from(Categoria.class);
	    query.select(root).where(root.get("id").in(ids));

	    return session.createQuery(query).getResultList();
	}

	@Override
	public List<Long> findPreferenciasById(Long id) {
	    Session session = sessionFactory.getCurrentSession();
	    Criteria criteria = session.createCriteria(Categoria.class);

	    // Crea una subcriteria para obtener los IDs de categorías que coinciden con el ID de usuario
	    Criteria subCriteria = criteria.createCriteria("usuariosPreferencia");
	    subCriteria.add(Restrictions.eq("id", id));
	    subCriteria.setProjection(Projections.property("id"));

	    // Obtén la lista de IDs de categorías
	    List<Long> idCategorias = subCriteria.list();

	    return idCategorias;
	}
	
	/*
	@Override
	public List<Categoria> findById(List<Long> ids) {
	    Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<Categoria> query = criteriaBuilder.createQuery(Categoria.class);
	    Root<Categoria> root = query.from(Categoria.class);
	    query.select(root).where(root.get("id").in(ids));
	    
	    return session.createQuery(query).getResultList();
	}

	@Override
	public List<Long> findPreferenciasById(Long id) {
	    Session session = sessionFactory.getCurrentSession();
	    Criteria criteria = session.createCriteria(Categoria.class);
	    
	    // Crea una subcriteria para obtener los IDs de categorías que coinciden con el ID de usuario
	    Criteria subCriteria = criteria.createCriteria("usuariosPreferencia");
	    subCriteria.add(Restrictions.eq("id", id));
	    subCriteria.setProjection(Projections.property("id"));
	    
	    // Obtén la lista de IDs de categorías
	    List<Long> idCategorias = subCriteria.list();
	    
	    return idCategorias;
	}
	*/

}
