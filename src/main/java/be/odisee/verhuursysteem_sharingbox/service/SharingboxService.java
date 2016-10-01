package be.odisee.verhuursysteem_sharingbox.service;

import java.util.ArrayList;
import java.util.List;

import be.odisee.verhuursysteem_sharingbox.domain.*;

public interface SharingboxService {

	/*
	 * Aanvraag
	 */
	public Aanvraag addAanvraag(int id, String status, String datum, String adres, Klant m_Klant);

	public Aanvraag addAanvraag(String status, String datum, String adres, Klant m_Klant);

	public List<Aanvraag> getAllAanvragen();

	public Aanvraag getAanvraagById(int aanvraagID);
	
	public Aanvraag updateAanvraag(Aanvraag aanvraag);
	
	public Aanvraag deleteAanvraag(Aanvraag aanvraag);

	public ArrayList<Aanvraag> getAllAanvragenAndKlantName();

	/*
	 * Persoon
	 */
	public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres,
			String paswoord);

	public Persoon savePersoon(String status, String voornaam, String familienaam, String emailadres, String paswoord);

	public Persoon getPersoonById(int persoonId);

	public Persoon getPersoonByEmailadres(String email);

	public List<Persoon> getAllPersons();

	public Persoon updatePersoon(Persoon persoon);

	/*
	 * Rol
	 */

	public Rol saveRol(Rol rol);

	public Rol getRolById(int id);

	public Rol getRolByUserid(String userid);

	public Rol getRolByPersoonId(int persoonid);

	/*
	 * Verhuring
	 */

	public Verhuring addVerhuring(int id, String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder);

	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder);

	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Verhuurder m_verhuurder);

	public List<Verhuring> getAllVerhuringen();

	public List<Sharingbox> getAllAvailableSharingboxen();

	public Verhuring updateVerhuring(Verhuring verhuring);

	public Verhuring deleteVerhuring(Verhuring verhuring);

	public Verhuring getVerhuringById(int verhuringID);

	/*
	 * Afbraken
	 */
	public Afbraak addAfbraak(int id, String status, String datum, Verhuring verhuring,
			Installateur m_Installateur_Afbraken);

	public Afbraak addAfbraak(String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken);

	public List<Afbraak> getAllAfbraken();

	public Afbraak getAfbraakById(int AfbraakID);

	public Afbraak updateAfbraak(Afbraak Afbraak);

	public Afbraak deleteAfbraak(Afbraak Afbraak);

	/*
	 * Installatie
	 */
	public Installatie addInstallatie(int id, String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties);

	public Installatie addInstallatie(String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties);

	public List<Installatie> getAllInstallaties();

	public Installatie getInstallatieById(int installatieID);

	public Installatie updateInstallatie(Installatie installatie);

	public Installatie deleteInstallatie(Installatie installatie);

}
