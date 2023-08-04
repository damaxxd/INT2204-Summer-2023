package View.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        JTextField targetWordLine = new JTextField("Enter word here:");
        panel.add(targetWordLine);

        JTextField explainWordLine = new JTextField("Enter explaination here:");
        panel.add(explainWordLine);

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
        panel.add(addButton);
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
