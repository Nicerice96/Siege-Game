/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */

import java.util.Random;

public class Defender extends Soldier{

    protected int armor2;
    protected int defenderSpecial;
    protected String specialDefendName;
    private int specialCount;

    Random percentage;

    //If take cover is chosen during attack phase, defender blocks 65% of the attack
    public static final double COVER_PERCENTAGE = 0.65;

    //defenders have 70% chance to block with armors rather than HP
    public static final double ARMOR_DEFENSE_PERCENTAGE = 0.7;

    //Defenders have 20% chance of using their special ability. The random double from nexDouble() must be >= 0.8
    public static final double SPECIAL = 0.8;

    //60% chance to attack with primary gun
    public static final double PRIMARY_ATTACK_PERCENTAGE = 0.4;

    public Defender(){
        super();
        name = "Defender recruit";
        //All defenders have a second armor of 15
        armor2 = 15;
        defenderSpecial = 30;
        specialDefendName = "boost health";
        specialCount = 1;
        percentage = new Random();
    }

    public int attack(){
        System.out.println("Defender " + name + " decides to attack!");
        double primaryAttackPercentage = percentage.nextDouble();
        //10% chance to use a one time special ability
        if(primaryAttackPercentage >= SPECIAL && specialCount > 0){
            System.out.println("Defender " + name + " uses their SPECIAL ABILITY " + specialDefendName + " to heal " + defenderSpecial + " added to life-points. No shots fired.");
            specialCount --;
            health = health + defenderSpecial;
            printDescription();
            return 0;
        }
        if(primaryAttackPercentage <= PRIMARY_ATTACK_PERCENTAGE){
            System.out.println("Defender " + name + " uses their primary gun to deal " + getPrimaryGun() + " damage!");
            return getPrimaryGun();
        } else {
            System.out.println("Defender " + name + " uses their secondary gun to deal " + getSecondaryGun() + " damage!");
            return getSecondaryGun();
        }
    }

    public double takeCover(){
        System.out.println("Defender " + name + " decides to take cover from the opponent's next attack");
        System.out.println("Defender " + name + " enters defense mode to block 65% of the opponent's next attack");
        return COVER_PERCENTAGE;
    }

    @Override
    protected void attackedOnArmor(int damageReceived) {
        if (armor2 > 0){
            System.out.println("Defender " + name + " defends with second armor of withstand ability points of " + armor2);
            armor2 = armor2 - damageReceived;
            int remainingArmor2 = armor2;
            if (remainingArmor2 < 0){
                System.out.println("Defender " + name + " has their second armor completely depleted. Damage will be dealt to default armor and health points");
                int damageLeft = remainingArmor2 * - 1;
                super.attackedOnArmor(damageLeft);
            }
        }else {
            super.attackedOnArmor(damageReceived);
        }
    }

    public void attacked(int damageReceived){
        double attackedOnArmor = percentage.nextDouble();
        if (attackedOnArmor < ARMOR_DEFENSE_PERCENTAGE){
            attackedOnArmor(damageReceived);
        } else{
            attackedOnHP(damageReceived);
        }
    }

    public void printDescription(){
        if (armor2 < 0){
            armor2 = 0;
        }
        if (armor < 0){
            armor = 0;
        }
        if (health < 0){
            health = 0;
        }
        System.out.println("\n{name: " + name +
                "\narmor: " + armor +
                "\nsecond armor:" + armor2 +
                "\nhealth(HP): " + health +
                "}");
    }
}
