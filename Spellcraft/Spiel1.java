import MODEL.HangmanModel;
import VIEW.HangmanView;

public class Spiel1 {
    public static void main(String[] args) {
        HangmanModel model = new HangmanModel();
        new HangmanView(model);
    }
}