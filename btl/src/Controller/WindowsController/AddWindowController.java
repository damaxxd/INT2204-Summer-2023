package Controller.WindowsController;

import Controller.DictionaryManagement;
import View.windows.AddWindow;

public class AddWindowController {
    private static AddWindow addWindow = new AddWindow();

    public static void addNewWord(String word_target, String word_explain) {
        try {
            DictionaryManagement.addWord(word_target, word_explain);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Somehow dispose method don't clear all the data so we close (dispose)
     * and then create a new find Window object.
     */
    public static void disposeWindow() {
        addWindow.closeWindow();
        addWindow = new AddWindow();
    }

    public static void openWindow() {
        addWindow.displayWindow();
    }
}
