package sharingbox_webapp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static  org.junit.Assert.*;
import static sharingbox_webapp.Validator.DateSelector;

import be.odisee.verhuursysteem_sharingbox.domain.*;

import java.text.*;
import java.util.*;

/**
 * Created by martialh on 10/12/16.
 */



public class StatementCoverageTest {
    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
    Klant klant = new Klant("particulier", "klant", persoon);


    @Test
    public void TestCase1() {
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(1), "Fakestreet 5", klant);

        Map validateResponseT1 = Validator.Validator(aanvraagT1);

        //Test Case 01
        assertEquals(
                "Gegevens correct ingevuld",
                "verhuring ingediend",
                validateResponseT1.get("response")
        );
    }

    @Test
    public void TestCase2() {
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);

        Map validateResponseT2 = Validator.Validator(aanvraagT2);

        //Test Case 02
        assertEquals(
                "Gegevens niet correct ingevuld",
                "gegevens niet correct ingevuld",
                validateResponseT2.get("response")
        );
    }

    @Test
    public void TestCase3() {
        Aanvraag aanvraagT3 = new Aanvraag("pending", DateSelector(0), "Fakestreet 5", klant);

        Map validateResponseT3 = Validator.Validator(aanvraagT3);

        //Test Case 03
        assertEquals(
                "Datum niet beschikbaar",
                "geen beschikbare sharingbox",
                validateResponseT3.get("response")
        );
    }
}
