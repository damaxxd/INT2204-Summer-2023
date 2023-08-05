package Controller.WindowsController;

import Controller.DictionaryManagement;
import View.windows.EditWindow;

public class EditWindowController {
    private static EditWindow editWindow = new EditWindow();

    public static String editTargetWord(String targetWord, String explainWord) {
        try {
            return DictionaryManagement.editWord(targetWord, explainWord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Failed to edit word";
        }
    }

    /**
     * Somehow dispose method don't clear all the data so we close (dispose)
     * and then create a new find Window object.
     */
    public static void disposeWindow() {
        editWindow.closeWindow();
        editWindow = new EditWindow();
    }

    public static void openWindow() {
        editWindow.displayWindow();
    }
}
