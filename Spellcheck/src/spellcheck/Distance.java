/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellcheck;
import java.util.*;

/**
 *
 * @author NISHANT
 */
class Distance 
{
    private HashMap<String, Integer> dict = new HashMap<String, Integer>();
    
    public Distance( HashMap<String, Integer> dict )
    {
        this.dict = dict;
    }

    public ArrayList<String> editDistance(String word) 
    {
        ArrayList<String> probWords = new ArrayList<String>();
        //delete a letter
        for (int i = 0; i < word.length(); i++) 
        {
            String temp = word.substring(0,i) + word.substring(i+1);
            probWords.add(temp);
        }
        
        //transposing a letter with consecutive letter
        for (int i = 0; i <= word.length()-2; i++) 
        {
            String temp = word.substring(0, i) + word.charAt(i+1) + word.charAt(i) + word.substring(i + 2);
            probWords.add(temp);
        }
        
        //replace of a charcter with another character
        for (int i = 0; i < word.length(); ++i) {
            for (char ch = 97; ch <= 122; ch++) {
                String temp = word.substring(0, i) + String.valueOf(ch) + word.substring(i + 1);
                probWords.add(temp);
            }
        }
        //insertion of a character
        for (int i = 0; i <= word.length(); ++i) {
            for (char ch = 97; ch <= 122; ch++)
            {
                String temp = word.substring(0, i) + String.valueOf(ch) + word.substring(i);
                probWords.add(temp);
            }
        }
        return probWords;
    }

    public String correct(String word) {
        if (dict.containsKey(word)) {
            return word;
        }
        ArrayList<String> list = editDistance(word);
        HashMap<Integer, String> candidates = new HashMap<Integer, String>();
        for (String s : list) {
            if (dict.containsKey(s)) {
                candidates.put(dict.get(s), s);
            }
        }
        if (candidates.size() > 0) {
            return candidates.get(Collections.max(candidates.keySet()));
        }
        //return "";
        for (String s : list) {
            for (String w : editDistance(s)) {
                if (dict.containsKey(w)) {
                    candidates.put(dict.get(w), w);
                }
            }
        }
        if (candidates.size() > 0)
            return candidates.get(Collections.max(candidates.keySet()));
        else
            return word;
    }

}
