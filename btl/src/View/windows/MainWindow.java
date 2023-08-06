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
import View.buttons.FavoriteButton;
import View.buttons.FindButton;
import View.buttons.HistoryButton;
import View.buttons.RemoveButton;

public class MainWindow extends Window {
    JButton findButton;
    JButton addButton;
    JButton removeButton;
    JButton editButton;
    JButton historyButton;
    JButton favoriteButton;
    
    /**
     *  Constructor.
     */
    public MainWindow() {
        super();
        findButton = (new FindButton()).getButton();
        addButton = (new AddButton()).getButton();
        removeButton = (new RemoveButton()).getButton();
        editButton = (new EditButton()).getButton();
        historyButton = (new HistoryButton()).getButton();
        favoriteButton = (new FavoriteButton()).getButton();
    }

    @Override
    /**
     * Main Window Configuration and Initialize.
     */
    public void windowConfig() {
        window.setTitle("Dictionary Application");
        window.setSize(300, 370);
        window.setLocationRelativeTo(null); // center the window to the screen
    }

    @Override
    /**
     * Panel Configuration and Intialize.
     */
    public void panelConfig() {
        panel = new JPanel();
        panel.add(findButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(editButton);
        panel.add(historyButton);
        panel.add(favoriteButton);
    }

    @Override
    /**
     * Display this window.
     */
    public void displayWindow() {
        windowConfig();
        panelConfig();
        window.add(panel);
        window.setVisible(true);
    }
}
