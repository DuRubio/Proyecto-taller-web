package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Categoria;
import ar.edu.unlam.tallerweb1.domain.Evento;
import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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

        return  (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("correo", correo))
				.uniqueResult();
    }

    @Override
    public void hacerAdminEnBdd(Usuario usuario) {
        sessionFactory.getCurrentSession().saveOrUpdate(usuario);
    }
    
    @Override
	public void update(Usuario usuario) {
    	Session session = sessionFactory.getCurrentSession();
        session.update(usuario);
	}
	@Override
	public List<Categoria> obtenerMisCategoriasPreferidas(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT c FROM Categoria c JOIN c.usuariosPreferencia u WHERE u.id = :id_usuario";
		List<Categoria> categorias = session.createQuery(hql)
		        .setParameter("id_usuario", id) 
		        .getResultList();
	    
	    return categorias;
	}



}



