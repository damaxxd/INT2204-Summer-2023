package Controller;

import java.util.Scanner;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionaryManagement {
    private final static String HISTORY_PATH = "btl/src/resources/data/history.txt";
    private final static String DATA_PATH = "btl/src/resources/data/dictionaries.txt";

    private static Trie wordTrie = new Trie();

    public DictionaryManagement() {
        
    }

    /**
     * Add word to history.
     */
    public static void addWordHistory(Word word) {
        Dictionary.historyWords.push(word);
    }

    /**
     * Remove word in history.
     */
    public static void removeWordHistory(String targetWord) {
        for (int i = 0; i < Dictionary.historyWords.size(); i++) {
            if (Dictionary.historyWords.get(i).getWordTarget() == targetWord) {
                Dictionary.historyWords.remove(i);
                break;
            }
        }
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
    public static void insertFromFile() throws IOException {
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
     * Add word to dictionary.
     */
    public static void addWord(String word_target, String word_explain) throws IOException {
        Word word = new Word(word_target, word_explain);
        Dictionary.dict.add(word);
        wordTrie.insertWordToTrie(word);
        dictionaryExportToFile();
    }

    /**
    * Remove word from dictionary with parameter.
    */
    public static void removeWord(String targetWord) throws IOException {
        int index = getIndexByWord(targetWord);
        if (index != -1) {
            Dictionary.dict.remove(index);
            wordTrie.removeInTrie(targetWord);
        }
        dictionaryExportToFile();
    }

    /**
     * Edit word in dictionary with parameter.
     */
    public static String editWord(String targetWord, String explainWord) throws IOException {
        int index = getIndexByWord(targetWord);
        if (index != -1) {
            Dictionary.dict.get(index).setWordExplain(explainWord);
            wordTrie.editInTrie(targetWord, explainWord);
            dictionaryExportToFile();
            return "Succesfully edit word";
        } else {
            return "Failed to edit word";
        }
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
    public static void dictionaryExportToFile() throws IOException {
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
    public static void dictionaryExportToHistory() throws IOException {
        FileWriter writer = new FileWriter(HISTORY_PATH);
        for (Word word : Dictionary.historyWords) {
            writer.write(String.format("%s\t%s\n", word.getWordTarget(), word.getWordExplain()));
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
}