package be.odisee.verhuursysteem_sharingbox.service;

import be.odisee.verhuursysteem_sharingbox.dao.AanvraagDAO;
import be.odisee.verhuursysteem_sharingbox.dao.PersoonDAO;
import be.odisee.verhuursysteem_sharingbox.dao.RolDAO;
import be.odisee.verhuursysteem_sharingbox.dao.VerhuringDAO;
import be.odisee.verhuursysteem_sharingbox.dao.AfbraakDAO;
import be.odisee.verhuursysteem_sharingbox.dao.InstallatieDAO;
import be.odisee.verhuursysteem_sharingbox.domain.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("SharingboxService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SharingboxServiceImplementatie implements SharingboxService {

	// DAO objecten aanmaken
	private VerhuringDAO verhuringDAO;
	private AanvraagDAO aanvraagDAO;
	private PersoonDAO persoonDAO;
	private AfbraakDAO afbraakDAO;
	private InstallatieDAO installatieDAO;
	private RolDAO rolDAO;

	public SharingboxServiceImplementatie() {

	}

	@Autowired
	public void setVerhuringDAO(VerhuringDAO verhuringDAO) {
		this.verhuringDAO = verhuringDAO;
	}

	@Autowired
	public void setAanvraagDAO(AanvraagDAO aanvraagDAO) {
		this.aanvraagDAO = aanvraagDAO;
	}

	@Autowired
	public void setPersoonDAO(PersoonDAO persoonDAO) {
		this.persoonDAO = persoonDAO;
	}

	@Autowired
	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}
	
	@Autowired
	public void setInstallatieDAO(InstallatieDAO installatieDAO) {
		this.installatieDAO = installatieDAO;
	}
	
	@Autowired
	public void setAfbraakDAO(AfbraakDAO afbraakDAO) {
		this.afbraakDAO = afbraakDAO;
	}
	
	/*
	 * Aanvraag
	 */

	@Override
	public Aanvraag addAanvraag(int id, String status, String datum, String adres, Klant m_KlantID) {
		return aanvraagDAO.addAanvraag(id, status, datum, adres, m_KlantID);
	}

	@Override
	public Aanvraag addAanvraag(String status, String datum, String adres, Klant m_KlantID) {
		return aanvraagDAO.addAanvraag(status, datum, adres, m_KlantID);
	}

	@Override
	public List<Aanvraag> getAllAanvragen() {
		return aanvraagDAO.getAllAanvragen();
	}

	@Override
	public Aanvraag getAanvraagById(int aanvraagID) {
		return aanvraagDAO.getAanvraagById(aanvraagID);
	}

	@Override
	public ArrayList<Aanvraag> getAllAanvragenAndKlantName() {
		return aanvraagDAO.getAllAanvragenAndKlantName();
	}

	@Override
	public Aanvraag updateAanvraag(Aanvraag aanvraag) {
		return aanvraagDAO.updateAanvraag(aanvraag);
	}
	
	@Override
	public Aanvraag deleteAanvraag(Aanvraag aanvraag) {
		return aanvraagDAO.deleteAanvraag(aanvraag);
	}

	/*
	 * Persoon
	 */

	@Override
	public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres,
			String paswoord) {
		return persoonDAO.savePersoon(id, status, voornaam, familienaam, emailadres, paswoord);
	}

	@Override
	public Persoon savePersoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
		return persoonDAO.savePersoon(status, voornaam, familienaam, emailadres, paswoord);
	}

	@Override
	public Persoon getPersoonById(int persoonId) {
		return persoonDAO.getPersoonById(persoonId);
	}

	@Override
	public Persoon getPersoonByEmailadres(String email) {
		return persoonDAO.getPersoonByEmailadres(email);
	}

	@Override
	public List<Persoon> getAllPersons() {
		return persoonDAO.getAllPersons();
	}

	@Override
	public Persoon updatePersoon(Persoon persoon) {
		return persoonDAO.updatePersoon(persoon);

	}

	/*
	 * Rol
	 */

	@Override
	public Rol saveRol(Rol rol) {
		return rolDAO.saveRol(rol);
	}

	@Override
	public Rol getRolById(int id) {
		return rolDAO.getRolById(id);
	}

	@Override
	public Rol getRolByUserid(String userid) {
		return rolDAO.getRolByUserid(userid);
	}

	@Override
	public Rol getRolByPersoonId(int persoonid) {
		return rolDAO.getRolByPersoonId(persoonid);
	}

	/*
	 * Verhuring
	 */

	@Override
	public Verhuring addVerhuring(int id, String status, int sharingbox_id, String tevredenheidsscore,
			Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		return verhuringDAO.addVerhuring(id, status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_installatie,
				m_afbraak, m_verhuurder);
	}

	@Override
	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		return verhuringDAO.addVerhuring(status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_installatie,
				m_afbraak, m_verhuurder);
	}

	@Override
	public Verhuring addVerhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag,
			Verhuurder m_verhuurder) {
		return verhuringDAO.addVerhuring(status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_verhuurder);
	}

	@Override
	public List<Verhuring> getAllVerhuringen() {
		return verhuringDAO.getAllVerhuringen();
	}

	@Override
	public List<Sharingbox> getAllAvailableSharingboxen() {
		return verhuringDAO.getAllAvailableSharingboxen();
	}

	@Override
	public Verhuring updateVerhuring(Verhuring verhuring) {
		return verhuringDAO.updateVerhuring(verhuring);
	}

	@Override
	public Verhuring deleteVerhuring(Verhuring verhuring) {
		return verhuringDAO.deleteVerhuring(verhuring);
	}

	@Override
	public Verhuring getVerhuringById(int verhuringID) {
		return verhuringDAO.getVerhuringById(verhuringID);
	}

	/*
	 * Afbraak
	 */
	@Override
	public Afbraak addAfbraak(int id, String status, String datum, Verhuring verhuring,
			Installateur m_Installateur_Afbraken) {
		return afbraakDAO.addAfbraak(id, status, datum, verhuring, m_Installateur_Afbraken);
	}

	@Override
	public Afbraak addAfbraak(String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken) {
		return afbraakDAO.addAfbraak(status, datum, verhuring, m_Installateur_Afbraken);
	}

	@Override
	public List<Afbraak> getAllAfbraken() {
		return afbraakDAO.getAllAfbraken();
	}

	@Override
	public Afbraak getAfbraakById(int AfbraakID) {
		return afbraakDAO.getAfbraakById(AfbraakID);
	}

	@Override
	public Afbraak updateAfbraak(Afbraak Afbraak) {
		return afbraakDAO.updateAfbraak(Afbraak);
	}

	@Override
	public Afbraak deleteAfbraak(Afbraak Afbraak) {
		return afbraakDAO.deleteAfbraak(Afbraak);
	}

	/*
	 * Installatie
	 */
	@Override
	public Installatie addInstallatie(int id, String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		return installatieDAO.addInstallatie(id, status, datum, adres, verhuring, m_Installateur_Installaties);
	}

	@Override
	public Installatie addInstallatie(String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		return installatieDAO.addInstallatie(status, datum, adres, verhuring, m_Installateur_Installaties);
	}

	@Override
	public List<Installatie> getAllInstallaties() {
		return installatieDAO.getAllInstallaties();
	}

	@Override
	public Installatie getInstallatieById(int installatieID) {
		return installatieDAO.getInstallatieById(installatieID);
	}

	@Override
	public Installatie updateInstallatie(Installatie installatie) {
		return installatieDAO.updateInstallatie(installatie);
	}

	@Override
	public Installatie deleteInstallatie(Installatie installatie) {
		return installatieDAO.deleteInstallatie(installatie);
	}


}