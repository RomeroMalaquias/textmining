package data;

import manager.StopWordsManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Romero on 14/01/2016.
 */
public class Document {
    private ArrayList<String> words;
    private HashMap<String,Integer> wordFrequency;
    private String text;
    public Document(String data) {
        text = data;
        words = new ArrayList<String>();
        wordFrequency = new HashMap<String, Integer>();
        data = StopWordsManager.getInstance().removeStopWords(data);
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
    public double calculateAggreateSimilarity( HashMap<String, Double> frequency) {
        double results = 0;
        for (String word : words) {
            if (frequency.containsKey(word)) {
                results += frequency.get(word);
            }
        }
        if (words.size() > 0) {
            results /= words.size();
        }
        return results;
    }
    public String getText() {
        return text;
    }
}
