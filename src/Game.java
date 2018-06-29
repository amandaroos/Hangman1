import java.util.ArrayList;

public class Game {
    private String movie;
    private ArrayList<String> correctGuesses;
    private ArrayList<String> incorrectGuesses;
    public boolean hasRemainingGuesses;
    private int guesses;

    public Game(String movie) {
        this.movie = movie;
        correctGuesses = new ArrayList<String>();
        incorrectGuesses = new ArrayList<String>();
        hasRemainingGuesses = true;
        guesses = 4;
    }

    public String getMovie() {
        return movie;
    }

//    public String getMovieDashes() {
//        String dashes = "";
//        for (int i = 0; i < movie.length(); i++) {
//            if (Character.toString(movie.charAt(i)).equals(" ")) {
//                dashes += " ";
//            } else if (!Character.isLetter(movie.charAt(i))) {
//                dashes += Character.toString(movie.charAt(i));
//            } else {
//                dashes += "-";
//            }
//        }
//        return dashes;
//    }

    public String getMovieDashes() {
        String dashes = "";
        for (int i = 0; i < movie.length(); i++) {
            boolean guessed = false;
            char letter = movie.charAt(i);
            //for every letter in movie, check it against every letter in correctGuesses
            for (int j = 0; j < correctGuesses.size(); j++){
                if (correctGuesses.get(j).charAt(0) == letter){
                    guessed = true;
                }
            }

            if (Character.toString(movie.charAt(i)).equals(" ")) {
                dashes += " ";
            } else if (!Character.isLetter(movie.charAt(i))) {
                dashes += Character.toString(movie.charAt(i));
            } else if (guessed) {
                dashes += letter;
            }else{
                dashes += "-";
            }
        }
        return dashes;
    }

    public void enterGuess (String guess){

        guesses -= 1;

        if (movie.indexOf(guess) < 0){
            incorrectGuesses.add(guess);
            System.out.println("Sorry, that's an incorrect guess");
        }else {
            correctGuesses.add(guess);
            System.out.println("Correct!");
        }

        if (guesses < 1){
            hasRemainingGuesses = false;
        }
    }
}
