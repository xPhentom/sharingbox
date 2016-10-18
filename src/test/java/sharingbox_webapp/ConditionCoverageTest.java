package sharingbox_webapp;

import static  org.junit.Assert.*;
import static sharingbox_webapp.Validator.DateSelector;

import be.odisee.verhuursysteem_sharingbox.domain.*;
import org.junit.Test;

import java.text.*;
import java.util.*;

/**
 * Created by martialh on 10/15/16.
 */
public class DecisionCoverageTest {

    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
    Klant klant = new Klant("particulier", "klant", persoon);

    @Test
    public void TestTrue() {
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(2), "Fakestreet 5", klant);
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);

        Map validatorResponse = Validator.Validator(aanvraagT1);

        assertEquals(
                "Datum beschikbaar en gegevens correct ingevult",
                "verhuring ingediend",
                validatorResponse.get("response")
        );
    }

    @Test
    public void TestFalse() {
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);

        Map validatorResponse = Validator.Validator(aanvraagT2);

        assertNotEquals(
                "Datum niet beschikbaar en gegevens correct ingevult",
                "verhuring ingediend",
                validatorResponse.get("response")
        );
    }
}
