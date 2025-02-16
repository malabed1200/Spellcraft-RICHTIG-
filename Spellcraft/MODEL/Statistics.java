package MODEL;
import java.util.ArrayList;
import java.util.List;

// Klasse zur Speicherung von Statistik-Daten
public class Statistics {
    private int correctAnswers;
    private int incorrectAnswers;

    public Statistics() {
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }

    public void incrementCorrect() {
        correctAnswers++;
    }

    public void incrementIncorrect() {
        incorrectAnswers++;
    }

    public int getCorrect() {
        return correctAnswers;
    }

    public int getIncorrect() {
        return incorrectAnswers;
    }
}
