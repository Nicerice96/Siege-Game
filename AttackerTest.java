/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AttackerTest {

    private Attacker attacker;

    public AttackerTest(){
        //constructor to prevent instantiation
    }

    @Before
    public void setup(){
        attacker = new Attacker();
    }

    @Test
    public void testAttack(){
        int expectedPrimaryPower = 12;
        int expectedSecondaryPower = 8;
        int expectedSpecialPower = 30;
        int actualPower = attacker.attack();
        //actual power should be an integer which corresponds to either the expected primary power or the secondary power
        assertTrue(actualPower == expectedPrimaryPower || actualPower == expectedSecondaryPower || actualPower == expectedSpecialPower);
    }

    @Test
    public void testTakeCover(){
        double expectedCoverPercentage = 0.5;
        double actualCoverPercentage = attacker.takeCover();
        assertTrue(expectedCoverPercentage == actualCoverPercentage);
    }

}
