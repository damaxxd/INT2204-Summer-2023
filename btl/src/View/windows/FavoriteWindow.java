package View.windows;

import java.util.ArrayList;
import java.util.HashSet;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import Controller.WindowsController.FavoriteWindowController;
import Model.Word;
import View.buttons.ClearFavoriteButton;

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
        HashSet<String> seen = new HashSet<String>();
        int index = 1;
        for (int i = favoriteList.size() - 1; i >= 0; i--) {
            Word word = favoriteList.get(i);
            if (!seen.contains(word.getWordTarget())) {
                panel.add(new JLabel("   " + index + ". "
                            + word.getWordTarget() +
                            " : " + word.getWordExplain()
                            + System.lineSeparator()));
                seen.add(word.getWordTarget());
                index++;
            }
        }

        JButton clearFavoriteButton = (new ClearFavoriteButton()).getButton();
        panel.add(clearFavoriteButton);
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
