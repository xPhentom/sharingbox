package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.ArrayList;
import java.util.List;

import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installateur;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;

public interface AfbraakDAO {

	public Afbraak addAfbraak(int id, String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken);

	public Afbraak addAfbraak(String status, String datum, Verhuring verhuring, Installateur m_Installateur_Afbraken);

	public List<Afbraak> getAllAfbraken();

	public Afbraak getAfbraakById(int AfbraakID);

	public Afbraak updateAfbraak(Afbraak Afbraak);

	public Afbraak deleteAfbraak(Afbraak Afbraak);
}
