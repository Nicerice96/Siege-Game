/**
 * @author Keeertikumar Kubareea and Dr.Rami Sabouni - Systems and Computer Engineering
 * SYSC2004 - Late Summer 2023
 * @version 1.0 last updated July 01, 2023
 * */
 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //scanner object ready for user input
        Scanner s = new Scanner(System.in);

        //random object ready for percentage
        Random random = new Random();

        //Objects for both players
        Soldier player1;
        Soldier player2;

        //creating the attackers
        Sledge sledge = new Sledge();
        Thermite thermite = new Thermite();
        Ash ash = new Ash();
        Ace ace = new Ace();

        //putting the attackers in an array list
        ArrayList<Attacker> attackers = new ArrayList<>();
        attackers.add(sledge);
        attackers.add(thermite);
        attackers.add(ash);
        attackers.add(ace);

        //creating the defenders
        Kapkan kapkan = new Kapkan();
        Smoke smoke = new Smoke();
        Doc doc = new Doc();
        Caveira caveira = new Caveira();

        //putting the defenders in an array list
        ArrayList<Defender> defenders = new ArrayList<>();
        defenders.add(kapkan);
        defenders.add(smoke);
        defenders.add(doc);
        defenders.add(caveira);

        //Players now choose their category:
        System.out.print("Player 1 please choose either Attacker(A/a) or Defender(D/d): ");
        String playerChoice = s.nextLine();
        while (!playerChoice.equalsIgnoreCase("a")  && !playerChoice.equalsIgnoreCase("d")){
            System.out.print("Invalid input detected by Player 1.  " + playerChoice + " is invalid. Player 1 please choose either Attacker(A/a) or Defender(D/d): ");
            playerChoice = s.nextLine();
        }
        //generates random integer from 0 to 100 (all bounds inclusive)
        int percentage = random.nextInt(101);
        if (playerChoice.equalsIgnoreCase("a")){
             if (percentage <= 25){
                 player1 = sledge;
                 System.out.println("Player 1 has been assigned the Attacker Sledge");
             } else if (percentage <= 50){
                 player1 = thermite;
                 System.out.println("Player 1 has been assigned the Attacker Thermite");
             } else if (percentage <= 75){
                 player1 = ash;
                 System.out.println("Player 1 has been assigned the Attacker Ash");
             } else{
                 player1 = ace;
                 System.out.println("Player 1 has been assigned the Attacker Ace");
             }
        } else{
            if (percentage <= 25){
                player1 = kapkan;
                System.out.println("Player 1 has been assigned the Defender Kapkan");
            } else if (percentage <= 50){
                player1 = smoke;
                System.out.println("Player 1 has been assigned the Defender Smoke");
            } else if (percentage <= 75){
                player1 = doc;
                System.out.println("Player 1 has been assigned the Defender Doc");
            } else{
                player1 = caveira;
                System.out.println("Player 1 has been assigned the Defender Caveira");
            }
        }

        //Repeat for Player 2
        System.out.print("Player 2 please choose either Attacker(A/a) or Defender(D/d): ");
        playerChoice = s.nextLine();
        while (!playerChoice.equalsIgnoreCase("a")  && !playerChoice.equalsIgnoreCase("d")){
            System.out.print("Invalid input detected by Player 2.  " + playerChoice + " is invalid. Player 2 please choose either Attacker(A/a) or Defender(D/d): ");
            playerChoice = s.nextLine();
        }
        //generates random integer from 0 to 100 (all bounds inclusive)
        percentage = random.nextInt(101);
        if (playerChoice.equalsIgnoreCase("a")){
            if (percentage <= 25){
                player2 = sledge;
                System.out.println("Player 2 has been assigned the Attacker Sledge");
            } else if (percentage <= 50){
                player2 = thermite;
                System.out.println("Player 2 has been assigned the Attacker Thermite");
            } else if (percentage <= 75){
                player2 = ash;
                System.out.println("Player 2 has been assigned the Attacker Ash");
            } else{
                player2 = ace;
                System.out.println("Player 2 has been assigned the Attacker Ace");
            }
        } else{
            if (percentage <= 25){
                player2 = kapkan;
                System.out.println("Player 2 has been assigned the Defender Kapkan");
            } else if (percentage <= 50){
                player2 = smoke;
                System.out.println("Player 2 has been assigned the Defender Smoke");
            } else if (percentage <= 75){
                player2 = doc;
                System.out.println("Player 2 has been assigned the Defender Doc");
            } else{
                player2 = caveira;
                System.out.println("Player 2 has been assigned the Defender Caveira");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println("The battle is ready to begin:\nPlayer 1 is " + player1.getName() + " from the " + player1.getDepartment() + " department." +
                "\nPlayer 2 is " + player2.getName() + " from the " + player2.getDepartment() + " department");

        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.print("A coin is tossed in the air by the mediator");

        for (int i = 0; i < 3; i++){
            //add sleep to mimic time taken for coin toss
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println("Sleep interrupted in main method: " + e);
                System.exit(1);
            }
            System.out.print(".");
        }

        percentage = random.nextInt(101);

        //Determining who starts round 1
        Soldier currentPlayer;
        Soldier opposingPlayer;
        if (percentage <= 50){
            System.out.println("\nCoin toss determines that PLAYER 1 begins round 1!");
            currentPlayer = player1;
            opposingPlayer = player2;
        }else{
            System.out.println("\nCoin toss determines that PLAYER 2 begins round 1!");
            currentPlayer = player2;
            opposingPlayer = player1;
        }


        int roundCount = 1;
        boolean takeCover = false;
        //loop logic - checks the health of currentPlayer, who is the player who received damage in the previous round
        while(currentPlayer.getHealth() > 0){
            if (currentPlayer == player1){
                System.out.println("\nPlayer 1's (" + currentPlayer.getName() + ") turn: ");
            } else {
                System.out.println("\nPlayer 2's (" + currentPlayer.getName() + ") turn: ");
            }
            System.out.print("Would you like to ATTACK(A/a) or TAKE COVER(C/c)?: ");
            playerChoice = s.nextLine();
            //validating player choice
            while (!playerChoice.equalsIgnoreCase("c") && !playerChoice.equalsIgnoreCase("a")){
                System.out.print(playerChoice + " is an invalid input during the battle phase. Would you like to ATTACK(A/a) or TAKE COVER(C/c)?: ");
                playerChoice = s.nextLine();
            }
            if (playerChoice.equalsIgnoreCase("a")){
                System.out.print("You have chosen to attack " + opposingPlayer.getName());
                for (int i = 0; i < 3; i++){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        System.out.println("Sleep interrupted in main method: " + e);
                        System.exit(1);
                    }
                    System.out.print(".");
                }
                //this if branch gets triggered if the opposing player had previously chosen to take cover
                if (takeCover){
                    System.out.println("\n" + opposingPlayer.getName() + " had previously chosen to take cover from the current player's soldier (" + currentPlayer.getName() + ")");
                    System.out.println(opposingPlayer.getName() + " only receives a portion of your attack");
                    opposingPlayer.attacked((int) (currentPlayer.attack() * opposingPlayer.takeCover()));
                    takeCover = false;
                } else{
                    opposingPlayer.attacked(currentPlayer.attack());
                }
            } else {
                System.out.println("You have chosen to take cover from " + opposingPlayer.getName() + "'s next attack...");
                System.out.println("No shots fired from " + currentPlayer.getName());
                takeCover = true;
            }

            //By the end of the round, print the statistics of both players (opponent first)
            System.out.println("The opposing Player (Operator " + opposingPlayer.getName() + ") has the following stats: ");
            opposingPlayer.printDescription();

            System.out.println("\nYou (" +   currentPlayer.getName() + ") have the following stats :");
            currentPlayer.printDescription();

            System.out.println("\nThis concludes ROUND " + roundCount);
            roundCount ++;

            if (currentPlayer == player1){
                currentPlayer = player2;
                opposingPlayer = player1;
                System.out.println("Next up is PLAYER 2 (" + player2.getName() + ") ...");
            } else {
                currentPlayer = player1;
                opposingPlayer = player2;
                System.out.println("Next up is PLAYER 1 (" + player1.getName() + ") ...");
            }
            for (int i = 0; i < 3; i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    System.out.println("Sleep interrupted in main method: " + e);
                    System.exit(1);
                }
                System.out.print("-------------------------------------");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        if (currentPlayer == player1){
            System.out.println("PLAYER 1 (" + currentPlayer.getName() + ") LOSES the battle");
            System.out.println("CONGRATULATIONS to PLAYER 2  (" + opposingPlayer.getName() + ") WINS the battle with " + opposingPlayer.getHealth() + " health points remaining!");
        } else {
            System.out.println("PLAYER 2 (" + currentPlayer.getName() + ") LOSES the battle");
            System.out.println("CONGRATULATIONS to PLAYER 1  (" + opposingPlayer.getName() + ") WINS the battle with " + opposingPlayer.getHealth() + " health points remaining!");
        }
    }
}
