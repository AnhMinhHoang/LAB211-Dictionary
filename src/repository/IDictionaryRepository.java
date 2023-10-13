/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.HashMap;
import model.Dictionary;

/**
 *
 * @author GoldCandy
 */
public interface IDictionaryRepository {

    void addWord(HashMap<String, Dictionary> dictionary);

    void deleteWord(HashMap<String, Dictionary> dictionary);

    void translateWord(HashMap<String, Dictionary> dictionary);

}
