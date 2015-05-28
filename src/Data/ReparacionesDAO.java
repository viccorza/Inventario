package Data;
// default package

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Reparaciones entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Reparaciones
 * @author MyEclipse Persistence Tools
 */
public class ReparacionesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReparacionesDAO.class);
	// property constants
	public static final String PERSONAL_SOPORTE_ID_PERSONAL_SOPORTE = "personalSoporteIdPersonalSoporte";

	public void save(Reparaciones transientInstance) {
		log.debug("saving Reparaciones instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reparaciones persistentInstance) {
		log.debug("deleting Reparaciones instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reparaciones findById(ReparacionesId id) {
		log.debug("getting Reparaciones instance with id: " + id);
		try {
			Reparaciones instance = (Reparaciones) getSession().get(
					"Reparaciones", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Reparaciones instance) {
		log.debug("finding Reparaciones instance by example");
		try {
			List results = getSession().createCriteria("Reparaciones")
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
		log.debug("finding Reparaciones instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Reparaciones as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPersonalSoporteIdPersonalSoporte(
			Object personalSoporteIdPersonalSoporte) {
		return findByProperty(PERSONAL_SOPORTE_ID_PERSONAL_SOPORTE,
				personalSoporteIdPersonalSoporte);
	}

	public List findAll() {
		log.debug("finding all Reparaciones instances");
		try {
			String queryString = "from Reparaciones";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reparaciones merge(Reparaciones detachedInstance) {
		log.debug("merging Reparaciones instance");
		try {
			Reparaciones result = (Reparaciones) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reparaciones instance) {
		log.debug("attaching dirty Reparaciones instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reparaciones instance) {
		log.debug("attaching clean Reparaciones instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}