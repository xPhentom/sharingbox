package be.odisee.verhuursysteem_sharingbox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sharingboxen")
public class Sharingbox {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String status;

	public Sharingbox()
	{}
	
	public Sharingbox(int id, String status)
	{
		this.id = id;
		this.status = status;
	}
	
	public Sharingbox(String status)
	{
		this.status = status;
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
}
