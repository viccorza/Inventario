package mcc.data;

import java.util.List;

import mcc.beans.Usuario;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Usuario entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mcc.beans.Usuario
 * @author MyEclipse Persistence Tools
 */
@Repository
public class UsuarioDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsuarioDAO.class);

	public void save(Usuario transientInstance) {
		log.debug("saving Usuario instance");
		Session session = getSession();
    	Transaction txt = session.beginTransaction();
		try {
			session.save(transientInstance);
			txt.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			txt.rollback();
			throw re;
		}
		finally {
        	session.close();
        }
	}

	public void delete(Usuario persistentInstance) {
		log.debug("deleting Usuario instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Usuario findById(java.lang.Integer id) {
		log.debug("getting Usuario instance with id: " + id);
		try {
			Usuario instance = (Usuario) getSession().get("mcc.beans.Usuario",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Usuario instance) {
		log.debug("finding Usuario instance by example");
		try {
			List results = getSession().createCriteria("mcc.beans.Usuario")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Usuario instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuario as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Usuario instances");
		try {
			String queryString = "from Usuario";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Usuario merge(Usuario detachedInstance) {
		log.debug("merging Usuario instance");
		try {
			Usuario result = (Usuario) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Usuario instance) {
		log.debug("attaching dirty Usuario instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	 /**
     * Obtiene toda la lista de usuarios
     * @return lista de usuarios
     */
	@SuppressWarnings("unchecked")
    public List<Usuario> buscarUsuarioPorApellido(String apellido) {
    	return getSession().createCriteria(Usuario.class)
				.add(Restrictions.ilike("apellido",apellido,MatchMode.ANYWHERE)).list();
  }
	
	/**
	 * Busca un usuario por id usuario y por password 
	 * @param idUsuario
	 * @param password
	 * @return
	 */
	public Usuario autenticarUsuarioPorIdUsuarioAndPassword(Integer idUsuario,String password){
		return (Usuario)getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("idUsuario", idUsuario)).add(Restrictions.eq("contrasena",password)).uniqueResult();
	}
	
}