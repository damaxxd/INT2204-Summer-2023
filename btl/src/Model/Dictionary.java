package Model;

import java.util.ArrayList;
import java.util.Stack;

public class Dictionary {
    public static ArrayList<Word> dict = new ArrayList<Word>();

    // store history of user's word finding
    public static Stack<Word> historyWords = new Stack<Word>();

    public static Stack<Word> gethistoryWords() {
        return historyWords;
    }

    public static void clearHistoryWords() {
        historyWords = new Stack<Word>();
    }
}
