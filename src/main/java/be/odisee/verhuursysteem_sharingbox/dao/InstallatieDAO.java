package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.List;

import be.odisee.verhuursysteem_sharingbox.domain.Installateur;
import be.odisee.verhuursysteem_sharingbox.domain.Installatie;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;

public interface InstallatieDAO {

	public Installatie addInstallatie(int id, String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties);

	public Installatie addInstallatie(String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties);

	public List<Installatie> getAllInstallaties();

	public Installatie getInstallatieById(int installatieID);

	public Installatie updateInstallatie(Installatie installatie);

	public Installatie deleteInstallatie(Installatie installatie);
}
