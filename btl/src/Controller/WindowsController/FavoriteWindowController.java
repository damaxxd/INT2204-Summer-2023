package Controller.WindowsController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Word;
import Model.Dictionary;


// Controller for favorite word window
public class FavoriteWindowController {
    // path to favorite word file
    private static final String FAVORITE_PATH = "btl/src/resources/data/favorites.txt";

    /**
     * Write data to favorite file.
     */
    public static void dictionaryExportToHistory() throws IOException {
        FileWriter writer = new FileWriter(FAVORITE_PATH);
        for (Word word : Dictionary.favoriteWords) {
            writer.write(String.format("%s\t%s\n", word.getWordTarget(), word.getWordExplain()));
        }
        writer.close();
    }
    
    /**
     * Load data from history file
     */
    public static void loadFavoriteFile() throws IOException {
        File file = new File(FAVORITE_PATH);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String cur_line = sc.nextLine();
            String[] split = cur_line.split("\\t");
            if (split.length == 2) {
                Word word = new Word(split[0], split[1]);
                Dictionary.historyWords.add(word);
            }
        }
        sc.close();
    }

    public static ArrayList<Word> getFavoriteWordsList() {
        return Dictionary.getFavoriteWords();
    }

    public static void addFavoriteWord() {
        
    }
}
