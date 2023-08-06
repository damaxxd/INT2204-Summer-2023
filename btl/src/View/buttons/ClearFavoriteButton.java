package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.WindowsController.FavoriteWindowController;
import Controller.WindowsController.HistoryWindowController;

public class ClearFavoriteButton extends Button {
    public ClearFavoriteButton() {
        super();
    }

    /**
     * Button config.
     */
    public void buttonConfig() {
        button.setText("Clear Favorite Words");
        button.setPreferredSize(new Dimension(200, 50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FavoriteWindowController.clearFavoriteWordsList();
                FavoriteWindowController.disposeWindow();
                FavoriteWindowController.openWindow();
            }
        });
    }
}
