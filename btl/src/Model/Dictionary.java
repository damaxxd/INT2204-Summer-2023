package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Dictionary {
    public static ArrayList<Word> dict = new ArrayList<Word>();

    // store history of user's word finding
    public static ArrayList<Word> historyWords = new ArrayList<Word>();

    // store user's favorite word
    public static ArrayList<Word> favoriteWords = new ArrayList<Word>();

    public static ArrayList<Word> getHistoryWords() {
        return historyWords;
    }

    public static ArrayList<Word> getFavoriteWords() {
        return favoriteWords;
    }

    public static void clearAllHistoryWords() {
        historyWords.clear();
    }

    public static void clearAllFavoriteWords() {
        favoriteWords.clear();
    }
}
