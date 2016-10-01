package be.odisee.verhuursysteem_sharingbox.domain;

import java.util.List;

import javax.persistence.*;

import be.odisee.verhuursysteem_sharingbox.domain.Installateur;

@Entity
@DiscriminatorValue("Installateur")
public class Installateur extends Rol {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_Installateur_Afbraken")
	private List<Afbraak> m_Afbraak;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_Installateur_Installaties")
	private List<Installatie> m_Installatie;

	public Installateur() {
	}

	public Installateur(String status, String usernaam, Persoon persoon) {
		super(status, usernaam, persoon);
	}

	public Installateur(int id, String status, String usernaam, Persoon persoon) {
		super(id, status, usernaam, persoon);
	}

	@Override
	public String getType() {
		return "Installateur";
	}

	public List<Afbraak> getM_Afbraak() {
		return m_Afbraak;
	}

	public void setM_Afbraak(List<Afbraak> m_Afbraak) {
		this.m_Afbraak = m_Afbraak;
	}

	public List<Installatie> getM_Installatie() {
		return m_Installatie;
	}

	public void setM_Installatie(List<Installatie> m_Installatie) {
		this.m_Installatie = m_Installatie;
	}
}