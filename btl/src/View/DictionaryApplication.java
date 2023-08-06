package View;

import javax.swing.SwingUtilities; // Execute on Event Dispatch Thread
import java.io.IOException;

import Controller.*;
import Controller.WindowsController.FavoriteWindowController;
import View.windows.MainWindow;

class DictionaryApplication {
    public static void main(String args[]) throws IOException {
        // Execute on Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * Main program.
             */
            public void run() {
                // Load files
                DictionaryManagement.dictionaryLoadAllFiles();
                
                // Main window
                MainWindow mainWindow = new MainWindow();
                mainWindow.displayWindow();
            }
        });
    }
}