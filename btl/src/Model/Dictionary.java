package Model;

import java.util.ArrayList;
import java.util.Stack;

public class Dictionary {
    public static ArrayList<Word> dict = new ArrayList<Word>();

    // store history of user's word finding
    public static Stack<Word> historyWords = new Stack<Word>();

    // store user's favorite word
    public static ArrayList<Word> favoriteWords = new ArrayList<Word>();

    public static Stack<Word> getHistoryWords() {
        return historyWords;
    }

    public static ArrayList<Word> getFavoriteWords() {
        return favoriteWords;
    }

    public static void clearHistoryWords() {
        historyWords = new Stack<Word>();
    }
}
