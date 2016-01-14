import data.Document;
import data.DocumentMatrix;
import data.InverseDocumentFrequency;
import data.WordMatrix;
import manager.FileManager;

import java.util.ArrayList;

/**
 * Created by Romero on 14/01/2016.
 */
public class main {

    public static void main(String args[]) {

        String fileContent = FileManager.getInstance().readFile("Dataset.txt");
        ArrayList<Document> documents = new ArrayList<Document>();
        for(String line : fileContent.split(FileManager.LINE_SEPARATOR)) {
            Document document = new Document(line);
            documents.add(document);
        }
        DocumentMatrix documentMatrix = new DocumentMatrix(documents);
        System.out.println(InverseDocumentFrequency.getInstance().getIDF(documentMatrix.getMatrix(), documents.size()));
        WordMatrix wordMatrix = new WordMatrix(documents);
        System.out.println(InverseDocumentFrequency.getInstance().getIDF2(wordMatrix.getMatrix(), documents.size()));
    }
}
