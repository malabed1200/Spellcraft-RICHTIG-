package CONTROLLER;

import MODEL.GuessThePicModel;
import VIEW.GuessThePic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuessThePicController implements ActionListener {
    private GuessThePic guessThePic;
    private GuessThePicModel guessThePicModel;

    private String answer;

    private int richtig=0;
    private int falsch=0;

    public GuessThePicController() {
        this.guessThePicModel = new GuessThePicModel();
        this.guessThePic = new GuessThePic(this);
        this.guessThePic.setBild(guessThePicModel.getQuestion());
        addDocumentListener();
    }

    public static void main(String[] args) {
        GuessThePicController guessThePicController = new GuessThePicController();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Guess":
                boolean a=guessThePicModel.istRichtig(answer);
                if(a) {
                    JOptionPane.showMessageDialog(guessThePic, "Die Antwort ist Richtig", "Richtig",JOptionPane.INFORMATION_MESSAGE);
                    guessThePic.setKreisFarbe(richtig+falsch,new Color(43, 255, 0));
                    richtig++;
                }
                else {
                    JOptionPane.showMessageDialog(guessThePic, "Die Antwort ist Falsch", "Falsch",JOptionPane.ERROR_MESSAGE);
                    guessThePic.setKreisFarbe(richtig+falsch,new Color(255, 0, 0));
                    falsch++;
                }
                guessThePic.updateTextAnswer();
                String variable=guessThePicModel.getQuestion();
                if(variable!=null){
                    this.guessThePic.setBild(variable);
                }else{
                    JOptionPane.showMessageDialog(guessThePic, "Richtig: "+richtig+"\nFalsch: "+falsch, "Spiel zu Ende",JOptionPane.INFORMATION_MESSAGE);
                    guessThePic.dispose();
                    shutdown();
                }
                break;
        }
    }

    private void addDocumentListener() {
        guessThePic.getTextfield().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateAnswer(guessThePic.getTextfield());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateAnswer(guessThePic.getTextfield());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateAnswer(guessThePic.getTextfield());
            }
        });
    }

    public void updateAnswer(JTextField answer){
        this.answer=answer.getText();
    }

    public void shutdown() {
        for (Window window : Window.getWindows()) {
            window.dispose();
        }
        guessThePic = null;
        guessThePicModel = null;
        new HauptController();
    }
}
