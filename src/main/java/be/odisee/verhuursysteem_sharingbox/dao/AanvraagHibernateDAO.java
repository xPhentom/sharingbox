package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;

@Repository("AanvraagDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AanvraagHibernateDAO extends HibernateDao implements AanvraagDAO {

	@Override
	public Aanvraag addAanvraag(int id, String status, String datum, String adres, Klant m_KlantID) {
		Aanvraag aanvraag = new Aanvraag(id, status, datum, adres, m_KlantID);
		sessionSaveObject(aanvraag);
		return aanvraag;
	}

	@Override
	public Aanvraag addAanvraag(String status, String datum, String adres, Klant m_KlantID) {
		Aanvraag aanvraag = new Aanvraag(status, datum, adres, m_KlantID);
		sessionSaveObject(aanvraag);
		return aanvraag;
	}

	@Override
	public List<Aanvraag> getAllAanvragen() {
		return (List<Aanvraag>) sessionGetAllObjects("Aanvraag");
	}

	@Override
	public ArrayList<Aanvraag> getAllAanvragenAndKlantName() {
		return (ArrayList<Aanvraag>) sessionGetAllObjectsWithJoinKlant();
	}

	@Override
	public Aanvraag getAanvraagById(int aanvraagID) {
		return (Aanvraag) sessionGetObjectById("Aanvraag", aanvraagID);
	}

	@Override
	public Aanvraag updateAanvraag(Aanvraag aanvraag) {
		sessionUpdateObject(aanvraag);
		return aanvraag;
	}

	@Override
	public Aanvraag deleteAanvraag(Aanvraag aanvraag) {
		sessionDeleteObject(aanvraag);
		return aanvraag;
	}

}
