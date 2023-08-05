package View.windows;

import java.util.ArrayList;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.WindowsController.FavoriteWindowController;
import Model.Word;

public class FavoriteWindow extends Window {
    /**
     * Constructor.
     */
    public FavoriteWindow() {
        super();
    }

    @Override
    /**
     * History Window Config.
     */
    public void windowConfig() {
        window.setTitle("Favorite Words");
        window.setSize(350, 400);
        window.setLocationRelativeTo(null);
    }

    @Override
    /**
     * History Panel Config.
     */
    public void panelConfig() {
        panel = new JPanel();
        ArrayList<Word> favoriteList = FavoriteWindowController.getFavoriteWordsList();
        int index = 1;
        for (Word word : favoriteList) {
            panel.add(new JLabel("   " + index + ". "
                        + word.getWordTarget() + " : " + word.getWordExplain() + System.lineSeparator()));
            index++;
        }
        panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // align left
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
