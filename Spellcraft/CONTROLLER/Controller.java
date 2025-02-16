package CONTROLLER;

import MODEL.Statistics;
import VIEW.MainMenu;

public class Controller {
    public static void main(String[] args) {
        // Erstelle die Statistik-Instanz
        Statistics statistics = new Statistics();

        // Starte das Hauptmenü mit Statistik-Daten
        new MainMenu(statistics);
    }
}
