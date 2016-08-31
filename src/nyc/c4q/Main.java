package nyc.c4q;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean play = true;
        while (play) {
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 6) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            System.out.println(" wanna play again?");
            boolean validInput;
            do {
                Scanner in = new Scanner(System.in);
                String userAnswer = in.nextLine();
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("yes") || userAnswer.equals("y")) {
                    validInput = true;

                } else if (userAnswer.equals("no") || userAnswer.equals("n")) {
                    validInput = true;
                    play = false;
                } else {
                    System.out.println("try again");
                    validInput = false;
                }

            } while(!validInput);

        }

    }
}