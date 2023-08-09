package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import com.sun.speech.freetts.*;

public class PronounceButton extends Button {
    public PronounceButton() {
        super();
    }

    public void buttonConfig() {
        button.setPreferredSize(new Dimension(30, 30));
        button.setIcon(new ImageIcon("btl/src/resources/icon/speaker_icon.png"));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targetWord = View.windows.FindWindow.getTargetWord();
                try {
                    System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
                    Voice voice = VoiceManager.getInstance().getVoice("kevin16");
                    if (voice == null) {
                        System.err.println("No voice found");
                        System.exit(1);
                    }
                    voice.allocate();
                    voice.setRate(160);
                    voice.setPitch(110);
                    voice.setVolume(1);
                    voice.speak(targetWord);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
