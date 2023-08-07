package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class PronounceButton extends Button {
    public PronounceButton() {
        super();
    }

    public void buttonConfig() {
        button.setPreferredSize(new Dimension(30, 30));
        button.setIcon(new ImageIcon("btl/src/resources/icon/speaker_icon.png"));
        // button.setHorizontalAlignment(SwingConstants.LEFT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
