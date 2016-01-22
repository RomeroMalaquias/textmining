package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Romero on 14/01/2016.
 */
public class DocumentMatrix  {
    private HashMap<String,ArrayList<Integer>> matrix;
    public DocumentMatrix(ArrayList<Document> documents) {
        matrix = new HashMap<>();
        for(int i = 0; i < documents.size(); i++) {
            for (String word : documents.get(i).getWords()) {
                ArrayList<Integer> aux = new ArrayList<>();
                if (matrix.containsKey(word)){
                    aux = matrix.get(word);
                }
                aux.add(i);
                matrix.put(word, aux);
            }

        }
    }
    public HashMap<String,ArrayList<Integer>> getMatrix(){
        return matrix;
    }
}
