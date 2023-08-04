package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;
    ArrayList<String> words;
    TrieNode prefix_root;
    String cur_prefix;

    public Trie() {
        root = new TrieNode();
        words = new ArrayList<String>();
    }

    /**
     * Insert a word to trie.
     */
    public void insertWordToTrie(Word word) {
        TrieNode current = root;
        for (int i = 0; i < word.getWordTarget().length(); i++) {
            char ch = word.getWordTarget().charAt(i);
            TrieNode node = current.child.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.child.put(ch, node);
            }
            current = node;
        }
        current.is_complete_word = true;
        current.value = word.getWordExplain();
    }

    /**
     * find target word in Trie.
     */
    public boolean searchInTrie(String search_target) {
        TrieNode current = root;
        for (int i = 0; i < search_target.length(); i++) {
            char ch = search_target.charAt(i);
            TrieNode node = current.child.get(ch);

            if (node == null) {
                return false;
            }
            current = node;
        }
        return !current.child.isEmpty() || current.is_complete_word;
    }

    /**
     * remove target word in Trie.
     */
    public void removeInTrie(String search_target) {
        TrieNode current = root;
        for (int i = 0; i < search_target.length(); i++) {
            char ch = search_target.charAt(i);
            TrieNode node = current.child.get(ch);

            if (node == null) {
                return;
            }
            current = node;
        }
        current = null;
    }

    /**
     * edit target word in Trie.
     */
    public void editInTrie(String targetWord, String explainWord) {
        TrieNode current = root;
        for (int i = 0; i < targetWord.length(); i++) {
            char ch = targetWord.charAt(i);
            TrieNode node = current.child.get(ch);

            if (node == null) {
                return;
            }
            current = node;
        }
        current.setValue(explainWord);
    }

    /**
     * Look for explanation in trie.
     */
    public String lookup(String search_target) {
        String result = "";
        TrieNode current = root;
        for (int i = 0; i < search_target.length(); i++) {
            char ch = search_target.charAt(i);
            current = current.child.get(ch);
            if (current == null) {
                return "";
            }
        }
        if (current.is_complete_word) {
            result = current.value;
        }
        return result;
    }
}