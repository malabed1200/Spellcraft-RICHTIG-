package MODEL;

import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

// Model: Enthält die Spiellogik
public class HangmanModel {
    private final String word = "PANDA";
    private final Set<Character> guessedLetters = new HashSet<>();
    private int wrongGuesses = 0;

    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                maskedWord.append(c).append(" ");
            } else {
                maskedWord.append("_ ");
            }
        }
        return maskedWord.toString().trim();
    }

    public boolean guessLetter(char letter) {
        if (word.contains(String.valueOf(letter))) {
            guessedLetters.add(letter);
            return true;
        } else {
            wrongGuesses++;
            return false;
        }
    }

    public boolean isGameOver() {
        return wrongGuesses >= 6 || getMaskedWord().replace(" ", "").equals(word);
    }

    public boolean isWin() {
        return getMaskedWord().replace(" ", "").equals(word);
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
}