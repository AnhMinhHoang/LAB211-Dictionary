/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.HashMap;
import java.util.Scanner;
import model.Dictionary;

/**
 *
 * @author GoldCandy
 */
public class Validation {

    public String inputString(String title) {
        String s = "";
        while (s.isBlank() || s.isEmpty()) {
            System.out.print(title + ": ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }
        return s;
    }

    public String inputStringMatch(String title, String regex) {
        String s = "";
        while (!s.matches(regex) || !s.toLowerCase().matches(regex)) {
            System.out.print(title + ": ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }
        return s;
    }

    public boolean checkExistWord(HashMap<String, Dictionary> dictionary, String word) {
        return dictionary.get(word) != null;
    }
}
