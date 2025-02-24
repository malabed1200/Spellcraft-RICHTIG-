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

    private boolean visibility;

    private JFrameE MainMenu=new MainMenu(this);
    private JFrameE OptionsMenu=new OptionsMenu(this);
    private JFrameE PlayMenu=new PlayMenu(this);
    private JFrameE StatisticsView=new StatisticsView(this);
    private JFrameE QuestionAddMenu=new QuestionAddMenu(this);
    private JFrameE QuestionRemoveMenu=new QuestionRemoveMenu(this);

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
        currentFrame = MainMenu;
        currentFrame.setVisible(true);
        this.statistics = new Statistics();
    }

    public static void main(String[] args) {new HauptController();}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                sound.playSound("s1");
                currentFrame = PlayMenu;
                currentFrame.setVisible(true);
                MainMenu.setVisible(false);
                break;
            case "Stats":
                sound.playSound("s1");
                currentFrame = StatisticsView;
                currentFrame.updateInt(statistics.getCorrect(),statistics.getIncorrect());
                currentFrame.setVisible(true);
                MainMenu.setVisible(false);
                break;
            case "Options":
                sound.playSound("s1");
                currentFrame=OptionsMenu;
                currentFrame.setVisible(true);
                MainMenu.setVisible(false);
                break;
            case "BackH":
                sound.playSound("s1");
                currentFrame.setVisible(false);
                currentFrame=MainMenu;
                currentFrame.setVisible(true);
                break;
            case "Back":
                sound.playSound("s1");
                currentFrame.setVisible(false);
                currentFrame=OptionsMenu;
                currentFrame.setVisible(true);
                questionManager.saveQuestions();
                break;
            case "Add Question":
                sound.playSound("s1");
                questionManager=new QuestionManager();
                currentFrame=QuestionAddMenu;
                currentFrame.setVisible(true);
                OptionsMenu.setVisible(false);
                addDocumentListenerQuAdd();
                break;
            case "Remove Question":
                sound.playSound("s1");
                questionManager=new QuestionManager();
                currentFrame=QuestionRemoveMenu;
                currentFrame.setVisible(true);
                OptionsMenu.setVisible(false);
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
                break;
            case "GuessThePic":
                sound.playSound("s1");
                new GuessThePicController(this);
                statistics=null;
                break;
            case "Quiz":
                sound.playSound("s1");
                new QuizController(this);
                statistics=null;
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

    public void shutdown() {
        currentFrame.dispose();
    }

    public void setVisible(boolean a){this.visibility=a;}

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
