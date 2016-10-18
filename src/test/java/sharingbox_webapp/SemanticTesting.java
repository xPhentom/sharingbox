package sharingbox_webapp;

import org.junit.*;

import be.odisee.verhuursysteem_sharingbox.domain.*;

import java.text.*;
import java.util.*;

/**
 * Created by Wouter Roozeleer on 16/10/2016.
 */
public class SemanticTesting {

    public static Map<String, String> Tester(Installateur installateur){

        Persoon  persoon = installateur.getPersoon();
        List<Installatie> installatie = installateur.getM_Installatie();
        List<Afbraak> afbraak = installateur.getM_Afbraak();
        String username =  installateur.getUsernaam();
        String type = installateur.getType();
        Map<String, String> response = new HashMap<>();

        // Dit krijgt de gebruiker te zien zodat hij weet welke Installateurs hij kan wegsturen
        List<Installateur> aanwezigInstallateurs = new ArrayList<Installateur>();
        if (persoon.getStatus() == "bezet") {
            response.put("response", "Not available");
            if (aanwezigInstallateurs.contains(installateur)){
                aanwezigInstallateurs.remove(installateur);
            }
        }
        else{
            response.put("response", "Available");
            aanwezigInstallateurs.add(installateur);
        }
        return response;
    }

    @Test
    public void test(){
        Persoon persoon = new Persoon("bezet", "James", "Harden", "jm@gmail.com", "superpass");
        Installateur installateur = new Installateur("bezet", "James harden", persoon);
        Map CheckResponse = Tester(installateur);
        Assert.assertEquals("Check of de installateur/afbreker wel kan komen","Not available", CheckResponse.get("response"));

    }

    @Test
    public void test2(){
        Persoon persoon = new Persoon("bereikbaar", "James", "Harden", "jm@gmail.com", "superpass");   Installateur installateur = new Installateur("bezet", "James harden", persoon);
        Map CheckResponse = Tester(installateur);
        Assert.assertEquals("Check of de installateur/afbreker wel kan komen","Available", CheckResponse.get("response"));

    }




}
