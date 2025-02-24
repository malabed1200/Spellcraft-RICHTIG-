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

    public void load() {
        String data = saveLoad.load(name);
        if (data == null || data.trim().isEmpty()) {
            correctAnswers = 0;
            incorrectAnswers = 0;
            count = 0;
            return;  // Falls die Datei leer ist, setze Standardwerte
        }

        String[] a = data.split("\n");
        try {
            correctAnswers = Integer.parseInt(a[0]);
            incorrectAnswers = Integer.parseInt(a[1]);
            count = Integer.parseInt(a[2]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            correctAnswers = 0;
            incorrectAnswers = 0;
            count = 0;
            System.out.println("Fehler beim Laden der Statistik. Standardwerte werden gesetzt.");
        }
    }

    public void reset() {
        correctAnswers = 0;
        incorrectAnswers = 0;
        count = 0;
        save();
    }

    public void incrementCorrect() {
        correctAnswers++;
    }

    public void incrementCorrect(int count) {
        correctAnswers+=count;
    }

    public void incrementIncorrect() {
        incorrectAnswers++;
    }

    public void incrementIncorrect(int count) {
        incorrectAnswers+=count;
    }


    public int getCorrect() {
        return correctAnswers;
    }

    public int getIncorrect() {
        return incorrectAnswers;
    }
}
