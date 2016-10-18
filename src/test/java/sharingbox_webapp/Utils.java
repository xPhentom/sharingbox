package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by martialh on 10/18/16.
 */
public class Utils {
    public Utils() {}

    //Failed first method
    public static Map AuthOld(Klant klant) {
        Map response = new HashMap();
        Persoon persoon = klant.getPersoon();
        String username = klant.getUsernaam();
        String passwoord = persoon.getPaswoord();
        String fakeExistingUsername="Jean";
        String fakePassword = "azerty";

        if (!username.isEmpty() || !passwoord.isEmpty()) {
            if (username == fakeExistingUsername && passwoord == fakePassword) {
                //Authentication logic
                response.put("Message", "Succesvol ingelogd");
                response.put("isSuccess", true);
            }
            else {
                response.put("Message", "Username of passwoord niet correct");
                response.put("isSuccess", false);
            }

        }
        else {
            response.put("Message", "Gelieve usernaam en passwoord in te vullen");
            response.put("isSuccess", false);
        }

        return response;
    }

    // New corrected method after tests
    public static Map Auth(Klant klant) {
        Map response = new HashMap();
        Persoon persoon = klant.getPersoon();
        String username = klant.getUsernaam();
        String passwoord = persoon.getPaswoord();
        String fakeExistingUsername="Jean";
        String fakePassword = "azerty";

        if (!username.isEmpty() || !passwoord.isEmpty()) {
            if (username == fakeExistingUsername && passwoord == fakePassword) {
                //Authentication logic
                response.put("Message", "Succesvol ingelogd");
                response.put("isSuccess", true);
            }
            else {
                response.put("Message", "Username of passwoord niet correct");
                response.put("isSuccess", false);
            }

        }
        else {
            response.put("Message", "Gelieve usernaam en passwoord in te vullen");
            response.put("isSuccess", false);
        }

        return response;
    }
}
