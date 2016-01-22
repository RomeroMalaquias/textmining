package summarization;


import data.Document;
import data.DocumentMatrix;
import data.InverseDocumentFrequency;
import manager.FileManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Frequency {
    private ArrayList<Document> documents;
    private DocumentMatrix documentMatrix;
    private HashMap<String, Double> frequency;

    public Frequency(String file) {
        String fileContent = FileManager.getInstance().readFile(file);
        documents = new ArrayList<Document>();
        for(String line : fileContent.split(FileManager.LINE_SEPARATOR)) {
            Document document = new Document(line);
            documents.add(document);
        }
    }
    public Double getWordFrequency(String word) {
        word = word.toLowerCase();
        double result = 0;
        for (Document document : documents) {
            if(document.getWordFrequency().containsKey(word)) {
                result += document.getWordFrequency().get(word);
            }
        }
        result = result / documents.size();
        return result;
    }
}
