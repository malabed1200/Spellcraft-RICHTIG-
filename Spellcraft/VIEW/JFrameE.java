package VIEW;

import javax.swing.*;

public abstract class JFrameE extends JFrame {
    public void updateInt(int correct, int incorrect){}
    public abstract void updateTextAnswer();
    public abstract JTextField[] getTextfield();

    @Override
    public void setVisible(boolean b){super.setVisible(b);}
}
