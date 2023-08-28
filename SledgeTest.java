/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SledgeTest {

    Sledge sledge;

    public SledgeTest(){
        //Constructor to prevent instantiation
    }

    @Before
    public void setup(){
        sledge = new Sledge();
    }

    @Test
    public void testSledgeAttack(){
        int expectedSledgePrimary = 35;
        int expectedSledgeSecondary = 20;
        int expectedSledgeSpecial = 45;
        int actualSledgeAttack = sledge.attack();
        assertTrue(actualSledgeAttack == expectedSledgePrimary || actualSledgeAttack == expectedSledgeSecondary || actualSledgeAttack == expectedSledgeSpecial);
    }


}
