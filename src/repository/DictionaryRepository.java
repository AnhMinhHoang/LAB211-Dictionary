/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.Validation;
import content.Prompt;
import data_access.DictionaryDao;
import java.util.HashMap;
import model.Dictionary;

/**
 *
 * @author GoldCandy
 */
public class DictionaryRepository implements IDictionaryRepository {

    private Validation valid = new Validation();

    @Override
    public void addWord(HashMap<String, Dictionary> dictionary) {
        String choice = "Y";
        while (choice.equals("Y")) {
            Dictionary new_Word = new Dictionary();
            if (!DictionaryDao.Instance().addWord(dictionary, new_Word)) {
                System.out.println(Prompt.promptExist);
                DictionaryDao.Instance().updateWordd(dictionary, dictionary.get(new_Word.getEnWord()).getEnWord());
            } else {
                System.out.println(Prompt.promptSuccess);
            }
            choice = valid.inputStringMatch("Continue adding? (Y/N)", "[YNyn]");
        }
    }

    @Override
    public void deleteWord(HashMap<String, Dictionary> dictionary) {
        if (dictionary.isEmpty()) {
            System.out.println(Prompt.promptEmpty);
            return;
        }
        if (!DictionaryDao.Instance().deleteWord(dictionary)) {
            System.out.println(Prompt.promptNotExist);
            return;
        }
        System.out.println(Prompt.promptSuccess);
    }

    @Override
    public void translateWord(HashMap<String, Dictionary> dictionary) {
        if (dictionary.isEmpty()) {
            System.out.println(Prompt.promptEmpty);
            return;
        }
        if (!DictionaryDao.Instance().translateWord(dictionary)) {
            System.out.println(Prompt.promptNotExist);
            return;
        }
        System.out.println(Prompt.promptSuccess);
    }
}
