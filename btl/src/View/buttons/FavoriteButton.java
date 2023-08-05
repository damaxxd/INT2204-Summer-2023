package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FavoriteButton extends Button {
    public FavoriteButton() {
        super();
    }

    @Override
    /**
     * Favorite Button Config.
     */
    public void buttonConfig() {
        button.setText("Clear History");
        button.setPreferredSize(new Dimension(200, 50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
