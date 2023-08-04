package View.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.buttons.AddButton;
import View.buttons.EditButton;
import View.buttons.FindButton;
import View.buttons.HistoryButton;
import View.buttons.RemoveButton;

public class MainWindow extends Window {
    /**
     *  Constructor.
     */
    public MainWindow() {
        super();
    }

    @Override
    /**
     * Main Window Configuration and Initialize.
     */
    public void windowConfig() {
        window.setTitle("Dictionary Application");
        window.setSize(300, 320);
        window.setLocationRelativeTo(null); // center the window to the screen
    }

    @Override
    /**
     * Panel Configuration and Intialize.
     */
    public void panelConfig() {
        panel = new JPanel();
        /**
         * Find Button.
         */
        JButton findButton = (new FindButton()).getButton();
        panel.add(findButton);

        /**
         * Add Button.
         */
        JButton addButton = (new AddButton()).getButton();
        panel.add(addButton);

        /**
         * Remove Button.
         */
        JButton removeButton = (new RemoveButton()).getButton();
        panel.add(removeButton);

        /**
         * Edit Button.
         */
        JButton editButton = (new EditButton()).getButton();
        panel.add(editButton);

        /**
         * History Button.
         */
        JButton historyButton = (new HistoryButton()).getButton();
        panel.add(historyButton);
    }

    @Override
    /**
     * Display this window.
     */
    public void displayWindow() {
        window.dispose(); // if double click then dispose the previous one
        windowConfig();
        panelConfig();
        window.add(panel);
        window.setVisible(true);
    }
}
