package sharingbox_webapp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static  org.junit.Assert.*;

import be.odisee.verhuursysteem_sharingbox.domain.*;

import java.text.*;
import java.util.*;

/**
 * Created by martialh on 10/12/16.
 */



public class StatementCoverageTest {
    public String DateSelector(int index) {
        String[] dates = new String[]{"November 10, 2016", "November 23, 2016", "December 01, 2016"};
        String selectedDate;

        if (index >= 0 && index <= dates.length)
            selectedDate = dates[index];
        else
            selectedDate=null;
        return selectedDate;
    }


    @Test
    public void TestCase1() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
        Klant klant = new Klant("particulier", "klant", persoon);
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(1), "Fakestreet 5", klant);
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);
        Aanvraag aanvraagT3 = new Aanvraag("pending", DateSelector(0), "Fakestreet 5", klant);

        Map validateResponseT1 = Validator.Validator(aanvraagT1);
        Map validateResponseT2 = Validator.Validator(aanvraagT2);
        Map validateResponseT3 = Validator.Validator(aanvraagT3);

        //Test Case 01
        assertEquals(
                "Gegevens correct ingevuld",
                "verhuring ingediend",
                validateResponseT1.get("response")
        );
    }

    @Test
    public void TestCase2() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
        Klant klant = new Klant("particulier", "klant", persoon);
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(1), "Fakestreet 5", klant);
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);
        Aanvraag aanvraagT3 = new Aanvraag("pending", DateSelector(0), "Fakestreet 5", klant);

        Map validateResponseT1 = Validator.Validator(aanvraagT1);
        Map validateResponseT2 = Validator.Validator(aanvraagT2);
        Map validateResponseT3 = Validator.Validator(aanvraagT3);

        //Test Case 02
        assertEquals(
                "Gegevens correct ingevuld",
                "gegevens niet correct ingevuld",
                validateResponseT2.get("response")
        );
    }

    @Test
    public void TestCase3() {
        Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@mail.com", "superpass");
        Klant klant = new Klant("particulier", "klant", persoon);
        Aanvraag aanvraagT1 = new Aanvraag("pending", DateSelector(1), "Fakestreet 5", klant);
        Aanvraag aanvraagT2 = new Aanvraag("pending", DateSelector(1), "", klant);
        Aanvraag aanvraagT3 = new Aanvraag("pending", DateSelector(0), "Fakestreet 5", klant);

        Map validateResponseT1 = Validator.Validator(aanvraagT1);
        Map validateResponseT2 = Validator.Validator(aanvraagT2);
        Map validateResponseT3 = Validator.Validator(aanvraagT3);

        //Test Case 03
        assertEquals(
                "Gegevens correct ingevuld",
                "geen beschikbare sharingbox",
                validateResponseT3.get("response")
        );
    }

    @After
    public void TestTeardown() {

    }
}
