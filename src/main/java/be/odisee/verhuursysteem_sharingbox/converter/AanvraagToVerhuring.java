package be.odisee.verhuursysteem_sharingbox.converter;

import javax.persistence.Entity;

@Entity
public class AanvraagToVerhuring {

	private int aanvraag_id;
	private int sharingbox_id;
	
	
	public AanvraagToVerhuring()
	{}
	public AanvraagToVerhuring(int aanvraag_id, int sharingbox_id)
	{
		this.aanvraag_id = aanvraag_id;
		this.sharingbox_id = sharingbox_id;
	}
	public int getAanvraag_id() {
		return aanvraag_id;
	}
	public void setAanvraag_id(int aanvraag_id) {
		this.aanvraag_id = aanvraag_id;
	}
	public int getSharingbox_id() {
		return sharingbox_id;
	}
	public void setSharingbox_id(int sharingbox_id) {
		this.sharingbox_id = sharingbox_id;
	}
	
}
