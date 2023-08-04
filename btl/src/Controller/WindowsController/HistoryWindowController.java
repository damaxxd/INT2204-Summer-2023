package Controller.WindowsController;

import java.util.Stack;

import Controller.DictionaryManagement;
import Model.Dictionary;
import Model.Word;
import View.buttons.HistoryButton;

public class HistoryWindowController {
    public static Stack<Word> getHistoryWordsStack() {
        return Dictionary.gethistoryWords();
    }

    public static void clearHistoryWordsStack() {
        Dictionary.clearHistoryWords();
        try {
            DictionaryManagement.dictionaryExportToHistory();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
