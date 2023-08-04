package Controller.WindowsController;

import Controller.DictionaryManagement;
import Model.Dictionary;

public class RemoveWindowController {
    public static void removeInputWord(String targetWord) {
        try {
            DictionaryManagement.removeWord(targetWord);
            DictionaryManagement.removeWordHistory(targetWord);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
