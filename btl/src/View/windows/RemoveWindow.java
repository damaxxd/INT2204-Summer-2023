package View.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        JTextField inputLine = new JTextField("Enter word here:");
        panel.add(inputLine);

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
