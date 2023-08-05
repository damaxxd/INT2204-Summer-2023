package Controller.WindowsController;

import Controller.DictionaryManagement;
import Model.Word;
import View.windows.FindWindow;

public class FindWindowController {
    private static FindWindow findWindow = new FindWindow();

    public static String findWord(String targetWord) {
        if (DictionaryManagement.getIndexByWord(targetWord) != -1) { // found target word
            String explainWord = DictionaryManagement.dictionaryLookup(targetWord);
            DictionaryManagement.addWordHistory(new Word(targetWord, explainWord));
            try {
                DictionaryManagement.dictionaryExportToHistory();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            return explainWord;
        }
        return "";
    }

    /**
     * Somehow dispose method don't clear all the data so we close (dispose)
     * and then create a new find Window object.
     */
    public static void disposeWindow() {
        findWindow.closeWindow();
        findWindow = new FindWindow();
    }

    public static void openWindow() {
        findWindow.displayWindow();
    }
}
