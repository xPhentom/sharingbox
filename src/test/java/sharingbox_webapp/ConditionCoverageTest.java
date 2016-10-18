package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static sharingbox_webapp.Validator.DateSelector;

/**
 * Created by martialh on 10/15/16.
 */
public class ConditionCoverageTest {

    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
    Klant klant = new Klant("particulier", "klant", persoon);

    @Test
    public void TestDateCondition() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(2), "Fakestreet 5", klant);

        Map validatorResponse = Validator.Validator(aanvraag);

        assertEquals(
                "verhuring ingediend",
                validatorResponse.get("response")
        );
    }

    @Test
    public void TestFilledDataCondition() {
        Aanvraag aanvraag = new Aanvraag("pending", DateSelector(0), "", klant);

        Map validatorResponse = Validator.Validator(aanvraag);

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
