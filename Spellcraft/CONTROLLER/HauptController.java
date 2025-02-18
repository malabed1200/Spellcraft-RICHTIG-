package CONTROLLER;

import MODEL.QuestionManager;
import VIEW.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauptController implements ActionListener {
    private JFrameE currentFrame;
    private String addQu="";
    private String addAns="";
    private String index="-1";

    private QuestionManager questionManager=new QuestionManager();


    public HauptController() {
        currentFrame = new MainMenu(this);
    }

    public static void main(String[] args) {HauptController haupt = new HauptController();}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                currentFrame.dispose();
                break;
            case "Stats":
                currentFrame.dispose();
                break;
            case "Options":
                currentFrame.dispose();
                currentFrame=new OptionsMenu(this);
                break;
            case "BackH":
                currentFrame.dispose();
                currentFrame=new MainMenu(this);
                break;
            case "Add Question":
                currentFrame.dispose();
                currentFrame=new QuestionAddMenu(this);
                addDocumentListenerQuAdd();
                break;
            case "Remove Question":
                currentFrame.dispose();
                currentFrame=new QuestionRemoveMenu(this);
                addDocumentListenerQuRemove();
                break;
            case "Add":
                String antwort=questionManager.addQuestion(addQu, addAns);
                JOptionPane.showMessageDialog(currentFrame,antwort);
                currentFrame.updateTextAnswer();
                break;
            case "Remove":
                String antwort1=questionManager.removeQuestion(index);
                JOptionPane.showMessageDialog(currentFrame,antwort1);
                currentFrame.updateTextAnswer();
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
