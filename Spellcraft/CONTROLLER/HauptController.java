package CONTROLLER;

import MODEL.QuestionManager;
import MODEL.Sound;
import MODEL.Statistics;
import VIEW.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauptController implements ActionListener {
    private JFrameE currentFrame;
    private String addQu="";
    private String addAns="";
    private String index="-1";
    private Statistics statistics;

    private Sound sound;

    private QuestionManager questionManager;

    public HauptController() {
        startHC();
        this.sound = new Sound();
        sound.playMusic();
    }

    public void startHC(){
        currentFrame = new MainMenu(this);
        this.statistics = new Statistics();
    }

    public static void main(String[] args) {new HauptController();}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                sound.playSound("s1");
                currentFrame.dispose();
                currentFrame = new PlayMenu(this);
                break;
            case "Stats":
                sound.playSound("s1");
                currentFrame.dispose();
                currentFrame = new StatisticsView(this);
                currentFrame.updateInt(statistics.getCorrect(),statistics.getIncorrect());
                break;
            case "Options":
                sound.playSound("s1");
                currentFrame.dispose();
                currentFrame=new OptionsMenu(this);
                break;
            case "BackH":
                sound.playSound("s1");
                currentFrame.dispose();
                currentFrame=new MainMenu(this);
                break;
            case "Back":
                sound.playSound("s1");
                currentFrame.dispose();
                currentFrame=new OptionsMenu(this);
                questionManager.saveQuestions();
                break;
            case "Add Question":
                sound.playSound("s1");
                questionManager=new QuestionManager();
                currentFrame.dispose();
                currentFrame=new QuestionAddMenu(this);
                addDocumentListenerQuAdd();
                break;
            case "Remove Question":
                sound.playSound("s1");
                questionManager=new QuestionManager();
                currentFrame.dispose();
                currentFrame=new QuestionRemoveMenu(this);
                addDocumentListenerQuRemove();
                break;
            case "Add":
                sound.playSound("s1");
                String antwort=questionManager.addQuestion(addQu, addAns);
                JOptionPane.showMessageDialog(currentFrame,antwort,"",JOptionPane.INFORMATION_MESSAGE);
                currentFrame.updateTextAnswer();
                break;
            case "Remove":
                sound.playSound("s1");
                String antwort1=questionManager.removeQuestion(index);
                JOptionPane.showMessageDialog(currentFrame,antwort1,"",JOptionPane.INFORMATION_MESSAGE);
                currentFrame.updateTextAnswer();
                break;
            case "Hangman":
                sound.playSound("s1");
                new HangmanController(this);
                statistics=null;
                currentFrame.dispose();
                currentFrame=null;
                break;
            case "GuessThePic":
                sound.playSound("s1");
                new GuessThePicController(this);
                statistics=null;
                currentFrame.dispose();
                currentFrame=null;
                break;
            case "Quiz":
                sound.playSound("s1");
                new QuizController(this);
                statistics=null;
                currentFrame.dispose();
                currentFrame=null;
                break;
            case "Exit":
                sound.playSound("s1");
                System.exit(0);
                break;
            case "Reset":
                sound.playSound("s1");
                statistics.reset();
                currentFrame.updateInt(statistics.getCorrect(),statistics.getIncorrect());
                break;
        }
    }

    private void addDocumentListenerQuRemove() {
        currentFrame.getTextfield()[0].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateIndex(currentFrame.getTextfield()[0]);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateIndex(currentFrame.getTextfield()[0]);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateIndex(currentFrame.getTextfield()[0]);
            }
        });
    }

    private void addDocumentListenerQuAdd() {
        currentFrame.getTextfield()[0].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateAddQu(currentFrame.getTextfield()[0]);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateAddQu(currentFrame.getTextfield()[0]);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateAddQu(currentFrame.getTextfield()[0]);
            }
        });

        currentFrame.getTextfield()[1].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateAddAns(currentFrame.getTextfield()[1]);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateAddAns(currentFrame.getTextfield()[1]);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateAddAns(currentFrame.getTextfield()[1]);
            }
        });
    }

    public void updateAddQu(JTextField textArea) {
        addQu = textArea.getText();
    }

    public void updateAddAns(JTextField textArea) {
        addAns = textArea.getText();
    }

    public void updateIndex(JTextField textArea) {
        index = textArea.getText();
    }
}
