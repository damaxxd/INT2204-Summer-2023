package Controller.WindowsController;

import java.io.IOException;

import Controller.DictionaryManagement;

public class EditWindowController {
    public static String editTargetWord(String targetWord, String explainWord) {
        try {
            return DictionaryManagement.editWord(targetWord, explainWord);
        } catch (Exception e) {
            return "Failed to edit word";
        }
    }
}
