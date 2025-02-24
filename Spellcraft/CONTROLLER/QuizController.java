package CONTROLLER;

import MODEL.Question;
import MODEL.QuestionManager;
import MODEL.Sound;
import MODEL.Statistics;
import VIEW.QuizView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController implements ActionListener {
    private Statistics statistics=new Statistics();
    private QuizView view;
    private QuestionManager questionManager;
    private int currentQuestionIndex = 0;
    private Sound sound = new Sound();
    private HauptController hc;

    public QuizController(HauptController hc) {
        this.hc=hc;
        this.questionManager = new QuestionManager();
        questionManager.loadQuestions();
        startGame();
    }

    public void startGame() {
        this.view = new QuizView(this);
        view.setQuestionText(getCurrentQuestionText());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Submit":
                sound.playSound("s1");
                checkAnswer();
                break;
            case "Back":
                sound.playSound("s1");
                view.dispose();
                hc.startHC();
                break;
        }
    }

    private void checkAnswer() {
        String userAnswer = view.getAnswerText();
        Question currentQuestion = questionManager.getQuestion(currentQuestionIndex);

        if (currentQuestion != null) {
            if (currentQuestion.checkAnswer(userAnswer)) {
                sound.playSound("s2");
                JOptionPane.showMessageDialog(view, "Richtig!");
                statistics.incrementCorrect();  // SPEICHERT RICHTIGE ANTWORT
            } else {
                sound.playSound("s4");
                JOptionPane.showMessageDialog(view, "Falsch! Die richtige Antwort war: " + currentQuestion.getCorrectAnswer());
                statistics.incrementIncorrect();  // SPEICHERT FALSCHE ANTWORT
            }
            statistics.save(); // SPEICHERT WERTE DAUERHAFT
            nextQuestion();
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        String nextQuestionText = getCurrentQuestionText();

        if (nextQuestionText != null) {
            view.setQuestionText(nextQuestionText);
            view.clearAnswerField();
        } else {
            JOptionPane.showMessageDialog(view, "Quiz beendet!");
            shutdown();
        }
    }

    private String getCurrentQuestionText() {
        Question question = questionManager.getQuestion(currentQuestionIndex);
        if(question != null) {
            return question.getQuestionText();
        }
        return null;
    }

    public void shutdown() {
        view.dispose();
    }
}
