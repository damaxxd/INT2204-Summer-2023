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
import Controller.WindowsController.EditWindowController;

public class EditWindow extends Window {
    /**
     * Constructor.
     */
    public EditWindow() {
        super();
    }

    @Override
    /**
     * Init and config word adding window.
     */
    public void windowConfig() {
        window.setTitle("Word Editing Window");
        window.setSize(300, 275);
        window.setLocation(300, 540);
    }

    @Override
    /**
     * Init and config word editing panel.
     */
    public void panelConfig() {
        panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel targetWordLabel = new JLabel("Enter word here:");
        constraints.gridx = 0; // column
        constraints.gridy = 0; // row
        constraints.gridwidth = 1; // column width
        constraints.gridheight = 1; // row height
        constraints.fill = GridBagConstraints.NONE; // do not resize
        constraints.weightx = 0; // no extra horizontal space
        constraints.weighty = 0; // no extra vertical space
        constraints.insets = new Insets(5, 5, 5, 2); // some padding
        constraints.anchor = GridBagConstraints.WEST; // set position
        panel.add(targetWordLabel, constraints); // add component with constraints

        JTextField targetWordLine = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(5, 2, 5, 5);
        panel.add(targetWordLine, constraints);

        JLabel explainWordLabel = new JLabel("Enter explaination here:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(5, 5, 5, 2);
        panel.add(explainWordLabel, constraints);

        JTextField explainWordLine = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(5, 2, 5, 5);
        panel.add(explainWordLine, constraints);

        // Add button
        JButton editButton = new JButton("Edit Word");
        editButton.addActionListener(new ActionListener() {
            JFrame retWindow = new JFrame();

            @Override
            public void actionPerformed(ActionEvent e) {
                // ***********************************
                // ***** DISPLAY RESULT WINDOW *******
                // ***********************************
                retWindow.dispose(); // close the previous result if clicked confirm button twice
                retWindow = new JFrame();
                retWindow.setTitle("Edit Result");
                retWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retWindow.setSize(350, 300);
                retWindow.setLocationRelativeTo(null);

                String targetWord = targetWordLine.getText(); // get target word need to edit from user
                String explainWord = explainWordLine.getText(); // get explain word need to edit from user

                String resultString = "Failed to edit Word";
                if (targetWord.length() > 0 && explainWord.length() > 0) {
                    resultString = EditWindowController.editTargetWord(targetWord, explainWord);
                    if (DictionaryManagement.dictionaryLookup(targetWord) == explainWord) { // Edit successfully
                        resultString = "Succesfully edit Word";
                    }
                }
                retWindow.add(new JTextArea(resultString));
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
        panel.add(editButton, constraints);
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
