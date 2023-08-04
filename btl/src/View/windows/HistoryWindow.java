package View.windows;

import Controller.WindowsController.HistoryWindowController;
import Model.Word;
import View.buttons.ClearHistoryButton;

import java.util.Set;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HistoryWindow extends Window {
    /**
     * Constructor.
     */
    public HistoryWindow() {
        super();
    }

    @Override
    /**
     * History Window Config.
     */
    public void windowConfig() {
        window.setTitle("History Window");
        window.setSize(350, 400);
        window.setLocationRelativeTo(null);
    }

    @Override
    /**
     * History Panel Config.
     */
    public void panelConfig() {
        panel = new JPanel();
        Stack<Word> currentHistory = HistoryWindowController.getHistoryWordsStack();
        int index = 1;
        for (Word word : currentHistory) {
            panel.add(new JLabel("   " + index + ". "
                        + word.getWordTarget() + ": " + word.getWordExplain() + "\n"));
            index++;
        }
        // panel.add(new JLabel("\n"));
        // JButton clearHistoryButton = (new ClearHistoryButton()).getButton();
        // panel.add(clearHistoryButton);
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
