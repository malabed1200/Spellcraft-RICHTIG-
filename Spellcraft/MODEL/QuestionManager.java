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

    public String addQuestion(String question, String answer) {
        String ruckGabe="";

        if(question.equals("") && answer.equals("")){
            ruckGabe="Bitte Frage und Antwort eingeben";
        }
        else if(question.equals("")){
            ruckGabe="Bitte Frage eingeben";
        }
        else if(answer.equals("")){
            ruckGabe="Bitte Antwort eingeben";
        }
        else{
            questions.add(new Question(question, answer));
            difference = true;
            ruckGabe="Frage wurde hinzugefügt:\n"+ruckGabe;
        }
        return ruckGabe;
    }

    public String removeQuestion(String indexF) {
        int index=-1;

        try{
            indexF=indexF.trim();
            index=Integer.parseInt(indexF);
        }catch(NumberFormatException e){
            return "Bitte eine gültige Zahl eingeben";
        }

        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            difference = true;
            return "Frage "+index+" wurde entfernt";
        }
        return "Bitte eine Zahl von "+1+" bis "+questions.size()+" eingeben";
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
