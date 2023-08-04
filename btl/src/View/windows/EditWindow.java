package View.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        JTextField targetWordLine = new JTextField("Enter word here:");
        panel.add(targetWordLine);

        JTextField explainWordLine = new JTextField("Enter explaination here:");
        panel.add(explainWordLine);

        // Add button
        JButton editButton = new JButton("Edit Word");
        editButton.addActionListener(new ActionListener() {
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
                
                String targetWord = targetWordLine.getText(); // get target word need to edit from user
                String explainWord = explainWordLine.getText(); // get explain word need to edit from user
                
                String resultString = EditWindowController.editTargetWord(targetWord, explainWord);
                if (DictionaryManagement.dictionaryLookup(targetWord) == explainWord) { // Edit successfully
                    resultString = "Succesfully edit Word";
                } else {
                    resultString = "Failed to edit Word";
                }
                retWindow.add(new JTextArea(resultString));
                retWindow.setVisible(true);
            }
        });
        panel.add(editButton);
    }

    @Override
    /**
     * Display this window.
     */
    public void displayWindow() {
        window.dispose(); // if double click then dispose the previous one
        windowConfig();
        panelConfig();
        window.add(panel);
        window.setVisible(true);
    }
}
