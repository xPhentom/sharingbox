package sharingbox_webapp;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import org.w3c.dom.ranges.RangeException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.Exception.*;
/**
 * Created by martialh on 10/15/16.
 */
public class Validator {
    public Validator(){}

    public static String DateSelector(int index) {
        String[] dates = new String[]{"November 10, 2016", "November 23, 2016", "December 01, 2016"};
        String selectedDate;

        if (index >= 0 && index <= dates.length)
            selectedDate = dates[index];
        else
            selectedDate=null;
        return selectedDate;
    }

    private static final String[] dateList = new String[]{
            "December 22, 2016",
            "November 10, 2016",
            "Oktober 21, 2016"
    };

    /* === BELANGRIJK====
    * Dit is de eerste versie van Validator.
    * De echte validator is aangepast na alle coverages.
    * Gebruik dit als voorbeeld om testen te laten falen.
    * */
    public static Map<String, String> FirstValidator (Aanvraag aanvraag) {
        String aanvraagStatus = aanvraag.getStatus();
        String aanvraagDate = aanvraag.getDatum();
        String aanvraagAdres = aanvraag.getAdres();
        Klant aanvraagKlant = aanvraag.getM_Klant();
        Map<String, String> response = new HashMap();

        if (!aanvraagDate.equals("") && !aanvraagAdres.equals("")){
            Boolean containsDate = Arrays.asList(dateList).contains(aanvraagDate);
            if (!containsDate)
                response.put("response", "verhuring ingediend");
            else
                response.put("response", "geen beschikbare sharingbox");
        }
        else
            response.put("response", "gegevens niet correct ingevuld");

        return response;

    }

    public static Map<String, String> Validator (Aanvraag aanvraag) {
        String aanvraagStatus = aanvraag.getStatus();
        String aanvraagDate = aanvraag.getDatum();
        String aanvraagAdres = aanvraag.getAdres();
        Klant aanvraagKlant = aanvraag.getM_Klant();
        Map<String, String> response = new HashMap();

        if (!aanvraagDate.equals("") && !aanvraagAdres.equals("")){
            Boolean containsDate = Arrays.asList(dateList).contains(aanvraagDate);
            if (!containsDate)
                response.put("response", "verhuring ingediend");
            else
                response.put("response", "geen beschikbare sharingbox");
        }
        else
            response.put("response", "gegevens niet correct ingevuld");
            Boolean containsDate = Arrays.asList(dateList).contains(aanvraagDate);
                if (containsDate)
                    response.put("response2", "geen beschikbare sharingbox");


        return response;

    }

    public static int Korting(int dagen) {
        int korting = 0;
        if (dagen > 10) {
            korting=20;
        }
        if (dagen <= 10 && dagen >= 6) {
            korting=10;
        }
        if (dagen <= 5 && dagen >= 2) {
            korting=5;
        }
        if (dagen == 1 || dagen == 0) {
            korting=0;
        }
        if (dagen <= 0 ) {
            throw new IllegalArgumentException("Minstens 1 dag huren");
        }

        return korting;
    }
}