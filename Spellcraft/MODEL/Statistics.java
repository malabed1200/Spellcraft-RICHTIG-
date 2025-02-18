package MODEL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Klasse zur Speicherung von Statistik-Daten
public class Statistics {
    private int correctAnswers;
    private int incorrectAnswers;
    private int count;
    private SaveLoad saveLoad=new SaveLoad();
    private String name="statistikDaten";

    public Statistics() {
        load();
    }

    public void reloadCount(int count){
        this.count=count;
        save();
    }

    public void save(){
        String data=correctAnswers+"\n"+incorrectAnswers+"\n"+count;
        saveLoad.save(data,name);
    }

    public void load(){
        String data=saveLoad.load(name);
        String[] a = data.split("\n");
        correctAnswers=Integer.parseInt(a[0]);
        incorrectAnswers=Integer.parseInt(a[1]);
        count=Integer.parseInt(a[2]);
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
