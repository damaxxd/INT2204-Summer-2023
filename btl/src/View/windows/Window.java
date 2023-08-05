package View.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Abstract class for displaying and configurating windows
 */
public abstract class Window {
    protected JFrame window;
    protected JPanel panel;

    /**
     * Constructor.
     */
    public Window() {
        window = new JFrame();
        panel = new JPanel();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /** 
     * Init word finding window
     */
    public abstract void windowConfig();
    
    /**
     * Panel Configuration and Intialize.
     */
    public abstract void panelConfig();

    /**
     * Display this window.
     */
    public abstract void displayWindow();

    /**
     * Close window.
     */
    public void closeWindow() {
        window.dispose();
    }

}
