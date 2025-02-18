package CONTROLLER;

import VIEW.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauptController implements ActionListener {
    private JFrameE currentFrame;
    private String addQu;
    private String addAns;
    private String index;

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
        }
    }

    private void addDocumentListenerQuRemove() {
        currentFrame.getTextfield()[0].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }
        });
    }

    private void addDocumentListenerQuAdd() {
        currentFrame.getTextfield()[0].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }
        });

        currentFrame.getTextfield()[1].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                currentFrame.updateText();
            }
        });
    }
}
