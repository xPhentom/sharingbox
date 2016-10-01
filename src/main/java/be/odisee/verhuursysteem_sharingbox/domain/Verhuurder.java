package be.odisee.verhuursysteem_sharingbox.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Verhuurder")
public class Verhuurder extends Rol {


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_verhuurder")
	private List<Verhuring> m_Verhuring;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m_verhuurder_Aanvragen")
	private List<Aanvraag> m_aanvraag;
	
    public Verhuurder(){}

    public Verhuurder(String status, String usernaam, Persoon persoon){
        super(status,usernaam,persoon);
    }

    public Verhuurder(int id, String status, String usernaam,Persoon persoon){
        super(id,status,usernaam,persoon);
    }

    @Override
    public String getType() {
        return "Verhuurder";
    }

	public List<Verhuring> getM_Verhuring() {
		return m_Verhuring;
	}

	public void setM_Verhuring(List<Verhuring> m_Verhuring) {
		this.m_Verhuring = m_Verhuring;
	}

	public List<Aanvraag> getM_aanvraag() {
		return m_aanvraag;
	}

	public void setM_aanvraag(List<Aanvraag> m_aanvraag) {
		this.m_aanvraag = m_aanvraag;
	}

}