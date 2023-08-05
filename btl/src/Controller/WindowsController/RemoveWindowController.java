package Controller.WindowsController;

import Controller.DictionaryManagement;
import View.windows.RemoveWindow;

public class RemoveWindowController {
    private static RemoveWindow removeWindow = new RemoveWindow();

    public static void removeInputWord(String targetWord) {
        try {
            DictionaryManagement.removeWord(targetWord);
            DictionaryManagement.removeWordHistory(targetWord);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void disposeWindow() {
        removeWindow.closeWindow();
        removeWindow = new RemoveWindow();
    }

    public static void openWindow() {
        removeWindow.displayWindow();
    }
}
