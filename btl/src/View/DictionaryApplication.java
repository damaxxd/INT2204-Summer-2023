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
                // Insert Word from file
                try {
                    DictionaryManagement.insertFromFile();
                    DictionaryManagement.loadHistoryFile();
                    FavoriteWindowController.loadFavoriteFile();
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                }
                
                // Main window
                MainWindow mainWindow = new MainWindow();
                mainWindow.displayWindow();
            }
        });
    }
}