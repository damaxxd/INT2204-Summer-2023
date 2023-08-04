package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import View.windows.AddWindow;

public class AddButton extends Button {
    
    AddWindow addWindow = new AddWindow();
    
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
        button.setIcon(new ImageIcon("src/resources/icon/add_icon.png"));
        // addButton.setIconTextGap(10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWindow.displayWindow();
            }
        });
    }
}
