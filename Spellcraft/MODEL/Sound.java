package MODEL;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound implements LineListener {
    private String sfx="Spellcraft/Sounds/";
    private String music="Spellcraft/Sounds/Music/";
    private Clip clip;

    //1=click, 2=correct, 3=Dead, 4=wrong

    public void playSound(String name) {
        String pfad;

        if(name.charAt(0)=='s'){
            pfad=sfx+name.charAt(1)+".wav";
        }else{
            pfad=music+name+".wav";
        }

        File file=new File(pfad);

        try {
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            if(!(name.charAt(0)=='s')){
                clip.addLineListener(this);
            }
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playMusic(){
        int randomNumber = 1 + (int)(Math.random() * 7);
        playSound(""+randomNumber);
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            clip.close();
            playMusic(); // Call method to handle end of sound
        }
    }
}
