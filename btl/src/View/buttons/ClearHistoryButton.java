package View.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.WindowsController.HistoryWindowController;
import View.buttons.HistoryButton.*;
import View.windows.HistoryWindow;

public class ClearHistoryButton extends Button {
    public ClearHistoryButton() {
        super();
    }

    /**
     * Button config.
     */
    public void buttonConfig() {
        button.setText("Clear History");
        button.setPreferredSize(new Dimension(200, 50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryWindowController.clearHistoryWordsStack();
            }
        });
    }
}
