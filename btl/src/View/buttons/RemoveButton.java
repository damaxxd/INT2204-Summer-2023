package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import View.windows.RemoveWindow;

public class RemoveButton extends Button {
    RemoveWindow removeWindow = new RemoveWindow();
    
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
        button.setIcon(new ImageIcon("src/resources/icon/remove_icon.png"));
        // removeButton.setIconTextGap(10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeWindow.displayWindow();
            }
        });
    }
}
