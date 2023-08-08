package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controller.WindowsController.AddWindowController;

public class AddButton extends Button {
    
    public AddButton() {
        super();
    }

    @Override
    /**
     * Word Adding Button config.
     */
    public void buttonConfig() {
        button.setText("Add Word");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/add_icon.png"));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWindowController.disposeWindow();
                AddWindowController.openWindow();
            }
        });
    }
}
