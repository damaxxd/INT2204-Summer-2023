package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import Controller.WindowsController.RemoveWindowController;

public class RemoveButton extends Button {
    
    public RemoveButton() {
        super();
    }

    @Override
    /**
     * Buttn config
     */
    public void buttonConfig() {
        button.setText("Remove Word");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/remove_icon.png"));
        // removeButton.setIconTextGap(10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveWindowController.disposeWindow();
                RemoveWindowController.openWindow();
            }
        });
    }
}
