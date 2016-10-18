package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.*;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Map;

/**
 * Created by martialh on 10/18/16.
 */
public class UseCaseTest {
    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "azerty");
    Persoon persoonV = new Persoon("Verhuurder", "Sun", "Wukong", "S.W@kame.com", "Korin");
    Klant klant = new Klant("particulier", "Jean", persoon);
    Aanvraag aanvraag = new Aanvraag("pending", "22-12-2016", "Fakestreet 4453", klant);
    Verhuurder verhuurder = new Verhuurder("available", "Goku", persoonV);
    Installateur installateur = new Installateur("bezig", "installor", persoonV);
    Afbraak a = new Afbraak(1, "failed", "12-03-2016");
    Verhuring v = new Verhuring("cool", 1, "high", aanvraag, verhuurder);
    Installatie installatie2 = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", v, installateur);
    Verhuring verhuring2 = new Verhuring("test",1, "goed", aanvraag, installatie2, a, verhuurder);
    Afbraak afbraak1 = new Afbraak("voltooid", "22-09-2016", verhuring2, installateur);
    Installatie installatie1 = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", verhuring2, installateur);
    Verhuring verhuring1 = new Verhuring("test",1, "goed", aanvraag, installatie1, afbraak1, verhuurder);
    Afbraak afbraak = new Afbraak("voltooid", "22-09-2016", verhuring1, installateur);
    Installatie installatie = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", verhuring1, installateur);

    @Test
    public void LoginEnVerhuurFormSubmitSuccess() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "azerty");
        Persoon persoonV = new Persoon("Verhuurder", "Sun", "Wukong", "S.W@kame.com", "Korin");
        Klant klant = new Klant("particulier", "Jean", persoon);
        Aanvraag aanvraag = new Aanvraag("pending", "22-12-2016", "Fakestreet 4453", klant);
        Verhuurder verhuurder = new Verhuurder("available", "Goku", persoonV);
        Installateur installateur = new Installateur("bezig", "installor", persoonV);
        Afbraak a = new Afbraak(1, "failed", "12-03-2016");
        Verhuring v = new Verhuring("cool", 1, "high", aanvraag, verhuurder);
        Installatie installatie2 = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", v, installateur);
        Verhuring verhuring2 = new Verhuring("test",1, "goed", aanvraag, installatie2, a, verhuurder);
        Afbraak afbraak1 = new Afbraak("voltooid", "22-09-2016", verhuring2, installateur);
        Installatie installatie1 = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", verhuring2, installateur);
        Verhuring verhuring1 = new Verhuring("test",1, "goed", aanvraag, installatie1, afbraak1, verhuurder);
        Afbraak afbraak = new Afbraak("voltooid", "22-09-2016", verhuring1, installateur);
        Installatie installatie = new Installatie("pending", "22-3-2016", "Ev Boulevard 23", verhuring1, installateur);
        Verhuring verhuring = new Verhuring("test",1, "goed", aanvraag, installatie, afbraak, verhuurder);

        // Login
        Map AuthResult = Utils.Auth(klant);
        Boolean isSuccess = (Boolean) AuthResult.get("isSuccess");
        assertTrue("username must be 'Jean' password must be 'azerty'", isSuccess);

        //verhuring
        Boolean isValid = Validator.VerhuringIsValid(verhuring);
        assertTrue("status and score must be filled",isValid);
    }

    @Test
    public void LoginEnVerhuurFormSubmitFail() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "VerkeerdePasswoord");
        Klant klant = new Klant("particulier", "WrongUsername", persoon);
        Verhuring verhuring = new Verhuring("",1, "", aanvraag, installatie, afbraak, verhuurder);

        // Login
        Map AuthResult = Utils.Auth(klant);
        Boolean isSuccess = (Boolean) AuthResult.get("isSuccess");
        assertFalse("username must be 'Jean' password must be 'azerty'", isSuccess);

        //verhuring
        Boolean isValid = Validator.VerhuringIsValid(verhuring);
        assertFalse("status and score must be filled",isValid);
    }
}
