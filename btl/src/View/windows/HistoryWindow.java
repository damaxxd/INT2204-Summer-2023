package View.windows;

import Controller.WindowsController.HistoryWindowController;
import Model.Word;
import View.buttons.ClearHistoryButton;

import java.util.Set;
import java.util.Stack;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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

        JPanel wordPanel = new JPanel();
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.Y_AXIS));
        Stack<Word> currentHistory = HistoryWindowController.getHistoryWordsStack();
        int index = 1;
        for (Word word : currentHistory) {
            wordPanel.add(new JLabel("   " + index + ". "
                    + word.getWordTarget() + " : " + word.getWordExplain() + "\n"));
            index++;
        }
        wordPanel.add(new JLabel(System.lineSeparator()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton clearHistoryButton = (new ClearHistoryButton()).getButton();
        buttonPanel.add(clearHistoryButton);

        panel.add(wordPanel);
        panel.add(buttonPanel);
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
