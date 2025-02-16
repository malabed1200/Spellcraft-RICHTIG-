package CONTROLLER;

import MODEL.Statistics;
import VIEW.MainMenu;

public class Controller {
    public static void main(String[] args) {
        // Erstellt eine Instanz von Statistics
        Statistics statistics = new Statistics();

        // Startet das Hauptmenü und übergibt die Statistik-Instanz
        new MainMenu(statistics);
    }
}
