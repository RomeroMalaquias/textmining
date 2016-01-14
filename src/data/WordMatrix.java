package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Romero on 14/01/2016.
 */
public class WordMatrix {
    private HashMap<String,ArrayList<String>> matrix;
    public WordMatrix(ArrayList<Document> documents) {
        matrix = new HashMap<String, ArrayList<String>>();

        for(int i = 0; i < documents.size(); i++) {
            for (String word : documents.get(i).getWords()) {
                ArrayList<String> aux = new ArrayList<String>();
                if (matrix.containsKey(word)){
                    aux = matrix.get(word);
                }
                for (String newWord : documents.get(i).getWords()) {
                    if(!aux.contains(newWord) && !newWord.equals(word)) {
                        aux.add(newWord);
                    }
                }
                matrix.put(word, aux);
            }

        }
    }
    public HashMap<String,ArrayList<String>> getMatrix(){
        return matrix;
    }
}