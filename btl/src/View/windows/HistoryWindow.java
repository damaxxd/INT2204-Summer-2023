package View.windows;

import Controller.WindowsController.HistoryWindowController;
import Model.Word;
import View.buttons.ClearHistoryButton;

import java.util.ArrayList;
import java.util.HashSet;

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
        wordPanel.setLayout(new BoxLayout(wordPanel, BoxLayout.Y_AXIS)); // set words in vertical order.
        ArrayList<Word> currentHistory = HistoryWindowController.getHistoryWordsList();

        // Only allow target word to appear in history once
        // with recent most explain word
        HashSet<String> seen = new HashSet<String>();
        int index = 1;
        for (int i = currentHistory.size() - 1; i >= 0; i--) {
            Word word = currentHistory.get(i);
            if (!seen.contains(word.getWordTarget())) {
                wordPanel.add(new JLabel("   " + index + ". "
                        + word.getWordTarget() +
                        " : " + word.getWordExplain()
                        + System.lineSeparator()));
                seen.add(word.getWordTarget());
                index++;
            }
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
