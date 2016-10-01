package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installatie;
import be.odisee.verhuursysteem_sharingbox.domain.Rol;
import be.odisee.verhuursysteem_sharingbox.domain.Sharingbox;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuurder;

@Repository("VerhuringDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VerhuringHibernateDAO extends HibernateDao implements VerhuringDAO {

	@Override
	public Verhuring addVerhuring(int id, String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		Verhuring verhuring = new Verhuring(id, status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_installatie,
				m_afbraak, m_verhuurder);
		sessionSaveObject(verhuring);
		return verhuring;
	}

	@Override
	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		Verhuring verhuring = new Verhuring(status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_installatie,
				m_afbraak, m_verhuurder);
		sessionSaveObject(verhuring);
		return verhuring;
	}
	
	@Override
	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Verhuurder m_verhuurder)
	{
		Verhuring verhuring = new Verhuring(status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_verhuurder);
		sessionSaveObject(verhuring);
		return verhuring;
	}

	public List<Verhuring> getAllVerhuringen() {
		return (List<Verhuring>) sessionGetAllObjects("Verhuring");
	}
	
	public List<Sharingbox> getAllAvailableSharingboxen() {
		
		String qstr = "from Sharingbox where status = 'Beschikbaar'";
		return (List<Sharingbox>) sessionGetAllObjectsByQuery(qstr);
	}
	
	

	public Verhuring updateVerhuring(Verhuring verhuring) {
		sessionUpdateObject(verhuring);
		return verhuring;
	}

	public Verhuring updateVerhuringAfronden(Verhuring verhuring) {
		sessionUpdateObject(verhuring);
		String status = "afgerond";
		verhuring.setStatus(status);
		return verhuring;
	}

	public Verhuring deleteVerhuring(Verhuring verhuring) {
		sessionDeleteObject(verhuring);
		return verhuring;
	}

	public Verhuring getVerhuringById(int verhuringID) {
		return (Verhuring) sessionGetObjectById("Verhuring", verhuringID);
	}
}
