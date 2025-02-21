package MODEL;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    private SaveLoad sl = new SaveLoad();
    private String regex;

    public Manager(String regex) {
        this.regex = regex;
    }

    public String getRegex(){
        return regex;
    }

    public SaveLoad getSaveLoad() {return sl;}

    public void loadQuestions() {}
    public void saveQuestions() {}

}
