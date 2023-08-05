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
import Controller.WindowsController.AddWindowController;

public class AddWindow extends Window {
    /**
     * Constructor.
     */
    public AddWindow() {
        super();
    }

    @Override
    /**
     * Init and config word adding window.
     */
    public void windowConfig() {
        window.setTitle("Word Adding Window");
        window.setSize(300, 275);
        window.setLocation(960, 265);
    }

    @Override
    /**
     * Init and config word adding panel.
     */
    public void panelConfig() {
        panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel enterWordNotice = new JLabel("Enter word here: ");
        constraints.gridx = 0; // first column
        constraints.gridy = 0; // first row
        constraints.gridwidth = 1; // one column wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(enterWordNotice, constraints); // add component with constraints

        JTextField targetWordLine = new JTextField();
        constraints.gridx = 1; // second column
        constraints.gridy = 0; // first row
        constraints.gridwidth = 2; // two columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.HORIZONTAL; // resize horizontally
        constraints.weightx = 1; // extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(targetWordLine, constraints); // add component with constraints

        JLabel label2 = new JLabel("Enter explanation here: ");
        constraints.gridx = 0; // first column
        constraints.gridy = 1; // second row
        constraints.gridwidth = 1; // one column wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(label2, constraints); // add component with constraints

        JTextField explainWordLine = new JTextField();
        constraints.gridx = 1; // second column
        constraints.gridy = 1; // second row
        constraints.gridwidth = 2; // two columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.HORIZONTAL; // resize horizontally
        constraints.weightx = 1; // extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(explainWordLine, constraints); // add component with constraints

        // Add button
        JButton addButton = new JButton("Add Word");
        addButton.addActionListener(new ActionListener() {
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

                String targetWord = targetWordLine.getText(); // get target word need to add from user
                String explainWord = explainWordLine.getText(); // get explain word need to add from user

                String resultString = "";
                AddWindowController.addNewWord(targetWord, explainWord);
                if (DictionaryManagement.dictionaryLookup(targetWord) != "") { // Insert successfully
                    resultString = "Succesfully insert Word";
                } else {
                    resultString = "Failed to insert Word";
                }
                retWindow.add(new JTextArea(resultString));
                retWindow.setVisible(true);
            }
        });
        constraints.gridx = 0; // first column
        constraints.gridy = 2; // third row
        constraints.gridwidth = 3; // three columns wide
        constraints.gridheight = 1; // one row high
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.anchor = GridBagConstraints.CENTER; // center position
        constraints.insets = new Insets(5, 5, 5, 5); // some padding
        panel.add(addButton, constraints); // add component with constraints
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
