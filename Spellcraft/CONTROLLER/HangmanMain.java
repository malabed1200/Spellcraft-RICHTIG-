package CONTROLLER;
import MODEL.HangmanModel;
import VIEW.HangmanView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

// Main-Methode zum Starten des Spiels
public class HangmanMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HangmanModel model = new HangmanModel();
            HangmanView view = new HangmanView(model);
            view.setVisible(true);
        });
    }
}
