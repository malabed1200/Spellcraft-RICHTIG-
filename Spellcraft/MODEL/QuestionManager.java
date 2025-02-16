package MODEL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Klasse zur Verwaltung der Fragenliste
class QuestionManager {
    private List<Question> questions;
    private SaveLoad sl = new SaveLoad();
    private String regex = "%([?]{3})(?<Frage>[\\w ßüäö]*)\\1([!]{3})(?<Antwort>[\\w ßüäö]*)\\3%";
    private boolean difference = false;

    public QuestionManager() {
        this.questions = new ArrayList<>();
        loadQuestions();
    }

    //Fragen von einem großen String mit regex in einer Liste speichern
    public void loadQuestions() {
        String data=sl.load("fragenUantworten");

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String c1 = matcher.group("Frage");
            String c2 = matcher.group("Antwort");

            questions.add(new Question(c1, c2));

            //System.out.println("\nFrage: " + c1 + "?, Antwort:" + c2);
        }

    }

    //Fragen von einer Liste in einem großen String geben und an SaveLoad übergeben
    public void saveQuestions() {
        if(difference){
            String data="";
            for (Question q : questions) {
                data+=q.getData();
            }
            sl.save(data,"fragenUantworten");
        }
    }

    public void addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
        difference = true;
    }

    public boolean removeQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            difference = true;
            return true;
        }
        return false;
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }
}
