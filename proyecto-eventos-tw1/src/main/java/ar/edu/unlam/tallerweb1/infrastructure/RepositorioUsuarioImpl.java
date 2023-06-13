package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@org.springframework.transaction.annotation.Transactional
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
	public void update(Usuario usuario) {
    	Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Usuario> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Usuario.class);
        Root<Usuario> root = criteriaUpdate.from(Usuario.class);
        criteriaUpdate.set(root.get("musical"), usuario.getMusical());
        criteriaUpdate.set(root.get("deportivo"), usuario.getDeportivo());
        criteriaUpdate.set(root.get("bailable"), usuario.getBailable());
        criteriaUpdate.set(root.get("teatral"), usuario.getTeatral());
        criteriaUpdate.set(root.get("recital"), usuario.getRecital());
        criteriaUpdate.set(root.get("cine"), usuario.getCine());
        criteriaUpdate.set(root.get("cultural"), usuario.getCultural());
        criteriaUpdate.set(root.get("gastronomico"), usuario.getGastronomico());
        criteriaUpdate.set(root.get("feria"), usuario.getFeria());
        criteriaUpdate.set(root.get("marcha"), usuario.getMarcha());
        criteriaUpdate.set(root.get("infantil"), usuario.getInfantil());
        criteriaUpdate.set(root.get("juvenil"), usuario.getJuvenil());
        criteriaUpdate.set(root.get("adultos"), usuario.getAdultos());
        criteriaUpdate.set(root.get("jubilados"), usuario.getJubilados());
        criteriaUpdate.set(root.get("todasLasEdades"), usuario.getTodasLasEdades());
        criteriaUpdate.set(root.get("aireLibre"), usuario.getAireLibre());
        criteriaUpdate.set(root.get("teatro"), usuario.getTeatro());
        criteriaUpdate.set(root.get("estadio"), usuario.getEstadio());
        criteriaUpdate.set(root.get("centroCultural"), usuario.getCentroCultural());
        criteriaUpdate.set(root.get("matutino"), usuario.getMatutino());
        criteriaUpdate.set(root.get("vespertino"), usuario.getVespertino());
        criteriaUpdate.set(root.get("nocturno"), usuario.getNocturno());
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), usuario.getId()));
        session.createQuery(criteriaUpdate).executeUpdate();
	}
	
	/*
	 * @Override
	public void update(Evento evento) {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaUpdate<Evento> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Evento.class);
    Root<Evento> root = criteriaUpdate.from(Evento.class);
    criteriaUpdate.set(root.get("nombre"), evento.getNombre());
    criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), evento.getId()));
    session.createQuery(criteriaUpdate).executeUpdate();
}
	 * 
	 * @Override
    public List<Evento> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Evento> criteriaQuery = criteriaBuilder.createQuery(Evento.class);
        criteriaQuery.from(Evento.class);
        return session.createQuery(criteriaQuery).getResultList();
    }
	 */
}



