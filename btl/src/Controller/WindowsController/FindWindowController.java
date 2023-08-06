package Controller.WindowsController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.DictionaryManagement;
import Model.Dictionary;
import Model.Word;
import View.windows.FindWindow;

public class FindWindowController {
    private static FindWindow findWindow = new FindWindow();

    public static String findWord(String targetWord) {
        if (DictionaryManagement.getIndexByWord(targetWord) != -1) { // found target word
            String explainWord = DictionaryManagement.wordTrie.lookup(targetWord);
            HistoryWindowController.addWordHistory(new Word(targetWord, explainWord));
            try {
                DictionaryManagement.dictionaryWriteToHistory();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            return explainWord;
        }
        return "";
    }

    public static void addToFavoriteList(Word word) {
        try {
            addFavoriteWord(word);
            DictionaryManagement.dictionaryWriteToFavorite();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public static void addFavoriteWord(Word word) {
        for (Word _word : Dictionary.favoriteWords) {
            if (_word.getWordTarget().equals(word.getWordTarget())) {
                return;
            }
        }
        Dictionary.favoriteWords.add(word);
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
