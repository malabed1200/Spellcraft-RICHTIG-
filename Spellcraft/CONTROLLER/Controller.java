package CONTROLLER;

import MODEL.Statistics;
import VIEW.MainMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    public static void main(String[] args) {
        String dateiName = "Spellcraft/Speicher/woerter.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiName))){
            writer.write("");
        }catch(IOException e){
            System.out.println("Fehler beim speichern");
        }
    }
}
