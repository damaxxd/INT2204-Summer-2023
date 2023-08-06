package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Controller.WindowsController.FavoriteWindowController;

public class FavoriteButton extends Button {
    public FavoriteButton() {
        super();
    }

    @Override
    /**
     * Favorite Button Config.
     */
    public void buttonConfig() {
        button.setText("Favorite Words");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/favorite_icon.png"));
        // findButton.setIconTextGap(0);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FavoriteWindowController.disposeWindow();
                FavoriteWindowController.openWindow();
            }
        });
    }
}
