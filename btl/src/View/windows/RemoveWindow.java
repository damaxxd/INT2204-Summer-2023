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
        constraints.gridx = 0; // column
        constraints.gridy = 0; // row
        constraints.gridwidth = 1; // column width
        constraints.gridheight = 1; // row height
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 2); // some padding
        panel.add(inputLabel, constraints); // add component with constraints

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

        // Remove button
        JButton removeButton = new JButton("Remove Word");
        removeButton.addActionListener(new ActionListener() {
            JFrame retWindow = new JFrame();

            @Override
            public void actionPerformed(ActionEvent e) {
                // ***********************************
                // ***** DISPLAY RESULT WINDOW *******
                // ***********************************
                retWindow.dispose();
                retWindow = new JFrame(); // close the previous result if clicked confirm button twice
                retWindow.setTitle("Result");
                retWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retWindow.setSize(350, 300);
                retWindow.setLocationRelativeTo(null);

                String targetWord = inputLine.getText(); // get word need to remove from user

                String resultString = "";
                RemoveWindowController.removeInputWord(targetWord);
                if (DictionaryManagement.getIndexByWord(targetWord) == -1) { // Remove successfully (get word index in
                                                                             // dict = -1)
                    resultString = "Succesfully remove Word";
                } else {
                    resultString = "Failed to remove Word";
                }
                retWindow.add(new JTextArea(resultString));
                retWindow.setVisible(true);
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
        panel.add(removeButton, constraints);
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
