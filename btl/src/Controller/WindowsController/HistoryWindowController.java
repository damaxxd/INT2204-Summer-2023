package Controller.WindowsController;

import java.util.Stack;

import Controller.DictionaryManagement;
import Model.Dictionary;
import Model.Word;
import View.windows.HistoryWindow;

public class HistoryWindowController {
    private static HistoryWindow historyWindow = new HistoryWindow();

    public static Stack<Word> getHistoryWordsStack() {
        return Dictionary.getHistoryWords();
    }

    public static void clearHistoryWordsStack() {
        Dictionary.clearHistoryWords();
        try {
            DictionaryManagement.dictionaryExportToHistory();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Somehow JFrame dispose method don't clear all the data so we close (dispose)
     * and then create a new find Window object.
     */
    public static void disposeWindow() {
        historyWindow.closeWindow();
        historyWindow = new HistoryWindow();
    }

    public static void openWindow() {
        historyWindow.displayWindow();
    }
    
}
