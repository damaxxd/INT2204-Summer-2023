package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.WindowsController.FindWindowController;

public class FindButton extends Button {

    public FindButton() {
        super();
    }

    @Override
    /**
     * Favorite Button config.
     */
    public void buttonConfig() {
        button.setText("Find Word");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/find_icon.png"));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindWindowController.disposeWindow();
                FindWindowController.openWindow();
            }
        });
    }
}
