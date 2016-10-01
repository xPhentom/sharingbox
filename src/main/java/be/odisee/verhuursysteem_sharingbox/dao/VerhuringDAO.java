package be.odisee.verhuursysteem_sharingbox.dao;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installatie;
import be.odisee.verhuursysteem_sharingbox.domain.Rol;
import be.odisee.verhuursysteem_sharingbox.domain.Sharingbox;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuurder;

import java.util.List;

public interface VerhuringDAO {

	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder);

	public Verhuring addVerhuring(int id, String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder);
	
	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Verhuurder m_verhuurder);

	public List<Verhuring> getAllVerhuringen();
	
	public List<Sharingbox> getAllAvailableSharingboxen();

	public Verhuring updateVerhuring(Verhuring verhuring);

	public Verhuring deleteVerhuring(Verhuring verhuring);

	public Verhuring getVerhuringById(int verhuringID);

}
