import java.util.Scanner;
import java.util.Random;

public class GuessG {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    Random random = new Random();

    int minNum = 1;
    int maxNum = 100;

    int maxAttempts = 10;

    int score = 0;
    int rounds = 0;

    boolean play = true;

    System.out.println("Welcome to guessing game....!");
    System.out.println("think of a number between " + minNum + " and " + maxNum + ".");
    System.out.println("You have to guess it in " + maxAttempts + " attempts or less.");
    System.out.println("Let's Start");

    while (play) {

      rounds++;

      int number = random.nextInt(maxNum - minNum + 1) + minNum;

      int attempts = 0;

      boolean guessed = false;

      while (!guessed) {

        attempts++;

        System.out.print("Enter your guess for round " + rounds + ", attempt " + attempts + ": ");
        int guess = scanner.nextInt();

        if (guess == number) {
          System.out.println("Congratulations The number was " + number + ".");
          guessed = true;
        } else if (guess < number) {
          System.out.println("Too low. Try again.");
        } else {
          System.out.println("Too high. Try again.");
        }

        if (attempts == maxAttempts) {
          System.out.println("Sorry, you ran out of attempts. The number was " + number + ".");
          guessed = true;
        }
      }

      score += maxAttempts - attempts;

      System.out.println("Your current score is: " + score);

      System.out.print("Do you want to play another round? (y/n): ");
      char choice = scanner.next().charAt(0);

      if (choice == 'y' || choice == 'Y') {
        play = true;
      } else {
        play = false;
        System.out.println("Thank you for playing. Your final score is: " + score);
        System.out.println("Goodbye!");
      }
    }

    scanner.close();
  }
}