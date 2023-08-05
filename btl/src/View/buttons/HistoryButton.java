package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import View.windows.HistoryWindow;

public class HistoryButton extends Button {
    public static HistoryWindow historyWindow;

    public HistoryButton() {
        super();
    }

    @Override
    /**
     * History button config.
     */
    public void buttonConfig() {
        button.setText("Show History");
        button.setPreferredSize(new Dimension(200, 50));
        button.setIcon(new ImageIcon("btl/src/resources/icon/history_icon.png"));
        // addButton.setIconTextGap(10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historyWindow = new HistoryWindow();
                historyWindow.displayWindow();
            }
        });
    }
}
