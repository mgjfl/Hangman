import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel containing a placeholder for the mystery or guessing word, 
 * chosen randomly from listOfWords.txt
 * Correct guesses are put above the placeholder positions and
 * incorrect guesses below them.
 */
public class MysteryWordPanel extends JPanel {

    private char[] mysteryWord;
    private char[] guessedLetters;
    private Set<Character> characters;
    private StringBuilder sb;
    private JLabel placeholderLabel;
    private JLabel guessedLettersLabel;
    private JLabel incorrectGuessesLabel;
 

    /** Constructor. */
    MysteryWordPanel() {

        initialiseGame();       

    }


    /** Chooses a mystery word and sets up the variables and panels for (in)correct guesses. */
    public void initialiseGame() {

        chooseRandomMysteryWord();

    }


    /** Transforms char[] to a string with spaces between the characters. */
    public String charArrayToString(char[] x) {

        // Creating object of String class
        StringBuilder sb = new StringBuilder();
 
        // Adding characters and whitespace
        for (int i = 0; i < x.length; i++) {
            sb.append(x[i]);
            sb.append(' ');
        }
 
        return sb.toString();
    }


    /** Chooses a random mystery word from listOfWords.txt */
    public void chooseRandomMysteryWord() {

        // Removes previous games.
        this.removeAll();

        // A list of potential mystery words will be stored here 
        ArrayList<String> wordList = new ArrayList<String>();

        try {

            // Extract the file
            File file = new File("listOfWords.txt");
            Scanner scan = new Scanner(file);


            // Add the words to the wordList
            while (scan.hasNextLine()) {
                wordList.add(scan.nextLine().toLowerCase());
            }

            scan.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("List of words could not be found.");
        }
        

        // Choose a random word from the list
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        mysteryWord = wordList.get(randomIndex).toCharArray();


        guessedLetters = new char[mysteryWord.length];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = ' ';
        }

        System.out.print("Randomly selected word: ");
        System.out.println(mysteryWord);
        System.out.println("Number of letters in the random word: " + mysteryWord.length);

        
        // Create the placeholder
        System.out.println("_".repeat(mysteryWord.length));
        placeholderLabel = new JLabel("_ ".repeat(mysteryWord.length));

        // Create other labels
        guessedLettersLabel     = new JLabel();
        incorrectGuessesLabel   = new JLabel();

        // Set label font
        int style = 0; // for plain; also check out Font.BOLD and Font.ITALIC
        Font font = new Font(Font.MONOSPACED, style, 12);

        placeholderLabel.setFont(font);
        guessedLettersLabel.setFont(font);
        incorrectGuessesLabel.setFont(font);


        // Stack the panels
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(guessedLettersLabel);
        this.add(placeholderLabel);
        this.add(new JLabel("Incorrect Guesses:"));
        this.add(incorrectGuessesLabel);

        // Store incorrect guesses
        characters  = new HashSet<Character>();
        sb          = new StringBuilder();

        updateLabels();
    }


    /** Updates local variables after the user guesses character c. */
    public boolean guessLetter(char c) {

        boolean letterIsGuessed = false;

        // Update mentions of letter
        for (int i = 0; i < mysteryWord.length; i++) {
            if (mysteryWord[i] == c) {
                guessedLetters[i] = c;
                letterIsGuessed = true;
            }
        }
        
        
        System.out.println("\nCurrent guess:");
        System.out.println(charArrayToString(guessedLetters));
        System.out.println("_ ".repeat(mysteryWord.length) + "\n");

        // If character c is an incorrect guess, add it to the incorrect guesses
        if (!letterIsGuessed && !characters.contains(c)) {

            characters.add(c);
            sb.append(c + " ");

        }

        updateLabels();
        repaint();

        return letterIsGuessed;
    }


    /** Update the labels describing the (in)correct guesses. */
    public void updateLabels() {

        guessedLettersLabel.setText(charArrayToString(guessedLetters));
        incorrectGuessesLabel.setText(sb.toString());

    }


    /** Checks if the game is won. */
    public boolean isGameWon() {

        // The lengths
        boolean out;
        if (mysteryWord.length == guessedLetters.length) {
            out = true;
        } else {
            System.out.println("ERROR: The guessed word has an incorrect length.");
            return false;
        }
    
        // Check for each letter
        for (int i = 0; i < mysteryWord.length; i++) {
            if (mysteryWord[i] != guessedLetters[i]) {
                out = false;
            }
        }

        return out;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

    }
}