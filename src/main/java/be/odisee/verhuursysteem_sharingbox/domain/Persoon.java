package be.odisee.verhuursysteem_sharingbox.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import be.odisee.verhuursysteem_sharingbox.domain.*;
import be.odisee.verhuursysteem_sharingbox.utilities.RolNotFoundException;

@Entity
@Table(name = "personen")
public class Persoon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String status;

	@Column
	@NotEmpty(message = "Voornaam: ")
	private String voornaam;

	@Column
	@Size(min = 1, message = "Familienaam is minstens 1 letter aub")
	private String familienaam;

	@Column
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message = "Vul een geldig e-mail adres in ")
	private String emailadres;

	@Column
	@Size(min = 4, message = "Paswoord is minstens 4 letters aub")
	private String paswoord;

    @OneToMany(fetch=FetchType.EAGER,mappedBy="persoon")
    private Set<Rol> m_Rollen= new HashSet<Rol>();

	public Persoon() {

	}

	public Persoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
		this.status = status;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.emailadres = emailadres;
		this.paswoord = paswoord;
	}

	public Persoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
		this.id = id;
		this.status = status;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.emailadres = emailadres;
		this.paswoord = paswoord;
	}

	public int getId() {
		return id;
	}

	public String getEmailadres() {
		return emailadres;
	}

	public String getPaswoord() {
		return paswoord;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public Set<Rol> getRollen() {
		return m_Rollen;
	}

	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setM_Rollen(Set<Rol> m_Rollen) {
		this.m_Rollen = m_Rollen;
	}

	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getStatus() {
		return status;
	}

	public Set<Rol> getM_Rollen() {
		return m_Rollen;
	}

	public Rol voegRolToe(String type, String status, String usernaam) throws RolNotFoundException {
		Rol newRol = null;
		if (type.toLowerCase().equals("Administrator"))
			newRol = new Administrator(status, usernaam, this);
		if (type.toLowerCase().equals("Klant"))
			newRol = new Klant(status, usernaam, this);
		if (type.toLowerCase().equals("Verhuurder"))
			newRol = new Verhuurder(status, usernaam, this);
		if (type.toLowerCase().equals("Installateur"))
			newRol = new Installateur(status, usernaam, this);
		if (newRol == null)
			throw new RolNotFoundException("Type " + type + " is geen bekende Rol");
		m_Rollen.add(newRol);
		return newRol;
	}

}