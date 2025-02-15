package MODEL;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanModel {
    private String word;
    private Set<Character> guessedLetters;
    private int attemptsLeft;

    public HangmanModel(String word) {
        this.word = word.toLowerCase();
        this.guessedLetters = new HashSet<>();
        this.attemptsLeft = 6;
    }

    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            return false;
        }
        guessedLetters.add(letter);
        if (!word.contains(Character.toString(letter))) {
            attemptsLeft--;
        }
        return true;
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            maskedWord.append(guessedLetters.contains(c) ? c : '_').append(' ');
        }
        return maskedWord.toString().trim();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}

