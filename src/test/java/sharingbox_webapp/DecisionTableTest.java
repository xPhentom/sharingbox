package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static sharingbox_webapp.Validator.DateSelector;

/**
 * Created by martialh on 10/12/16.
 */



public class DecisionTableTest {
    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
    Klant klant = new Klant("particulier", "klant", persoon);


    @Test
    public void AllTrue() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(1), "Fakestreet 5", klant);

        Map validateResponse = Validator.Validator(aanvraag);

        assertEquals(
                "verhuring ingediend",
                validateResponse.get("response")
        );
    }

    @Test
    public void IncorrectData() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(1), "", klant);

        Map validateResponse = Validator.Validator(aanvraag);

        assertEquals(
                "gegevens niet correct ingevuld",
                validateResponse.get("response")
        );
    }

    @Test
    public void UnavailableDate() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(0), "Fakestreet 5", klant);

        Map validateResponse = Validator.Validator(aanvraag);

        assertEquals(
                "geen beschikbare sharingbox",
                validateResponse.get("response")
        );
    }

    @Test
    public void AllFalse() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(0), "", klant);

        Map validateResponse = Validator.Validator(aanvraag);

        assertEquals(
                "gegevens niet correct ingevuld",
                validateResponse.get("response")
        );
        assertEquals(
                "geen beschikbare sharingbox",
                validateResponse.get("response2")
        );
    }
}
