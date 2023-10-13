/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Validation;
import java.util.HashMap;
import model.Dictionary;

/**
 *
 * @author GoldCandy
 */
public class DictionaryDao {

    private static DictionaryDao instance = null;
    private Validation valid = new Validation();

    public static DictionaryDao Instance() {
        if (instance == null) {
            synchronized (DictionaryDao.class) {
                if (instance == null) {
                    instance = new DictionaryDao();
                }
            }
        }
        return instance;
    }

    public boolean addWord(HashMap<String, Dictionary> dictionary, Dictionary new_Word) {
        String enWord = valid.inputString("Enter English");
        if (valid.checkExistWord(dictionary, enWord)) {
            new_Word.setEnWord(enWord);
            return false;
        }
        new_Word.setEnWord(enWord);
        new_Word.setVnWord(valid.inputString("Enter Vietnamese"));
        dictionary.put(enWord, new_Word);
        return true;
    }

    public void updateWordd(HashMap<String, Dictionary> dictionary, String enWord) {
        dictionary.get(enWord).setVnWord(valid.inputString("Enter Vietnamese"));
    }

    public boolean deleteWord(HashMap<String, Dictionary> dictionary) {
        String deleteWord = valid.inputString("Enter English");
        if (!valid.checkExistWord(dictionary, deleteWord)) {
            return false;
        }
        dictionary.remove(deleteWord);
        return true;
    }

    public boolean translateWord(HashMap<String, Dictionary> dictionary) {
        String word = valid.inputString("Enter English");
        if (!valid.checkExistWord(dictionary, word)) {
            return false;
        }
        System.out.println("Vietnamese: " + dictionary.get(word).getVnWord());
        return true;
    }
}
