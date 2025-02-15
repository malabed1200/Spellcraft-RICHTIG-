package MODEL;
import java.util.ArrayList;
import java.util.List;

// Klasse zur Verwaltung einzelner Fragen
class Question {
    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean checkAnswer(String input) {
        return input.equals(answer);
    }
}