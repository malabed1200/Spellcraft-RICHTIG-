package CONTROLLER;

import MODEL.Question;
import MODEL.QuestionManager;
import MODEL.Statistics;
import VIEW.QuizView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizController implements ActionListener {
    private Statistics statistics;
    private QuizView view;
    private QuestionManager questionManager;
    private int currentQuestionIndex = 0;

    public QuizController(Statistics statistics) {
        this.statistics = statistics;
        this.questionManager = new QuestionManager();
        questionManager.loadQuestions();
        startGame();
    }

    public void startGame() {
        this.view = new QuizView(this); // Erstelle die Ansicht mit dem Controller
        view.setQuestionText(getCurrentQuestionText()); // Setze die erste Frage
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Submit":
                checkAnswer();
                break;
            case "Back":
                view.dispose(); // Schließt das Quiz-Fenster
                new HauptController(); // Startet MainMenu neu
                break;
        }
    }

    private void checkAnswer() {
        String userAnswer = view.getAnswerText();
        Question currentQuestion = questionManager.getQuestion(currentQuestionIndex);

        if (currentQuestion != null) {
            if (currentQuestion.checkAnswer(userAnswer)) {
                JOptionPane.showMessageDialog(view, "Richtig!");
                statistics.incrementCorrect();
            } else {
                JOptionPane.showMessageDialog(view, "Falsch! Die richtige Antwort war: " + currentQuestion.getCorrectAnswer());
                statistics.incrementIncorrect();
            }
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
        return (question != null) ? question.getQuestionText() : null;
    }

    public void shutdown() {
        view.dispose();
    }
}
