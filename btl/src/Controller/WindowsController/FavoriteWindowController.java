package Controller.WindowsController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.DictionaryManagement;
import Model.Word;
import View.windows.FavoriteWindow;
import View.windows.FindWindow;
import Model.Dictionary;


// Controller for favorite word window
public class FavoriteWindowController {
    private static FavoriteWindow favoriteWindow = new FavoriteWindow();

    public static ArrayList<Word> getFavoriteWordsList() {
        return Dictionary.getFavoriteWords();
    }

    public static void clearFavoriteWordsList() {
        Dictionary.clearAllFavoriteWords();
        try {
            DictionaryManagement.dictionaryWriteToFavorite();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Somehow dispose method don't clear all the data so we close (dispose)
     * and then create a new favoriteWindow object.
     */
    public static void disposeWindow() {
        favoriteWindow.closeWindow();
        favoriteWindow = new FavoriteWindow();
    }

    public static void openWindow() {
        favoriteWindow.displayWindow();
    }
}
