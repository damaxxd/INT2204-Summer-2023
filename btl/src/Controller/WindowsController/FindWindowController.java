package Controller.WindowsController;

import Controller.DictionaryManagement;
import Model.Dictionary;
import Model.Word;

public class FindWindowController {
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
}
