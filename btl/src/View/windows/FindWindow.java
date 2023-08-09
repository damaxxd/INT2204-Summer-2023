package View.windows;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.WindowsController.FindWindowController;
import Model.Word;
import View.buttons.PronounceButton;

/**
 * Word Finding Window Configuration
 */
public class FindWindow extends Window {
    public static String targetWord;

    public static String getTargetWord() {
        return targetWord;
    }

    /**
     * Constructor.
     */
    public FindWindow() {
        super();
    }

    @Override
    /**
     * Init and config word finding window.
     */
    public void windowConfig() {
        window.setTitle("Word Finding Window");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(300, 275);
        window.setLocation(300, 265);
    }

    @Override
    /**
     * Init and config word finding panel.
     */
    public void panelConfig() {
        panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel enterFindLabel = new JLabel("Enter word here:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 2);
        panel.add(enterFindLabel, constraints);

        JTextField inputLine = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(5, 2, 5, 5);
        panel.add(inputLine, constraints);

        JButton confirmButton = new JButton("Find Word");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ***********************************
                // ***** DISPLAY RESULT WINDOW *******
                // ***********************************

                JFrame resWindow = new JFrame();

                // *** Uncomment this two line if only want one window at a time in find word
                // window ***

                // resWindow.dispose(); // close the previous result if clicked confirm button
                // twice
                // resWindow = new JFrame();

                resWindow.setTitle("Result");
                resWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resWindow.setSize(350, 300);
                resWindow.setLocationRelativeTo(null);

                JPanel resPanel = new JPanel();
                resPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

                JButton proButton = (new PronounceButton()).getButton();

                targetWord = inputLine.getText().toLowerCase(); // get input from user
                String resultWord = FindWindowController.findWord(targetWord);
                JTextArea resultTextArea;
                if (resultWord == "") { // word not in dictionary
                    resultTextArea = new JTextArea("Word does not exist in dictionary!");
                } else { // find the word
                    resultTextArea = new JTextArea("  " + targetWord + " :  " + resultWord);
                    resPanel.add(proButton);
                }
                resPanel.add(resultTextArea);
                resWindow.add(resPanel);
                resWindow.setVisible(true);
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(confirmButton, constraints);

        /// **
        // * add to favorite button
        // */
        JButton addToFavoriteButton = new JButton("Add to Favorite");
        addToFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ***********************************
                // ***** DISPLAY RESULT WINDOW *******
                // ***********************************

                JFrame retWindow = new JFrame();

                // *** Uncomment this two line if only want one window at a time in find word
                // window ***
                // retWindow.dispose(); // close the previous result if clicked confirm button
                // twice // 1
                // retWindow = new JFrame(); // 2

                retWindow.setTitle("Result");
                retWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retWindow.setSize(350, 300);
                retWindow.setLocationRelativeTo(null);

                targetWord = inputLine.getText().toLowerCase(); // get input from user
                String explainWord = FindWindowController.findWord(targetWord);
                JTextArea resultTextArea;
                if (explainWord.length() == 0) { // word not in dictionary
                    resultTextArea = new JTextArea("  Word does not exist in dictionary!");
                } else { // find the word
                    FindWindowController.addToFavoriteList(new Word(targetWord, explainWord));
                    resultTextArea = new JTextArea("Succesfully add to Favorite word");
                }
                retWindow.add(resultTextArea);
                retWindow.setVisible(true);
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(addToFavoriteButton, constraints);
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
