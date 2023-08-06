package View.windows;

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

/**
 * Word Finding Window Configuration
 */
public class FindWindow extends Window {
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
        constraints.gridx = 0; // first column
        constraints.gridy = 0; // first row
        constraints.gridwidth = 1; // one column wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(enterFindLabel, constraints); // add component with constraints


        JTextField inputLine = new JTextField();
        constraints.gridx = 1; // second column
        constraints.gridy = 0; // first row
        constraints.gridwidth = 2; // two columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.HORIZONTAL; // resize horizontally
        constraints.weightx = 1; // extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(inputLine, constraints); // add component with constraints

        JButton confirmButton = new JButton("Find Word");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ***********************************
                // ***** DISPLAY RESULT WINDOW *******
                // ***********************************
                
                JFrame resWindow = new JFrame();

                // *** Uncomment this two line if only want one window at a time in find word window ***
                
                // resWindow.dispose(); // close the previous result if clicked confirm button twice
                // resWindow = new JFrame();

                resWindow.setTitle("Result");
                resWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                resWindow.setSize(350, 300);
                resWindow.setLocationRelativeTo(null);
                
                String targetWord = inputLine.getText(); // get input from user
                String resultWord = FindWindowController.findWord(targetWord);
                JTextArea resultTextArea;
                if (resultWord == "") { // word not in dictionary
                    resultTextArea = new JTextArea("  Word does not exist in dictionary!"); 
                } else { // find the word
                    resultTextArea = new JTextArea("  " + targetWord + " :  " + resultWord); 
                }
                resWindow.add(resultTextArea);
                resWindow.setVisible(true);
            }
        });
        
        panel.add(confirmButton);
        constraints.gridx = 0; // first column
        constraints.gridy = 1; // second row
        constraints.gridwidth = 3; // three columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.anchor = GridBagConstraints.CENTER; // center position
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(confirmButton, constraints); // add component with constraints

        ///**
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

                // *** Uncomment this two line if only want one window at a time in find word window ***
                // retWindow.dispose(); // close the previous result if clicked confirm button twice // 1
                // retWindow = new JFrame();                                                         // 2

                retWindow.setTitle("Result");
                retWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retWindow.setSize(350, 300);
                retWindow.setLocationRelativeTo(null);
                
                String targetWord = inputLine.getText(); // get input from user
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

        panel.add(addToFavoriteButton);
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
