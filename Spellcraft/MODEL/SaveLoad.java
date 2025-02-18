package MODEL;

import java.io.*;

public class SaveLoad {
    private String pfad="Spellcraft/Speicher/";

    public void save(String text, String name) {
        String dateiName = pfad + name + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiName))) {
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern");
        }
    }

    public String load(String name){
        File file = new File(pfad+name+".txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(pfad+name+".txt"))) {
            String line;
            String ergebnis = "";
            while ((line = reader.readLine()) != null) {
                ergebnis += line+"\n";
            }
            if(name.equals("fragenUantworten")) {
                file.delete();
            }
            return ergebnis;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
