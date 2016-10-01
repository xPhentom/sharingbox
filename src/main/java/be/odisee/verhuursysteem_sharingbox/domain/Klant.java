package be.odisee.verhuursysteem_sharingbox.domain;

import java.util.List;

import javax.persistence.*;

import be.odisee.verhuursysteem_sharingbox.domain.Klant;

@Entity
@DiscriminatorValue("Klant")
public class Klant extends Rol {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_Klant")
	private List<Aanvraag> aanvraag;

	public Klant() {
	}

	public Klant(String status, String usernaam, Persoon persoon) {
		super(status, usernaam, persoon);
	}

	public Klant(int id, String status, String usernaam, Persoon persoon) {
		super(id, status, usernaam, persoon);
	}

	@Override
	public String getType() {
		return "Klant";
	}

	public List<Aanvraag> getAanvraag() {
		return aanvraag;
	}

	public void setAanvraag(List<Aanvraag> aanvraag) {
		this.aanvraag = aanvraag;
	}

}