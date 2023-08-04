package Controller.WindowsController;

import Controller.DictionaryManagement;

public class AddWindowController {
    public static void addNewWord(String word_target, String word_explain) {
        try {
            DictionaryManagement.addWord(word_target, word_explain);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
