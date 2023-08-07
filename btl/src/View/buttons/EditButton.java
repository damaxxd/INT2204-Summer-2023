package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.WindowsController.EditWindowController;

public class EditButton extends Button {
    public EditButton() {
        super();
    }

    @Override
    /**
     * Edit Button config.
     */
    public void buttonConfig() {
        button.setText("Edit Word");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/edit_icon.png"));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditWindowController.disposeWindow();
                EditWindowController.openWindow();
            }
        });
    }
}
