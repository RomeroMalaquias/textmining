package summarization;

import data.Document;
import data.DocumentMatrix;
import data.InverseDocumentFrequency;
import manager.FileManager;

import java.util.ArrayList;
import java.util.HashMap;

public class AggregateSimilarity {
    private ArrayList<Document> documents;
    private DocumentMatrix documentMatrix;
    public AggregateSimilarity(String file) {
        String fileContent = FileManager.getInstance().readFile(file);
        documents = new ArrayList<Document>();
        for(String line : fileContent.split(FileManager.LINE_SEPARATOR)) {
            Document document = new Document(line);
            documents.add(document);
        }
        documentMatrix = new DocumentMatrix(documents);

    }
    public String getAggregateSimilarity() {
        String results = "";
        HashMap<String, Double> frequency = InverseDocumentFrequency.getInstance().getIDF(documentMatrix.getMatrix(), documents.size());
        for (Document document: documents) {
            if (document.getText().trim().length() > 0) {
                results += document.getText() + " -> ";
                results += document.calculateAggreateSimilarity(frequency) + FileManager.LINE_SEPARATOR;
            }
        }

        return results;
    }
}
