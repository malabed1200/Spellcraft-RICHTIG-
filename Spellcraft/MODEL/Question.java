package MODEL;

public class Question {
    private String questionText;
    private String correctAnswer;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return "Q: "+questionText+"\nA: "+correctAnswer;
    }

    public String getQuestionText() {  // **Diese Methode wird gebraucht!**
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }

    public String getData() {
        return "&???"+questionText+"???!!!"+correctAnswer+"!!!&";
    }
}
