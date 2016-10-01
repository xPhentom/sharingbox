package be.odisee.verhuursysteem_sharingbox.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "installaties")
public class Installatie implements Serializable {

	private static final long serialVersionUID = 1L;

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
	@JoinColumn(name = "installateur_id")
	protected Installateur m_Installateur_Installaties;

	@OneToOne
	@JoinColumn(name = "verhuring_id")
	private Verhuring verhuring;

	
	public Installatie()
	{}
	public Installatie(int id, String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		this.id = id;
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Installateur_Installaties = m_Installateur_Installaties;
		this.verhuring = verhuring;
	}

	public Installatie(String status, String datum, String adres, Verhuring verhuring,
			Installateur m_Installateur_Installaties) {
		this.status = status;
		this.datum = datum;
		this.adres = adres;
		this.m_Installateur_Installaties = m_Installateur_Installaties;
		this.verhuring = verhuring;
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

	public Verhuring getVerhuring() {
		return verhuring;
	}

	public void setVerhuring(Verhuring verhuring) {
		this.verhuring = verhuring;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Installateur getM_Installateur_Installaties() {
		return m_Installateur_Installaties;
	}

	public void setM_Installateur_Installaties(Installateur m_Installateur_Installaties) {
		this.m_Installateur_Installaties = m_Installateur_Installaties;
	}

}
