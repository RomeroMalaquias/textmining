package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Romero on 14/01/2016.
 */
public class Document {
    private ArrayList<String> words;
    private HashMap<String,Integer> wordFrequency;
    public Document(String data) {
        words = new ArrayList<String>();
        wordFrequency = new HashMap<String, Integer>();
        data = data.replaceAll(",", "");
        data = data.replaceAll("\\.", "");
        data = data.toLowerCase();
        String[] dataSplit = data.split(" ");
        for(String word : dataSplit) {
            if (word.length() > 0) {
                if (!words.contains(word)) {
                    words.add(word);
                    wordFrequency.put(word, 1);
                } else {
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                }
            }

        }
    }
    public int getNumOfWords() {
        return words.size();
    }
    public ArrayList<String> getWords() {
        return words;
    }
    public HashMap<String, Integer> getWordFrequency() {
        return wordFrequency;
    }
}
