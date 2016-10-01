package be.odisee.verhuursysteem_sharingbox.converter;

import javax.persistence.Entity;

@Entity
public class BasicOpdracht {
	
	private int id;
	private String status;
	
	public BasicOpdracht()
	{}
	
	public BasicOpdracht(int id, String status)
	{
		this.id = id;
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
