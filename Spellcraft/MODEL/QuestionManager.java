package MODEL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Klasse zur Verwaltung der Fragenliste
public class QuestionManager extends Manager{
    private List<Question> questions;
    private boolean difference = false;

    public QuestionManager() {
        super("%([?]{3})(?<Frage>[\\w ßüäö]*)\\1([!]{3})(?<Antwort>[\\w ßüäö]*)\\3%");
        this.questions = new ArrayList<>();
        loadQuestions();
    }

    //Fragen von einem großen String mit regex in einer Liste speichern
    @Override
    public void loadQuestions() {
        String data=getSaveLoad().load("fragenUantworten");

        Pattern pattern = Pattern.compile(getRegex());

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String c1 = matcher.group("Frage");
            String c2 = matcher.group("Antwort");

            questions.add(new Question(c1, c2));

            //System.out.println("\nFrage: " + c1 + "?, Antwort:" + c2);
        }
    }

    //Fragen von einer Liste in einem großen String geben und an SaveLoad übergeben
    @Override
    public void saveQuestions() {
        if(difference){
            String data="";
            for (Question q : questions) {
                data+=q.getData();
            }
            getSaveLoad().save(data,"fragenUantworten");
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

    public void statistikErneuern() {
        Statistics objekt=new Statistics();
        objekt.reloadCount(questions.size());
    }
}
