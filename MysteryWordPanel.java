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

public class MysteryWordPanel extends JPanel {

    char[] mysteryWord;
    char[] guessedLetters;
    Set<Character> characters;
    StringBuilder sb;
    JLabel placeholderLabel;
    JLabel guessedLettersLabel;
    JLabel incorrectGuessesLabel;
    

    MysteryWordPanel() {

        chooseRandomMysteryWord();

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

    public void chooseRandomMysteryWord() {

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
    }

    public boolean guessLetter(char c) {

        boolean letterIsGuessed = false;

        // Update mentions of letter
        for (int i = 0; i < mysteryWord.length; i++) {
            if (mysteryWord[i] == c) {
                guessedLetters[i] = c;
                letterIsGuessed = true;
            }
        }

        System.out.println(charArrayToString(guessedLetters));

        if (!letterIsGuessed) {

            if (!characters.contains(c)) {

                characters.add(c);
                sb.append(c + " ");

            }

            
        }

        updateLabels();
        repaint();

        return letterIsGuessed;
    }

    public void updateLabels() {

        guessedLettersLabel.setText(charArrayToString(guessedLetters));
        incorrectGuessesLabel.setText(sb.toString());

    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        
    }

    
}

