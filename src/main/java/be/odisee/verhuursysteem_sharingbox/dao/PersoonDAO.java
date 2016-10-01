package be.odisee.verhuursysteem_sharingbox.dao;

import java.util.List;

import be.odisee.verhuursysteem_sharingbox.domain.Persoon;

public interface PersoonDAO {
	
    public Persoon savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon savePersoon(String string, String voornaam, String familienaam, String emailadres, String paswoord);

    public Persoon getPersoonById(int persoonId);

    public Persoon getPersoonByEmailadres(String email);

    public List<Persoon> getAllPersons();

    public Persoon updatePersoon(Persoon persoon);
}
