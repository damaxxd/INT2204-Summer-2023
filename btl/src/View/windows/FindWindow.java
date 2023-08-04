package View.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        JTextField inputLine = new JTextField("Enter word here:");
        panel.add(inputLine);

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
