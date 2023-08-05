package View.windows;

import Controller.WindowsController.HistoryWindowController;
import Model.Word;
import View.buttons.ClearHistoryButton;

import java.util.Set;
import java.util.Stack;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        window.setTitle("History Words");
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
                        + word.getWordTarget() + " : " + word.getWordExplain() + "\n"));
            index++;
        }
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // align left
        panel.add(new JLabel("\n"));

        JButton clearHistoryButton = (new ClearHistoryButton()).getButton();
        panel.add(clearHistoryButton);
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
