package summarization;

import data.Document;
import data.DocumentMatrix;
import data.InverseDocumentFrequency;
import manager.FileManager;

import java.util.ArrayList;
import java.util.HashMap;


public class Paradigmatic {
    private ArrayList<Document> documents;
    private DocumentMatrix documentMatrix;
    public Paradigmatic(String file) {
        String fileContent = FileManager.getInstance().readFile(file);
        documents = new ArrayList<Document>();
        for(String line : fileContent.split(FileManager.LINE_SEPARATOR)) {
            Document document = new Document(line);
            documents.add(document);
        }
        documentMatrix = new DocumentMatrix(documents);

    }
    public double getRelation(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        ArrayList<String> left1 = getWords(word1, true);
        ArrayList<String> left2 = getWords(word2, true);
        ArrayList<String> right1 = getWords(word1, false);
        ArrayList<String> right2 = getWords(word2, false);
        ArrayList<String> commonLeft = commonWords(left1, left2);
        ArrayList<String> commonRight = commonWords(right1, right2);
        HashMap<String, Double> frequency = InverseDocumentFrequency.getInstance().getIDF(documentMatrix.getMatrix(), documents.size());
        double result = 0;
        for (String word : commonLeft) {
            result += frequency.get(word);
        }
        for (String word : commonRight) {
            result += frequency.get(word);
        }
        if ((commonLeft.size() + commonRight.size() ) > 0) {
            result/= (commonLeft.size() + commonRight.size());
        }

        return result;
    }

    public ArrayList<String> getWords(String word, boolean left) {
        ArrayList<String> result = new ArrayList<>();
        if (documentMatrix.getMatrix().containsKey(word)) {
            for (int index : documentMatrix.getMatrix().get(word)) {
                boolean compare = left;
                for (String wordToCompare : documents.get(index).getWords()) {
                    if (wordToCompare.equals(word)) {
                        if (left) {
                            compare = false;
                        } else {
                            compare = true;
                        }
                    }
                    if (compare && !result.contains(wordToCompare) && !wordToCompare.equals(word)) {
                        result.add(wordToCompare);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<String> commonWords(ArrayList<String> words1, ArrayList<String> words2) {
        ArrayList<String> result = new ArrayList<>();
        for(String word: words1) {
            if(words2.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }
}
