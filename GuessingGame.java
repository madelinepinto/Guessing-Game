/*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This program will generate a random number between 1 and 100 inclusively and ask the usee to guess the number
 * in seven guesses or less. If they  are sucessful, they gain 50 points. If they 
 * cannot correctly, they lose 50 points. The game ends once they have less than 0 points, more than 250, or quit*/


import java.util.Scanner;
import java.lang.Math;

class GuessingGameMadelineGA{
  public static void main(String[]teletubby) {
  GuessingGamey obj1 = new GuessingGamey();
  System.out.println("WELCOME - to the GUESSING GAME\nINSTRUCTIONS: \n \n"+
                       "This is a very simple game, you have 7 tries to guess a randomly \n"+
                       "generated number between 1 to 100 inclusively. If you guess it \n"+
                       "correctly, you get 50 points. You win the game if you can get a score of 250 points,\n"+
                       "but you lose the game if your score falls below zero. A draw is if you quit the game\n"+
                       "before you either win or lose. Note: The program will show your existing score.\n"+
                       "Good Luck and have fun!\n\n");
  obj1.menu();
  }
    
  
  }


/*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This class will generate a random number between 1 and 100 inclusively and ask the usee to guess the number
 * in seven guesses or less. If they  are sucessful, they gain 50 points. If they 
 * cannot correctly, they lose 50 points. The game ends once they have less than 0 points, more than 250, or quit*/
class GuessingGamey{
  
  int random;
  Scanner in;
  int a;
  int i;
  int b;
  int score;
  boolean correct;
  int lower;
  int higher;
  int x;
  int y;
 
  GuessingGamey() {in = new Scanner(System.in); correct = false; random = 0; a = 0; i = 0; b = 0; score = 0; lower = 1; higher = 100; x = 0; y = 0;}
  
  //get/set method
  public void setIn(Scanner in) {this.in=in;}
  public Scanner getIn() {return in;}
 
  public void setCorrect(Boolean correct) {this.correct=correct;}
  public Boolean getCorrect() {return correct;}
  
  public void setA(int a) {this.a=a;}
  public int getA() {return a;}
    
  public void setI(int i) {this.i=i;}
  public int getI() {return i;}
  
  public void setB(int b) {this.b=b;}
  public int getB() {return b;}
  
  public void setScore(int score) {this.score=score;}
  public int getScore() {return score;}
  
  public void setLower(int lower) {this.lower=lower;}
  public int getLower() {return lower;}
  
  public void setRandom(int random) {this.random=random;}
  public int getRandom() {return random;}
  
  public void setHigher(int higher) {this.higher=higher;}
  public int getHigher() {return higher;}
  
  public void setX(int x) {this.x=x;}
  public int getX() {return x;}
  
  public void setY(int y) {this.y=y;}
  public int getY() {return y;}
    
  /*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This is the menu method. It asks the player if they want to start a new game or exit the program
 *@Return: VOID
 *@Param: n/a                                                                                     */
  public void menu() {
    System.out.println("MENU---------Please Make your Choice----------------------------------------------\n"+
                       "1. Start a new Game.\n"+
                       "0. Exit Game");
    while(!in.hasNextInt())
  { in.next(); 
    System.out.println("You did not pick 0 or 1- Try Again" );}
  
  x = in.nextInt();
  
   if(x==0)
       {System.out.println("Exiting");}
   if(x==0&&score==0)
   {System.out.printf("Sorry. You Lost. Your final score was: 0\nGood-Bye - Thanks for Playing");}
   if(x==0&&score>0&&score<250)
   {System.out.printf("Good Game - It's a draw. Your final score was: %d\n"+
                       "Good-Bye - Thanks for Playing\n" ,score );
   exit();}
   if(x==0&&score==250)
   {System.out.printf("Congrats. You Won. Your final score was: %d\n"+
                       "Good-Bye - Thanks for Playing" ,score ); 
   exit();}
   else{ 
  while (x>1||x<0)
  {
   System.out.println("You did not pick 0 or 1- Try Again");
   menu();
  }
  
 
if (x==1){
  x=0;
  score = 0;
    

  play1();}}
  }
/*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This is the play method. It generates a random number and asks the player to guess the number.
 *@Return: VOID
 *@Param: n/a                                                                                     */
  public void play1(){
   
    
    random  = (int)(Math.random()*((100))+1);
    System.out.println(random);
    correct = false;
    higher = 100;
    lower = 1;
      
    
    
    while (correct != true)
    {
      for (i=1; i<=7; i++)
      { System.out.printf("Try %d: Please enter a number from %d to %d inclusively.\n", i, lower, higher);
  
        if (!in.hasNextInt()) { 
     in.next();
     System.out.printf("You just lost a try.\n");
      
      continue;
        }
     a = in.nextInt();
     if (a == random)
     {System.out.println("You guessed it!");
       score=score+50;
       correct = true;
       i=8; }
              
     else if(a<lower||a>higher)
     {System.out.printf("You just lost a try.\n");}
       
     else if (a>random)
     {System.out.printf("Guess is too high\n");
       if (a<=higher)
       {higher = a-1;}
       
       
     }
     else if (a<random)
     {System.out.printf("Guess is too low\n");
       if (a>=lower)
       {lower = a+1;}
     }
    }
      if (i>7)
      {score();}
    }
  }
  /*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This is the score method. It keeps track of the player's score and will ask them to play again if applicable.
 *@Return: VOID
 *@Param: n/a                                                                                     */
      public void score(){
    if (correct==false)
      {score=score-50;
    correct = true;
    System.out.println("OOPs - sorry - You didn't guess it!\nCurrent Game Score = "+score+"");
    if (score>=0) {playAgain();}
    if (score<0)
      {System.out.println("You have lost the game because your score is below 0 - Start a new Game!\n"+
                         "Resetting game Score to 0");
    score = 0;
    menu();
    
  }
    }
    
    if (correct == true && score==250)
    {System.out.printf("You've won!!!!!!!\n"+
                        "Current Game Score = %d\n", score);
    menu();
    }
                        
    else if (correct==true&&score<250&&score>0)
      {
      System.out.printf("Current Game Score = %d\n", score);
    playAgain();}
      }
      
  /*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This is the play again method. It asks the player if they want to play again, start a new game or exit the program
 *@Return: VOID
 *@Param: n/a                                                                                     */    
  public void playAgain() {
     System.out.printf ("Do you want to play again?(1- Yes, 0 - No)\n");
  while(!in.hasNextInt())
  { in.next(); 
    System.out.println("Please pick 0 or 1 - Thank You\n"+
                       "Do you want to play again?(1- Yes, 0 - No)");}
  
  y = in.nextInt();
  
  if(y==0){
       menu();
   }
   else{ 
 while (y>1||y<0)
  {
   System.out.println("Please pick 0 or 1 - Thank You");
   playAgain();
  }
  
 
if (y==1){
  correct = false;
  i=1;
  play1();}
  
   
    }
    }
  /*@Author:Madeline Pinto     @Date: Dec 17 2022
 * This is the exit method. It will only run if the player chooses to exit the program.
 *@Return: VOID
 *@Param: n/a                                                                                     */
    public void exit() {
    in.close();}
      }