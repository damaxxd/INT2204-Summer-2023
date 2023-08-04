package View.buttons;

import javax.swing.JButton;


/**
 * Abstract class to config and get button for GUI
 */
public abstract class Button {
    protected JButton button;

    /**
     * Contructor.
     */
    public Button() {
        button = new JButton();
    }

    /**
     * Button config.
     */
    public abstract void buttonConfig();

    /**
     * Config and Get button.
     */
    public JButton getButton() {
        buttonConfig();
        return button;
    }

}
