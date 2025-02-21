package MODEL;
import java.util.Scanner;

public class MAin {
    public static void main(String[] args) {
        // Frageverwaltung initialisieren
        QuestionManager questionManager = new QuestionManager();
        questionManager.loadQuestions(); // Fragen laden

        // Statistik-Objekt erstellen
        Statistics stats = new Statistics();

        // Scanner für Benutzereingaben
        Scanner scanner = new Scanner(System.in);

        // Fragen durchgehen
        for (int i = 0; i < 2; i++) { // Anzahl der Fragen anpassen
            Question question = questionManager.getQuestion(i);
            if (question != null) {
                System.out.println("Frage: " + question.getQuestionText());
                System.out.print("Antwort: ");
                String userInput = scanner.nextLine();

                if (question.checkAnswer(userInput)) {
                    System.out.println("Richtig!");
                    stats.incrementCorrect();
                } else {
                    System.out.println("Falsch!");
                    stats.incrementIncorrect();
                }
            }
        }

        // Ergebnisse ausgeben
        System.out.println("\nSpiel beendet!");
        System.out.println("Richtige Antworten: " + stats.getCorrect());
        System.out.println("Falsche Antworten: " + stats.getIncorrect());

        // Scanner schließen
        scanner.close();
    }
}
