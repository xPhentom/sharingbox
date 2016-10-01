package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.ArrayList;
import java.util.List;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;

public interface AanvraagDAO {

	public Aanvraag addAanvraag(int id, String status, String datum, String adres, Klant m_KlantID);

	public Aanvraag addAanvraag(String status, String datum, String adres, Klant m_KlantID);

	public List<Aanvraag> getAllAanvragen();
	
	public ArrayList<Aanvraag> getAllAanvragenAndKlantName();

	public Aanvraag updateAanvraag(Aanvraag aanvraag);
	
	public Aanvraag deleteAanvraag(Aanvraag aanvraag);
	
	public Aanvraag getAanvraagById(int aanvraagID);
}
