package be.odisee.verhuursysteem_sharingbox.dao;

import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import be.odisee.verhuursysteem_sharingbox.domain.Rol;

class HibernateDao {

	SessionFactory sessionFactory;

	protected HibernateDao() {
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected void sessionSaveObject(Object o) {
		try {
			sessionFactory.getCurrentSession().save(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Object sessionGetObjectById(String classname, int id) {
		Object result = null;
		try {
			result = sessionFactory.getCurrentSession().createQuery("from " + classname + " where id=" + id)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Object getLastObjectOfQuery(String qstr) {
		Object result = null;
		try {
			@SuppressWarnings("rawtypes")
			List list = sessionFactory.getCurrentSession().createQuery(qstr).list();
			// als er geen objecten in het resultaat zitten, retourneren we
			// result = null
			if (!list.isEmpty())
				result = list.get(list.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Object sessionGetObjectBy1StringParameterNamedQuery(String qstr, String parameter, String value) {

		// geeft een antlr probleem .. voorlopig is er geen oplossing voor

		Query query = null;
		Object result = null;
		try {
			query = sessionFactory.getCurrentSession().createQuery(qstr);
			query.setString(parameter, value);
			result = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Object sessionGetObjectByStringParameterValue(String classname, String parameter, String value) {
		Object result = null;
		try {
			result = sessionFactory.getCurrentSession()
					.createQuery("from " + classname + " where " + parameter + "='" + value + "'").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Object sessionGetObjectByQuery(String qstr) {
		// work around omdat vorige niet werkt

		Object result = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(qstr);
			result = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	protected List sessionGetAllObjects(String classname) {
		Query query = null;
		List result = null;
		try {
			query = sessionFactory.getCurrentSession().createQuery("from " + classname);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

	@SuppressWarnings("rawtypes")
	protected List sessionGetAllObjectsByQuery(String qstr) {
		Query query = null;
		List result = null;
		try {
			query = sessionFactory.getCurrentSession().createQuery(qstr);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	protected ArrayList<Aanvraag> sessionGetAllObjectsWithJoinKlant() {
		Query query = null;
		List<Object[]> results = null;
		ArrayList<Aanvraag> returnValue = new ArrayList<Aanvraag>();
		try {

			query = sessionFactory.getCurrentSession().createSQLQuery(
					"select a.id, a.datum, a.adres, p.voornaam, p.familienaam from aanvragen a, rollen r, personen p where a.klant_id=r.id and r.persoon_id=p.id and a.status = :status");
			query.setParameter("status", "in behandeling");
			results = query.list();

			for (Object[] row : results) {
				Aanvraag aan = new Aanvraag();
				aan.setId(Integer.parseInt(row[0].toString()));
				System.out.println("Hier is de ID : " + aan.getId());
				aan.setDatum(row[1].toString());
				System.out.println("Hier is de datum : " + aan.getDatum());
				aan.setAdres(row[2].toString());
				System.out.println("Hier is het adres : " + aan.getAdres());

				Persoon persoon = new Persoon();
				persoon.setStatus("status");
				persoon.setVoornaam(row[3].toString());
				persoon.setFamilienaam(row[4].toString());
				persoon.setEmailadres("test");
				persoon.setPaswoord("test");
				Klant klant = new Klant(persoon.getId(), "test", "test", persoon);
				aan.setM_Klant(klant);
				returnValue.add(aan);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	protected void sessionUpdateObject(Object o) {
		try {
			sessionFactory.getCurrentSession().update(o);
			sessionFactory.getCurrentSession().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	protected void sessionDeleteObject(Object o) {
		Session session = sessionFactory.getCurrentSession();

		try {

			session.evict(o);
			session.delete(session.contains(o) ? o : session.merge(o));
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Foute boel !!");
		}

	}

}
