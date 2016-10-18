package sharingbox_webapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static sharingbox_webapp.Validator.Korting;

/**
 * Created by martialh on 10/18/16.
 */
public class EPTest {

    @Test
    public void PartitionTest() {
        int validDay1=5;
        int validDay2=7;
        int validDay3=11;
        int invalidDay=-5;

        assertEquals(5, Korting(validDay1));
        assertEquals(10, Korting(validDay2));
        assertEquals(20, Korting(validDay3));
        try {
            Korting(invalidDay);
        }
        catch (IllegalArgumentException e) {
            assertEquals("Error should be", "Nummer moet groter zijn dan 0", e.getMessage());
        }

    }
}
