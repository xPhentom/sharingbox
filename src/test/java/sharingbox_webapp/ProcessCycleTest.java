package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.*;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by martialh on 10/18/16.
 */
public class ProcessCycleTest {
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
    public void A() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "VerkeerdePasswoord");
        Klant klant = new Klant("particulier", "WrongUsername", persoon);
        Verhuring verhuring = new Verhuring("",1, "", aanvraag, installatie, afbraak, verhuurder);

        // Login
        Map AuthResult = Utils.Auth(klant);
        Boolean isSuccess = (Boolean) AuthResult.get("isSuccess");
        assertFalse("gegevens ingegeven - systeem weigert access'", isSuccess);
    }

    @Test
    public void B() {
        Verhuring verhuringFail = new Verhuring("",1, "", aanvraag, installatie, afbraak, verhuurder);
        Verhuring verhuringSuccess = new Verhuring("Pending",1, "Goed", aanvraag, installatie, afbraak, verhuurder);

        Boolean isValid = Validator.VerhuringIsValid(verhuringFail);
        assertFalse("Formulier wordt niet doorgestuurd",isValid);

        Boolean isValid2 = Validator.VerhuringIsValid(verhuringFail);
        assertTrue("Formulier wordt doorgestuurd",isValid2);
    }
}
