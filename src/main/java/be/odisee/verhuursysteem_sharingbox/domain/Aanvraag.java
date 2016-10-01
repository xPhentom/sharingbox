package be.odisee.verhuursysteem_sharingbox.domain;

import javax.persistence.*;

/**
 * @author Mathias
 * @version 1.0
 * @created 15-Feb-2016 10:34:37 AM
 */

@Entity
@Table(name = "aanvragen")

public class Aanvraag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String status;

	@Column
	private String datum;

	@Column
	private String adres;

	@ManyToOne
	@JoinColumn(name = "klant_id")
	protected Klant m_Klant;

	@OneToOne
	@JoinColumn(name = "verhuring_id")
	private Verhuring m_verhuring;

	@ManyToOne
	@JoinColumn(name = "verhuurder_id")
	protected Verhuurder m_verhuurder_Aanvragen;

	public Aanvraag() {
	}

	public Aanvraag(int id) {
		this.id = id;
	}

	public Aanvraag(int id, String status, String datum, String adres, Klant m_Klant) {
		this.id = id;
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Klant = m_Klant;
	}

	public Aanvraag(int id, String status, String datum, String adres, Klant m_Klant, Verhuring m_verhuring) {
		this.id = id;
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Klant = m_Klant;
		this.m_verhuring = m_verhuring;
	}

	public Aanvraag(String status, String datum, String adres, Klant m_Klant) {
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Klant = m_Klant;
	}

	public Aanvraag(String status, String datum, String adres, Klant m_Klant, Verhuring m_verhuring) {
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Klant = m_Klant;
		this.m_verhuring = m_verhuring;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Klant getM_Klant() {
		return m_Klant;
	}

	public void setM_Klant(Klant m_Klant) {
		this.m_Klant = m_Klant;
	}

	public Verhuring getM_verhuring() {
		return m_verhuring;
	}

	public void setM_verhuring(Verhuring m_verhuring) {
		this.m_verhuring = m_verhuring;
	}

	public Verhuurder getM_verhuurder_Aanvragen() {
		return m_verhuurder_Aanvragen;
	}

	public void setM_verhuurder_Aanvragen(Verhuurder m_verhuurder_Aanvragen) {
		this.m_verhuurder_Aanvragen = m_verhuurder_Aanvragen;
	}

}