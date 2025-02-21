package CONTROLLER;

import MODEL.QuestionManager;
import MODEL.Statistics;
import VIEW.QuizView;
import VIEW.PlayMenu;

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
    }

    public void startGame() {  // **Füge diese Methode hinzu**
        this.view = new QuizView(this, statistics);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Back".equals(command)) {
            view.dispose();
            new PlayMenu(new HauptController(), statistics);
        }

        if ("Submit".equals(command)) {
            checkAnswer();
        }
    }

    private void checkAnswer() {
        String userAnswer = view.getAnswerText();
        if (questionManager.getQuestion(currentQuestionIndex) != null) {
            if (questionManager.getQuestion(currentQuestionIndex).checkAnswer(userAnswer)) {
                JOptionPane.showMessageDialog(view, "Richtig!");
                statistics.incrementCorrect();
            } else {
                JOptionPane.showMessageDialog(view, "Falsch! Die richtige Antwort war: "
                        + questionManager.getQuestion(currentQuestionIndex).getCorrectAnswer());
                statistics.incrementIncorrect();
            }
            nextQuestion();
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        if (questionManager.getQuestion(currentQuestionIndex) != null) {
            view.setQuestionText(questionManager.getQuestion(currentQuestionIndex).getQuestionText());
        } else {
            JOptionPane.showMessageDialog(view, "Quiz beendet!");
            view.dispose();
        }
    }
}
