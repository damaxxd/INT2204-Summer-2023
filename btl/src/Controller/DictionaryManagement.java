package Controller;

import java.util.Scanner;

import Model.*;
import services.Connector;

import java.sql.ResultSet;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryManagement {
    private static final String DATA_PATH = "btl/src/resources/data/dictionaries.txt";
    private static final String HISTORY_PATH = "btl/src/resources/data/history.txt";
    private static final String FAVORITE_PATH = "btl/src/resources/data/favorites.txt";

    public static Trie wordTrie = new Trie();

    public DictionaryManagement() {
        
    }

    /**
     * Load data from history file
     */
    public static void loadHistoryFile() throws IOException {
        File file = new File(HISTORY_PATH);
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

    /**
     * Load data from dictionary data file.
     */
    public static void loadDataFile() throws IOException {
        File file = new File(DATA_PATH);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String cur_line = sc.nextLine();
            String[] split = cur_line.split("\\t");
            if (split.length == 2) {
                Word word = new Word(split[0], split[1]);
                Dictionary.dict.add(word);
                wordTrie.insertWordToTrie(word);
            }
        }
        sc.close();
    }

    /**
     * Return index of word.
     *
     * @param word_target string
     * @return index
     */
    public static int getIndexByWord(String word_target) {
        int index = -1;
        int length = Dictionary.dict.size();
        for (int i = 0; i < length; i++) {
            if (word_target.equals(Dictionary.dict.get(i).getWordTarget())) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Look for word with parameter.
     */
    public static String dictionaryLookup(String targetWord) {
        String result = wordTrie.lookup(targetWord); // return "" if word not found
        return result;
    }

    /**
     * Show words begin with string key.
     */
    public static ArrayList<String> dictionarySearcher(String key) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < Dictionary.dict.size(); i++) {
            if (Dictionary.dict.get(i).getWordTarget().indexOf(key) == 0) {
                result.add(Dictionary.dict.get(i).getWordTarget());
            }
        }
        return result;
    }

    /**
     * Export data to file.
     */
    public static void dictionaryWriteToFile() throws IOException {
        FileWriter writer = new FileWriter(DATA_PATH);
        for (Word word : Dictionary.dict) {
            writer.write(String.format("%s\t%s\n", word.getWordTarget(), word.getWordExplain()));
        }
        writer.close();
        // System.out.println(Dictionary.dict);
    }

    /**
     * Write data to history file.
     */
    public static void dictionaryWriteToHistory() throws IOException {
        FileWriter writer = new FileWriter(HISTORY_PATH);
        HashSet<String> seenHistory = new HashSet<String>(); // prevent writing into file twice
        for (int i = Dictionary.historyWords.size() - 1; i >= 0; i--) {
            Word word = Dictionary.historyWords.get(i);
            if (!seenHistory.contains(word.getWordTarget())) {
                writer.write(String.format("%s\t%s\n", word.getWordTarget(), word.getWordExplain()));
                seenHistory.add(word.getWordTarget());
            }
            
        }
        writer.close();
    }
    
    /**
     * Display dictionary.
     */
    public static void showAllWords() {
        System.out.println("English ---- Vietnamese");
        for (Word word : Dictionary.dict) {
            System.out.format("%s\t%s \n", word.getWordTarget(), word.getWordExplain());
        }
    }

    /**
     * Write data to favorite file.
     */
    public static void dictionaryWriteToFavorite() throws IOException {
        FileWriter writer = new FileWriter(FAVORITE_PATH);
        HashSet<String> seenFavorite = new HashSet<>(); // prevent writing into file twice
        for (int i = Dictionary.favoriteWords.size() - 1; i >= 0; i--) {
            Word word = Dictionary.favoriteWords.get(i);
            if (!seenFavorite.contains(word.getWordTarget())) {
                writer.write(String.format("%s\t%s\n", word.getWordTarget(), word.getWordExplain()));
                seenFavorite.add(word.getWordTarget());
            }
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
                Dictionary.favoriteWords.add(word);
            }
        }
        sc.close();
    }

    
    public static void loadFromDatabase() {
        Connector.createConnection();
        String queryStatement = "SELECT word, explainWord FROM tbl_edict";
        try {
            ResultSet queryResult = Connector.executeQueryStatement(queryStatement);
            while (queryResult.next()) {
                Word word = new Word(queryResult.getString(1), queryResult.getString(2));
                Dictionary.dict.add(word);
                wordTrie.insertWordToTrie(word);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Connector.closeAllConnection();
    }

    /**
     * Load all files
     */
    public static void dictionaryLoadAllFiles() {
        try {
            DictionaryManagement.loadFromDatabase();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to load from database");
        }
        try {
            DictionaryManagement.loadHistoryFile();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to load history file");
        }
        try {
            DictionaryManagement.loadFavoriteFile();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to load favorite file");
        }
    }

    /**
     * Write to files
     */
    public static void dictionaryWriteToAllFiles() {
        try {
            DictionaryManagement.dictionaryWriteToFile();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to write data file");
        }
        try {
            DictionaryManagement.dictionaryWriteToHistory();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to load history file");
        }
        try {
            DictionaryManagement.dictionaryWriteToFavorite();
        } catch (Exception e) {
            System.out.println(e.getStackTrace() + "  Failed to load favorite file");
        }
    }
}