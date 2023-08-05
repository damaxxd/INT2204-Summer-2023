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
                JFrame retWindow = new JFrame();
                retWindow.setTitle("Result");
                retWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retWindow.setSize(350, 300);
                retWindow.setLocationRelativeTo(null);
                
                String targetWord = inputLine.getText(); // get input from user
                String resultWord = FindWindowController.findWord(targetWord);
                if (resultWord == "") { // word not in dictionary
                    resultWord = "Word does not exist in dictionary!";
                }
                JTextArea resulTextArea = new JTextArea("  " + resultWord);
                retWindow.add(resulTextArea);
                retWindow.setVisible(true);
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
