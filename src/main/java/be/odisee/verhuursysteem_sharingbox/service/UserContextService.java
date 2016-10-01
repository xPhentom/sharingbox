package be.odisee.verhuursysteem_sharingbox.service;

import be.odisee.verhuursysteem_sharingbox.domain.Persoon;

public interface UserContextService {

	public Persoon getAuthenticatedPersoon();

}
