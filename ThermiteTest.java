/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ThermiteTest {

    Thermite thermite;

    public ThermiteTest(){
        //Constructor to prevent instantiation
    }

    @Before
    public void setup(){
        thermite = new Thermite();
    }

    @Test
    public void testThermiteAttack(){
        int expectedThermitePrimary = 33;
        int expectedThermiteSecondary = 17;
        int expectedThermiteSpecial = 40;
        int actualThermiteAttack = thermite.attack();
        assertTrue(actualThermiteAttack == expectedThermitePrimary || actualThermiteAttack == expectedThermiteSecondary || actualThermiteAttack == expectedThermiteSpecial);
    }



}
