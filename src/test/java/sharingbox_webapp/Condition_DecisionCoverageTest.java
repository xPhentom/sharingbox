package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static sharingbox_webapp.Validator.DateSelector;

/**
 * Created by martialh on 10/15/16.
 */
public class Condition_DecisionCoverageTest {

    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
    Klant klant = new Klant("particulier", "klant", persoon);

    @Test
    public void TestTrue() {
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(2), "Fakestreet 5", klant);
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);

        Map validatorResponse = Validator.Validator(aanvraagT1);

        assertEquals(
                "Is Datum beschikbaar en gegevens correct ingevult",
                "verhuring ingediend",
                validatorResponse.get("response")
        );
    }

    @Test
    public void TestFalse() {
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(0), "", klant);

        Map validatorResponse = Validator.Validator(aanvraagT2);

        assertEquals(
                "gegevens niet correct ingevuld",
                validatorResponse.get("response")
        );
        assertEquals(
                "geen beschikbare sharingbox",
                validatorResponse.get("response2")
        );
    }
}
