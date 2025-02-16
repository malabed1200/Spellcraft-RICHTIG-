package MODEL;

import java.util.HashSet;
import java.util.Set;

public class HangmanModel {
    private final String word = "PANDA";
    private final String category = "ANIMALS";
    private final Set<Character> guessedLetters = new HashSet<>();
    private int wrongGuesses = 0;

    // Statistik-Objekt erstellen
    private Statistics statistics = new Statistics();

    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                maskedWord.append(c);
            } else {
                maskedWord.append("*");
            }
        }
        return maskedWord.toString();
    }

    public boolean guessLetter(char letter) {
        if (word.contains(String.valueOf(letter))) {
            guessedLetters.add(letter);
            statistics.incrementCorrect(); // Richtig geraten -> Statistik updaten
            return true;
        } else {
            wrongGuesses++;
            statistics.incrementIncorrect(); // Falsch geraten -> Statistik updaten
            return false;
        }
    }

    public boolean isGameOver() {
        return wrongGuesses >= 6 || getMaskedWord().equals(word);
    }

    public boolean isWin() {
        return getMaskedWord().equals(word);
    }

    public void resetGame() {
        guessedLetters.clear();
        wrongGuesses = 0;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public String getWord() {
        return word;
    }

    public String getCategory() {
        return category;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
