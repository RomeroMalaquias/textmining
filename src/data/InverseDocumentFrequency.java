package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Romero on 14/01/2016.
 */
public class InverseDocumentFrequency {
    private static InverseDocumentFrequency instance;
    private InverseDocumentFrequency(){}
    public static InverseDocumentFrequency getInstance() {
        if (instance == null) {
            instance = new InverseDocumentFrequency();
        }
        return instance;
    }
    public HashMap<String, Double> getIDF(HashMap<String,ArrayList<Integer>> matrix, int nDocuments){
        HashMap<String, Double> result = new HashMap<>();
        for (String key : matrix.keySet()) {
            float aux = nDocuments/matrix.get(key).size();
            result.put(key, (Math.log10(aux)));
        }
        return result;
    }
    public HashMap<String, Double> getIDF2(HashMap<String,ArrayList<String>> matrix, int nDocuments){
        HashMap<String, Double> result = new HashMap<>();
        for (String key : matrix.keySet()) {
            float aux = nDocuments/matrix.get(key).size();
            result.put(key, (Math.log10(aux)));
        }
        return result;
    }
}
