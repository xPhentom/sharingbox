package be.odisee.verhuursysteem_sharingbox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * @author Mathias
 * @version 1.0
 * @created 15-Feb-2016 10:32:11 AM
 */

@Entity
@Table(name = "verhuringen")
@XmlRootElement(name="verhuring")
public class Verhuring implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String status;
	
	@Column
	private int sharingbox_id;

	@Column
	private String tevredenheidsscore;

	@OneToOne
	@JoinColumn(name = "aanvraag_id")
	private Aanvraag m_aanvraag;

	@OneToOne
	@JoinColumn(name = "installatie_id")
	private Installatie m_installatie;

	@OneToOne
	@JoinColumn(name = "afbraak_id")
	private Afbraak m_afbraak;
	
    @ManyToOne
    @JoinColumn(name="verhuurder_id")
    protected Verhuurder m_verhuurder;


	public Verhuring() {

	}

	public Verhuring(int id, String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		this.id = id;
		this.status = "In behandeling";
		this.sharingbox_id = sharingbox_id;
		this.tevredenheidsscore = tevredenheidsscore;
		this.m_aanvraag = m_aanvraag;
		this.m_afbraak = m_afbraak;
		this.m_installatie = m_installatie;
		this.m_verhuurder = m_verhuurder;
	}
	
	public Verhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag, Installatie m_installatie, Afbraak m_afbraak, Verhuurder m_verhuurder) {
		this.status = "In behandeling";
		this.sharingbox_id = sharingbox_id;
		this.tevredenheidsscore = tevredenheidsscore;
		this.m_aanvraag = m_aanvraag;
		this.m_afbraak = m_afbraak;
		this.m_installatie = m_installatie;
		this.m_verhuurder = m_verhuurder;
	}
	
	public Verhuring(String status, int sharingbox_id, String tevredenheidsscore, Aanvraag m_aanvraag, Verhuurder m_verhuurder) {
		this.status = "In behandeling";
		this.sharingbox_id = sharingbox_id;
		this.tevredenheidsscore = tevredenheidsscore;
		this.m_aanvraag = m_aanvraag;
		this.m_verhuurder = m_verhuurder;
	}
	
	
	@XmlElement(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement(name="sharingboxid")
	public int getSharingbox_id() {
		return sharingbox_id;
	}

	public void setSharingbox_id(int sharingbox_id) {
		this.sharingbox_id = sharingbox_id;
	}
	
	@XmlElement(name="tevredenheidsscore")
	public String getTevredenheidsscore() {
		return tevredenheidsscore;
	}

	public void setTevredenheidsscore(String tevredenheidsscore) {
		this.tevredenheidsscore = tevredenheidsscore;
	}
	
	@XmlElement(name="aanvraag")
	public Aanvraag getM_aanvraag() {
		return m_aanvraag;
	}

	public void setM_aanvraag(Aanvraag m_aanvraag) {
		this.m_aanvraag = m_aanvraag;
	}

	@XmlElement(name="installatie")
	public Installatie getM_installatie() {
		return m_installatie;
	}

	public void setM_installatie(Installatie m_installatie) {
		this.m_installatie = m_installatie;
	}

	@XmlElement(name="afbraak")
	public Afbraak getM_afbraak() {
		return m_afbraak;
	}

	public void setM_afbraak(Afbraak m_afbraak) {
		this.m_afbraak = m_afbraak;
	}

	@XmlElement(name="verhuurder")
	public Verhuurder getM_verhuurder() {
		return m_verhuurder;
	}

	public void setM_verhuurder(Verhuurder m_verhuurder) {
		this.m_verhuurder = m_verhuurder;
	}
}