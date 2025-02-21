package MODEL;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HangmanWords extends Manager{
    private List<String> words;

    public HangmanWords(){
        super("&([!]{3})(?<Antwort>[\\w ßüäö]*)\\1&");
        words = new ArrayList<String>();
        loadQuestions();
    }

    @Override
    public void loadQuestions() {
        String data=getSaveLoad().load("woerter");

        Pattern pattern = Pattern.compile(getRegex());

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String c1 = matcher.group("Antwort");

            words.add(c1);
        }
    }

    public String getWord() {
        int index = (int) (Math.random() * words.size());

        if (index >= 0 && index < words.size()) {
            return words.get(index);
        }
        return null;
    }
}
