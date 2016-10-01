package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installateur;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;

@Repository("AfbraakDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AfbraakHibernateDAO extends HibernateDao implements AfbraakDAO {

	@Override
	public Afbraak addAfbraak(int id, String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken) {
		Afbraak Afbraak = new Afbraak(id, status, datum, verhuring, m_Installateur_Afbraken);
		sessionSaveObject(Afbraak);
		return Afbraak;
	}

	@Override
	public Afbraak addAfbraak(String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken) {
		Afbraak Afbraak = new Afbraak(status, datum, verhuring, m_Installateur_Afbraken);
		sessionSaveObject(Afbraak);
		return Afbraak;
	}

	@Override
	public List<Afbraak> getAllAfbraken() {
		return (List<Afbraak>) sessionGetAllObjects("Afbraak");
	}

	@Override
	public Afbraak getAfbraakById(int AfbraakID) {
		return (Afbraak) sessionGetObjectById("Afbraak", AfbraakID);
	}

	@Override
	public Afbraak updateAfbraak(Afbraak Afbraak) {
		sessionUpdateObject(Afbraak);
		return Afbraak;
	}

	@Override
	public Afbraak deleteAfbraak(Afbraak Afbraak) {
		sessionDeleteObject(Afbraak);
		return Afbraak;
	}

}
