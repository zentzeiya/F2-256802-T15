import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsScore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "scissors", "paper"};

        int scoreP1 = 0;
        int scoreP2 = 0;

        System.out.println("=== Rock Paper Scissors Game ===");
        System.out.println("1) Play with Computer");
        System.out.println("2) Play with Friend");
        System.out.print("Select mode (1 or 2): ");
        int mode = scanner.nextInt();
        scanner.nextLine();

        boolean playing = true;

        while (playing) {

            String p1 = "";
            String p2 = "";

            if (mode == 1) {
                System.out.println("Choose:");
                System.out.println("1 = rock, 2 = scissors, 3 = paper");
                System.out.print("Your choice: ");
                p1 = convertChoice(scanner.nextLine());

                p2 = choices[random.nextInt(3)];
                System.out.println("Computer choice: " + p2);
            } else if (mode == 2) {
                System.out.println("Player 1:");
                System.out.println("1 = rock, 2 = scissors, 3 = paper");
                System.out.print("Choice: ");
                p1 = convertChoice(scanner.nextLine());

                for (int i = 0; i < 30; i++) {
                    System.out.println();
                }

                System.out.println("Player 2:");
                System.out.println("1 = rock, 2 = scissors, 3 = paper");
                System.out.print("Choice: ");
                p2 = convertChoice(scanner.nextLine());

                System.out.println();
                System.out.println("Player 1: " + p1);
                System.out.println("Player 2: " + p2);
            }

            int result = checkWinner(p1, p2);

            if (result == 0) {
                System.out.println("Draw! Play again.");
                System.out.println();
                continue;
            } else if (result == 1) {
                System.out.println("Player 1 wins this round!");
                scoreP1++;
            } else {
                System.out.println((mode == 1 ? "Computer" : "Player 2") + " wins this round!");
                scoreP2++;
            }

            System.out.println();
            System.out.println("Current Score:");
            System.out.println("Player 1: " + scoreP1);
            System.out.println((mode == 1 ? "Computer" : "Player 2") + ": " + scoreP2);

            System.out.print("Play again? (y/n): ");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("y")) {
                playing = false;
            }

            System.out.println();
        }

        System.out.println("=== Game Over ===");
        if (scoreP1 > scoreP2) {
            System.out.println("Player 1 is the winner!");
        } else if (scoreP2 > scoreP1) {
            System.out.println((mode == 1 ? "Computer" : "Player 2") + " is the winner!");
        } else {
            System.out.println("Final result: Draw!");
        }

        scanner.close();
    }

    public static String convertChoice(String input) {

        input = input.trim().toLowerCase();

        if (input.equals("1") || input.equals("rock")) {
            return "rock";
        } else if (input.equals("2") || input.equals("scissors")) {
            return "scissors";
        } else if (input.equals("3") || input.equals("paper")) {
            return "paper";
        } else {
            return "rock";
        }
    }

    public static int checkWinner(String p1, String p2) {

        if (p1.equals(p2)) {
            return 0;
        }

        if (
            (p1.equals("rock") && p2.equals("scissors")) ||
            (p1.equals("scissors") && p2.equals("paper")) ||
            (p1.equals("paper") && p2.equals("rock"))
        ) {
            return 1;
        }

        return 2;
    }
}