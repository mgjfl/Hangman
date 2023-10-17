import java.util.Random;

public class LetterCount {

    private static final String[] WORDS = { "apple", "banana", "cherry", "dog", "elephant", "flamingo" };
    

    private String targetWord;
    private char[] guessedWord;
    
     public LetterCount() {
        Random random = new Random();
        targetWord = WORDS[random.nextInt(WORDS.length)];
        guessedWord = new char[targetWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }
    }  
}
