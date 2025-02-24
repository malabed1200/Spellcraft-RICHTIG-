import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Java Program");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set custom icon
        ImageIcon icon = new ImageIcon("Spellcraft/Bilder/Logo.png");
        if(!(icon.getImage()==null)){
            System.out.println("Icon not found");
        }
        try {
            URL url = new URL("https://images.microcms-assets.io/assets/f76ce1c9d600493d9aabe1847913815c/9df226f0e8084da1b090d8bc0414965b/dsmc-100a_keyvisual_01.png?fm=webp");
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image img = kit.createImage(url);
            frame.setIconImage(img);
        }catch(Exception a){

        }

        frame.setVisible(true);
    }
}