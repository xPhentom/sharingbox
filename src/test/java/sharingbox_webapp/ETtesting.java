package sharingbox_webapp;


import org.junit.*;

import be.odisee.verhuursysteem_sharingbox.domain.*;

import java.text.*;
import java.util.*;


/**
 * Created by Wouter Roozeleer on 16/10/2016.
 */


public class ETtesting {

    public static Map<String, String> Tester(Aanvraag aanvraag){
        String aanvraagStatus = aanvraag.getStatus();
        String aanvraagDatum = aanvraag.getDatum();
        String aanvraagAdres = aanvraag.getAdres();
        Klant aanvraagKlant = aanvraag.getM_Klant();
        Map<String, String> response = new HashMap<>();

        if ( aanvraagKlant.getPersoon().getVoornaam().matches(".*\\d.*")){
            response.put("response", "invalid response");
        }
        else{
            response.put("response","valid response");
        }
        return response;
    }

@Test
    public void test(){
    Persoon persoon = new Persoon("vaste klant", "James", "Harden", "jm@gmail.com", "superpass");
    Klant klant = new Klant("Particulier", "klant", persoon);

    Aanvraag aanvraagtest = new Aanvraag("pending", "December 22, 2016", "teststraat", klant);

    Map TestReponse1 = Tester(aanvraagtest);

    Assert.assertEquals(
            "Test if name contains numbers, shouldn't have numbers",
            "valid response",
            TestReponse1.get("response")
    );
}

@Test
    public void test2(){

        Persoon persoon = new Persoon("vaste klant", "James1", "Harden", "jm@gmail.com", "superpass");
        Klant klant = new Klant("Particulier", "klant", persoon);

        Aanvraag aanvraagtest = new Aanvraag("pending", "December 22, 2016", "teststraat", klant);

        Map TestReponse1 = Tester(aanvraagtest);

        Assert.assertEquals(
                "Test if name contains numbers, has numbers",
                "invalid response",
                TestReponse1.get("response")
        );

}

    @Test
    public void test3(){

        Persoon persoon = new Persoon("vaste klant", "Jamés aze", "Harden", "jm@gmail.com", "superpass");
        Klant klant = new Klant("Particulier", "klant", persoon);

        Aanvraag aanvraagtest = new Aanvraag("pending", "December 22, 2016", "teststraat", klant);

        Map TestReponse1 = Tester(aanvraagtest);

        Assert.assertEquals(
                "Test if name contains numbers, has no numbers, but special characters",
                "valid response",
                TestReponse1.get("response")
        );

    }

}
