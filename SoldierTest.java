/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SoldierTest {

    private Soldier soldier;

    public SoldierTest(){
        //Constructor to prevent instantiation
    }

    @Before
    public void setup(){
        soldier = new Soldier("TestSoldier", "testing", 30, 25, 100, 50, 50);
    }

    @Test
    public void test_attackedOnArmor_armorMoreThanDamageReceived(){
        int damageReceived = 17;
        int expectedArmorLeft = 8;
        int expectedHealthLeft = 100;
        soldier.attackedOnArmor(damageReceived);
        int actualArmorLeft = soldier.getArmor();
        int actualHealthLeft = soldier.getHealth();
        assertEquals(expectedHealthLeft, actualHealthLeft);
        assertEquals(expectedArmorLeft, actualArmorLeft);
    }

    @Test
    public void test_attackedOnArmor_armorEqualsToDamageReceived(){
        int damageReceived = 25;
        int expectedArmorLeft = 0;
        int expectedHealthLeft = 100;
        soldier.attackedOnArmor(damageReceived);
        int actualArmorLeft = soldier.getArmor();
        int actualHealthLeft = soldier.getHealth();
        assertEquals(expectedHealthLeft, actualHealthLeft);
        assertEquals(expectedArmorLeft, actualArmorLeft);
    }

    @Test
    public void test_attackedOnArmor_armorLessThanDamageReceived(){
        int damageReceived = 40;
        int expectedHealthLeft = 85;
        soldier.attackedOnArmor(damageReceived);
        int actualArmorLeft = soldier.getArmor();
        //assert that no more armor is left
        assertTrue(actualArmorLeft <= 0);
        int actualHealthLeft = soldier.getHealth();
        assertEquals(expectedHealthLeft, actualHealthLeft);
    }

    @Test
    public void test_attackedOnArmor_noArmorLeft_healthPointsLeft(){
        soldier.setArmor(0);
        int damageReceived = 40;
        soldier.attackedOnArmor(damageReceived);
        int expectedHealthLeft = 60 ;
        assertEquals(expectedHealthLeft, soldier.getHealth());
    }

    @Test
    public void test_attackedOnArmor_noArmorLeft_noHealthLeft(){
        soldier.setArmor(0);
        int damageReceived = 110;
        soldier.attackedOnArmor(damageReceived);
        assertTrue(soldier.getHealth() < 0);
    }

    @Test
    public void test_attackedOnHP_someHPLeft(){
        //initial health = 100
        soldier.attackedOnHP(20);
        int expectedHealth = 80;
        int actualHealth = soldier.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    public void test_attackedOnHP_noHPLeft(){
        //initial health = 100
        soldier.attackedOnHP(120);
        assertTrue(soldier.getHealth() <= 0);
    }
}
