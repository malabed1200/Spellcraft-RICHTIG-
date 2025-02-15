package MODEL;
import java.util.ArrayList;
import java.util.List;

// Klasse zur Verwaltung der Fragenliste
class QuestionManager {
    private List<Question> questions;

    public QuestionManager() {
        this.questions = new ArrayList<>();
    }

    public void loadQuestions() {
        // Hier könnten Fragen aus einer Datei geladen werden
        // da kann man die fragen und richtige Antworts einlesen und 
        questions.add(new Question("Wie schreibt man das Wort 'Katze'?", "Katze"));
        questions.add(new Question("Was ist die Hauptstadt von Deutschland?", "Berlin"));
    }

    public void addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
    }

    public void removeQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
        }
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }
}
