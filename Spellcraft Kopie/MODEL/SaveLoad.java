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
        File file = new File(pfad + name + ".txt");
        if (!file.exists()) {
            return "";  // Falls die Datei nicht existiert, leere Zeichenkette zurückgeben
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder ergebnis = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                ergebnis.append(line).append("\n");
            }
            return ergebnis.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
