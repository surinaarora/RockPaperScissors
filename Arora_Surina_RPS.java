/*
@Author: Surina Arora 
@Date: December 2 2023
@Description: Program using nested if statements for a simple rock paper scissor game,
which now incorporates the use of methods. 
*/

import java.util.Scanner;

class Arora_Surina_RPS {
    public static void main (String [] args){

//variable declaration & initialization

Scanner uI = new Scanner (System.in);
String name = null;
String playAgain = null;
boolean game = true;

//user input 
gameRule("");    //gameRule method 

//program processing 
while (game){
   gamePlay(1,0,0,0);   //gamePlay method
do{//ask if player wants to play again
   System.out.println("\nWould you like to play again (y/n)? ");
   playAgain = uI.next();
}while(!(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("n"))); 
//will loop if the player doesn't enter y or n
   if(playAgain.equalsIgnoreCase("n"))
      game = false;   
}//close while loop

System.out.println("------------------------------------------------------------------------------------------------");
   System.out.println("Bye Bye!");

}//close main method

private static void gameRule(String name){        
   Scanner uI = new Scanner(System.in);

        System.out.print("Please enter your first and last name: ");
            name = uI.nextLine();
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("Welcome to Rock Paper Scissors, %s.\n",name);
        System.out.println("Here are the rules: ");
        System.out.println("1. You will play best out of 5 rounds against the computer.");
        System.out.println("2. Rock Paper and Scissors will be represented as integers from 1-3.");
        System.out.println("3. If you tied by the end of 5 rounds, then you will continue until you or the computer wins by 2.");
        System.out.println("---------------------------------------------------------------------------------------------------");

     }

private static void gamePlay(int round , int playerChoice, int playerScore, int botScore){
   Scanner uI = new Scanner (System.in);
   boolean range = playerChoice > 0 || playerChoice < 3;
   int rock = 1, paper = 2, scissor = 3;

do{
   int botChoice = (int) (Math.random() * 3) + 1; //generate a random number between 1-3
do{ //loop until the user choose rock, paper, or scissor (integer)
   System.out.println("ROUND " + round);
   System.out.print("Rock (1), Paper (2), Scissor (3): ");
if (uI.hasNextInt()){ //checks if the user inputs an integer or not
   playerChoice = uI.nextInt();
if ((playerChoice < 1 || playerChoice > 3))
   System.out.println("Invalid input. Please enter an integer within the range: ");
}else{
   System.out.println ("Your choice has to be an integer!");
   uI.next();//clears out the scanner if the input is invalid and repeat until the input is withing range
}

}while ((playerChoice < 1 || playerChoice > 3));
   if (range){//run if the user choice is between 1-3
      if((playerChoice == rock && botChoice == scissor) || (playerChoice == paper && botChoice == rock) || (playerChoice == scissor && botChoice == paper)) {
      round++;
      playerScore++;
   System.out.printf("The machine drew %d.", botChoice);
   System.out.println("You won this round!");
}

if(playerChoice == botChoice){
   round ++;
      System.out.printf("The machine drew %d.", botChoice);
      System.out.println("It's a tie... .");
}

if((playerChoice == paper && botChoice == scissor) || (playerChoice == scissor && botChoice == rock) || (playerChoice == rock && botChoice == paper)){
   round++;
   botScore++;
      System.out.printf("The machine drew %d.", botChoice);
      System.out.println("You lost this round...");
}
      System.out.printf("\nYou: %d       Machine: %d\n", playerScore, botScore);
      System.out.println("------------------------------------------------------------------------------------------------");

}
}while((!(round == 6 && playerScore != botScore) && (round <= 5 || Math.abs(playerScore - botScore) < 2)));
// will loop for the first 5 rounds and exit if one of the player wins by 2 or more points when both are tie after round 5.


//output 

if(playerScore > botScore){
   System.out.printf("Congrats, you won %d games to %d. Woooo!", playerScore, round-1);
}else{ //display lose
   System.out.printf("Sorry, you lost %d games to %d. Good luck next time", botScore, round-1);

}    
 
  }
}