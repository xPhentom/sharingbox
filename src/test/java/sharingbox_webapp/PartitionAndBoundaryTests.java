package sharingbox_webapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static sharingbox_webapp.Validator.Korting;

/**
 * Created by martialh on 10/18/16.
 */
public class PartitionAndBoundaryTests {

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
            assertEquals("Error should be", "Minstens 1 dag huren", e.getMessage());
        }

    }

    @Test
    public void BoundaryTest() {
        int minBoundary=0;
        int maxBoundary=999999;

        assertEquals(20, Korting(maxBoundary));
        try {
            Korting(minBoundary);
        }
        catch (IllegalArgumentException e) {
            assertEquals("Error should be", "Minstens 1 dag huren", e.getMessage());
        }

    }
}
