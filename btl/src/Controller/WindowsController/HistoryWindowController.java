package Controller.WindowsController;

import java.util.ArrayList;

import Controller.DictionaryManagement;
import Model.Dictionary;
import Model.Word;
import View.windows.HistoryWindow;

public class HistoryWindowController {
    private static HistoryWindow historyWindow = new HistoryWindow();

    public static ArrayList<Word> getHistoryWordsList() {
        return Dictionary.getHistoryWords();
    }

    public static void clearHistoryWordsList() {
        Dictionary.clearAllHistoryWords();
        try {
            DictionaryManagement.dictionaryWriteToHistory();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Add word to history.
     */
    public static void addWordHistory(Word word) {
        for (Word _word : Dictionary.historyWords) {
            if (_word.getWordTarget().equals(word.getWordTarget())) {
                return;
            }
        }
        Dictionary.historyWords.add(word);
    }

    /**
     * Somehow JFrame dispose method don't clear all the data so we close (dispose)
     * and then create a new findWindow object.
     */
    public static void disposeWindow() {
        historyWindow.closeWindow();
        historyWindow = new HistoryWindow();
    }

    public static void openWindow() {
        historyWindow.displayWindow();
    }
    
}
