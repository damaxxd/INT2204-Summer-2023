package Controller.WindowsController;

import java.io.IOException;
import java.sql.ResultSet;

import Controller.DictionaryManagement;
import View.windows.EditWindow;
import services.Connector;
import Model.Dictionary;

public class EditWindowController {
    private static EditWindow editWindow = new EditWindow();

    public static String editTargetWord(String targetWord, String explainWord) {
        // Edit in database
        Connector.createConnection();
        Connector.executeUpdateStatement("SET SQL_SAFE_UPDATES = 0;"); // Word maybe duplicate so we set this
        String queryStatement = "UPDATE tbl_edict SET explainWord ='"+ explainWord +"' WHERE word='" + targetWord + "';";
        try {
            Connector.executeUpdateStatement(queryStatement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Connector.executeUpdateStatement("SET SQL_SAFE_UPDATES = 1;");
        Connector.closeAllConnection();
        
        
        // Edit in app backend
        try {
            return editWord(targetWord, explainWord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Failed to edit word";
        }
    }

    /**
     * Edit word in dictionary with parameter.
     */
    public static String editWord(String targetWord, String explainWord) throws IOException {
        int index = DictionaryManagement.getIndexByWord(targetWord);
        if (index != -1) {
            Dictionary.dict.get(index).setWordExplain(explainWord);
            DictionaryManagement.wordTrie.editInTrie(targetWord, explainWord);
            DictionaryManagement.dictionaryWriteToAllFiles();
            return "Succesfully edit word";
        } else {
            return "Failed to edit word";
        }
    }

    /**
     * Somehow dispose method don't clear all the data so we close (dispose)
     * and then create a new find Window object.
     */
    public static void disposeWindow() {
        editWindow.closeWindow();
        editWindow = new EditWindow();
    }

    public static void openWindow() {
        editWindow.displayWindow();
    }
}
