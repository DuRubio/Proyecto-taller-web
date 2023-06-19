package ar.edu.unlam.tallerweb1.infrastructure;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.Categoria;

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

}
