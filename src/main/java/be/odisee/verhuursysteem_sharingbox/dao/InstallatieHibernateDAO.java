package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installateur;
import be.odisee.verhuursysteem_sharingbox.domain.Installatie;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;

@Repository("InstallatieDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InstallatieHibernateDAO extends HibernateDao implements InstallatieDAO {

	@Override
	public Installatie addInstallatie(int id, String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		Installatie  Installatie= new Installatie(id, status, datum, adres, verhuring, m_Installateur_Installaties);
		sessionSaveObject(Installatie);
		return Installatie;
	}

	@Override
	public Installatie addInstallatie(String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		Installatie  Installatie= new Installatie(status, datum, adres, verhuring, m_Installateur_Installaties);
		sessionSaveObject(Installatie);
		return Installatie;
	}

	@Override
	public List<Installatie> getAllInstallaties() {
		return (List<Installatie>) sessionGetAllObjects("Installatie");
	}

	@Override
	public Installatie getInstallatieById(int installatieID) {
		return (Installatie) sessionGetObjectById("Installatie", installatieID);
	}

	@Override
	public Installatie updateInstallatie(Installatie installatie) {
		sessionUpdateObject(installatie);
		return installatie;
	}

	@Override
	public Installatie deleteInstallatie(Installatie installatie) {
		sessionDeleteObject(installatie);
		return installatie;
	}

}
