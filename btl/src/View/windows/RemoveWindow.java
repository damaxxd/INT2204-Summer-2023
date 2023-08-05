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

import Controller.DictionaryManagement;
import Controller.WindowsController.RemoveWindowController;

public class RemoveWindow extends Window {
    /**
     * Constructor.
     */
    public RemoveWindow() {
        super();
        window.setTitle("Word Removing Window");
        window.setSize(300, 275);
        window.setLocationRelativeTo(null); // center the window to the screen
    }

    @Override
    /** 
     * Init and config word removing window.
     */
    public void windowConfig() {
        window.setTitle("Word Removing Window");
        window.setSize(300, 275);
        window.setLocation(960, 540);
    }

    @Override
    /** 
     * Init and config word removing panel.
     */
    public void panelConfig() {
        panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel inputLabel = new JLabel("Enter word here:");
        constraints.gridx = 0; // first column
        constraints.gridy = 0; // first row
        constraints.gridwidth = 1; // one column wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(inputLabel, constraints); // add component with constraints
        
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

        // Remove button
        JButton removeButton = new JButton("Remove Word");
        removeButton.addActionListener(new ActionListener() {
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
                
                String targetWord = inputLine.getText(); // get word need to remove from user
                
                String resultString = "";
                RemoveWindowController.removeInputWord(targetWord);
                if (DictionaryManagement.getIndexByWord(targetWord) == -1) { // Remove successfully (get word index in dict = -1)
                    resultString = "Succesfully remove Word";
                } else {
                    resultString = "Failed to remove Word";
                }
                retWindow.add(new JTextArea(resultString));
                retWindow.setVisible(true);
            }
        });
        panel.add(removeButton);
        constraints.gridx = 0; // first column
        constraints.gridy = 1; // second row
        constraints.gridwidth = 3; // three columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.anchor = GridBagConstraints.CENTER; // center position
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(removeButton, constraints); // add component with constraints
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
