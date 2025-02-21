package MODEL;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuessThePicModel extends Manager{
    private Map<Integer, String> map;

    private int currentQu=-1;
    private Question[] questions;

    public GuessThePicModel(){
        super("&([?]{3})(?<Zahl>[\\w ßüäö]*)\\1([!]{3})(?<Wort>[\\w ßüäö]*)\\3&");
        this.map=new HashMap<>();
        loadQuestions();
        this.questions=getMapSet();
    }

    @Override
    public void loadQuestions() {
        String data=getSaveLoad().load("zahlenUwoerter");

        map.clear();

        Pattern pattern = Pattern.compile(getRegex());

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            int c1 = Integer.parseInt(matcher.group("Zahl"));
            String c2 = matcher.group("Wort");

            map.put(c1, c2);
        }
    }

    private Question[] getMapSet(){
        int aba=map.size()-10;
        int random = (int) (Math.random() * aba);
        Question[] questions = new Question[10];
        int a=0;
        while(a<10) {
            questions[a] = new Question(random + "", "" + map.get(random));
            a++;
            random++;
        }
        return questions;
    }

    public boolean istRichtig(String answer){
        if(answer==null){
            return false;
        }
        if(questions[currentQu].checkAnswer(answer)){
            return true;
        }
        return false;
    }

    public String getQuestion(){
        if(currentQu<9) {
            currentQu++;
            return "Spellcraft/Bilder/GuessThePic/" + questions[currentQu].getQuestionText() + ".png";
        }
        return null;
    }
}
