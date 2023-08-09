package Controller.WindowsController;

import java.io.IOException;
import java.sql.ResultSet;

import services.Connector;
import Controller.DictionaryManagement;
import Model.Dictionary;
import View.windows.HistoryWindow;
import View.windows.RemoveWindow;

public class RemoveWindowController {
    private static RemoveWindow removeWindow = new RemoveWindow();

    public static void removeInputWord(String targetWord) {

        // Remove in database
        Connector.createConnection();
        String queryStatement = "DELETE FROM tbl_edict WHERE word = '" + targetWord + "'";
        try {
            Connector.executeUpdateStatement(queryStatement);
        } catch (Exception e) { // queryResult is null, word not found or invalid query statement
            System.out.println(e.getMessage());
        }

        Connector.closeAllConnection();

        // Remove in program backend
        try {
            removeWord(targetWord);
            removeWordInHistory(targetWord);
            removeWordInFavorite(targetWord);
            DictionaryManagement.dictionaryWriteToAllFiles();
            HistoryWindowController.disposeWindow();
            FavoriteWindowController.disposeWindow();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
    * Remove word from dictionary with parameter.
    */
    public static void removeWord(String targetWord) throws IOException {
        int index = DictionaryManagement.getIndexByWord(targetWord);
        if (index != -1) {
            Dictionary.dict.remove(index);
            DictionaryManagement.wordTrie.removeInTrie(targetWord);
        }
    }

    /**
     * Remove word in history.
     */
    public static void removeWordInHistory(String targetWord) {
        for (int i = 0; i < Dictionary.historyWords.size(); i++) {
            if (Dictionary.historyWords.get(i).getWordTarget().equals(targetWord)) {
                Dictionary.historyWords.remove(i);
                break;
            }
        }
    }

    /**
     * Remove word in favorite.
     */
    public static void removeWordInFavorite(String targetWord) {
        for (int i = 0; i < Dictionary.favoriteWords.size(); i++) {
            if (Dictionary.favoriteWords.get(i).getWordTarget().equals(targetWord)) {
                Dictionary.favoriteWords.remove(i);
                break;
            }
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
