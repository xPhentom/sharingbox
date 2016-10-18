package sharingbox_webapp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by martialh on 10/18/16.
 */
public class StateTransitionTest {

    @Test
    public void S0_S1(){
        TestVerhuring verhuring = new TestVerhuring();

        assertEquals("Begin punt (S0)", "Aanvraag", verhuring.GetStatus());
        verhuring.VerhuringToevoegen();
        assertEquals("Begin punt (S0) -> (S1)", "In behandeling", verhuring.GetStatus());
    }

    @Test
    public void S1_S2(){
        TestVerhuring verhuring = new TestVerhuring();

        //S1
        verhuring.VerhuringToevoegen();
        //s2
        verhuring.VerhuringAnnuleren();
        assertEquals("Begin punt (S2) -> (S1)", "Geannuleerd", verhuring.GetStatus());
    }

    @Test
    public void S2_S1(){
        TestVerhuring verhuring = new TestVerhuring();

        //S2
        verhuring.VerhuringAnnuleren();
        //s1
        verhuring.VerhuringOpheffen();
        assertEquals("Begin punt (S2) -> (S1)", "In behandeling", verhuring.GetStatus());
    }

    @Test
    public void S1_S2_S2_S1(){
        TestVerhuring verhuring = new TestVerhuring();

        //S1
        verhuring.VerhuringToevoegen();
        //s2
        verhuring.VerhuringAnnuleren();

        //S2
        verhuring.VerhuringAnnuleren();
        //s1
        verhuring.VerhuringOpheffen();
        assertEquals("Begin punt (S2) -> (S1)", "In behandeling", verhuring.GetStatus());
    }

    @Test
    public void S2_S1_S1_S2(){
        TestVerhuring verhuring = new TestVerhuring();

        //S2
        verhuring.VerhuringAnnuleren();
        //s1
        verhuring.VerhuringOpheffen();

        //S1
        verhuring.VerhuringToevoegen();
        //s2
        verhuring.VerhuringAnnuleren();
        assertEquals("Begin punt (S2) -> (S1)", "Geannuleerd", verhuring.GetStatus());
    }
}
