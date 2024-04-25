import java.util.Random;
import java.util.Scanner;

class RandomNo {
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String playAgain;
        do {
            int random = rand.nextInt(100) + 1; 
            System.out.println("Guess a number between 1 to 100");
            int maxAttempts = 10;
            int points = 0;
            boolean correctGuess = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.println("Attempt " + attempt + " of " + maxAttempts + ":");
                int guessNum = scanner.nextInt();

                if (guessNum > random) {
                    System.out.println("Too high");
                } else if (guessNum < random) {
                    System.out.println("Too low");
                } else {
                    System.out.println("Matched");
                    points = maxAttempts - attempt + 1; 
                    correctGuess = true;
                    break; 
                }
            }

            if (correctGuess) {
                System.out.println("Congratulations! You've earned " + points + " points.");
            } else {
                System.out.println("Sorry, you've used all your attempts. The number was " + random + ".");
            }

            System.out.println("Do you want to play again? (yes/no):");
            playAgain = scanner.next();

           
            scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));

        scanner.close();
    }
}
