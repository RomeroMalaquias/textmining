import manager.FileManager;
import summarization.AggregateSimilarity;
import summarization.Frequency;
import summarization.Paradigmatic;

import java.util.ArrayList;

/**
 * Created by Romero on 14/01/2016.
 */
public class main {

    public static void main(String args[]) {

        String word1 = "Microsoft";
        String word2 = "palco";
        Paradigmatic paradigmatic = new Paradigmatic("Dataset.txt");
        System.out.println("Relation paradigmatic between " + word1 + " and " + word2 + " = " + paradigmatic.getRelation(word1, word2));
        System.out.println("\n\n\n");
        Frequency frequency = new Frequency("Dataset.txt");
        System.out.println("Frequency of " + word1 + " = " + frequency.getWordFrequency("Microsoft"));
        System.out.println("\n\n\n");
        AggregateSimilarity aggregateSimilarity = new AggregateSimilarity("Dataset.txt");
        System.out.println("Aggreate Similarity=" + FileManager.LINE_SEPARATOR + aggregateSimilarity.getAggregateSimilarity());
    }
}
