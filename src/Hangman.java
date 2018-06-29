import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        boolean donePlaying = false;
        ArrayList<String> movies = new ArrayList<String>();

        //Read in list of movies
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        }

//        //print all movies
//        for (int i = 0; i < movies.size(); i++) {
//            System.out.println(movies.get(i));
//        }

        //Continue running until user is done playing
        while (!donePlaying) {
            System.out.println("Do you want to play a game? (Y/N)");

            Scanner reader = new Scanner(System.in);
            String answer = reader.nextLine();

            //Start a new game or exit application
            if (!answer.equals("N") || !answer.equals("n")) {
                //Select a random movie
                Random rand = new Random();
                String movie = movies.get(rand.nextInt(movies.size()));
                Game myGame = new Game(movie);

                System.out.println("Here is your new movie: ");
                System.out.println(myGame.getMovie());

                //Accept user guesses
                while (myGame.hasRemainingGuesses) {
                    System.out.println(myGame.getMovieDashes());
                    String guess = reader.nextLine();
                    myGame.enterGuess(guess);
                }

                System.out.println("Sorry, no more guesses!");

            } else {
                System.out.println("Goodbye");
                donePlaying = true;
                break;
            }
        }

    }
}
