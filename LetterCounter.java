import java.util.ArrayList;
import java.util.Random;
public class LetterCounter {

    public static void main(String[] args) {
        // the array of the words should be here 
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("apple");
        
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        String WordToGuess = wordList.get(randomIndex);

        StringBuilder letters = new StringBuilder();

        for (int i = 0; i < WordToGuess.length(); i++) {
            char letter = WordToGuess.charAt(i);
            letters.append(letter);
        }
        int letterCount = letters.length();

        System.out.println("Randomly selected word: " + WordToGuess);
        System.out.println("Number of letters in the random word: " + letterCount);
        for (int i = 0; i < WordToGuess.length(); i++) {
            char letter = WordToGuess.charAt(i);
            System.out.print("_ ");

    }
}
}

