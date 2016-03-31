/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Hunter
 */
public class RandomClassifier extends Experimenter{
    private Random random;
    
    public RandomClassifier() {
        random = new Random();
    }
    
    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }


    public Map<SocialMediaEntry, Boolean> classifyEntries(Set<SocialMediaEntry> trainingSet,
                                                          Set<SocialMediaEntry> testSet) {

        System.out.println("Running Randomclassifier...");

        // In a real use case, build a machine learning model from the training set,
        // then use it to classify the entries in the test set.


        Map<SocialMediaEntry, Boolean> results = new HashMap<>();

        // Right now this is putting a "true" for everything
        // TODO: This method will need to be changes / replaced.
        for (SocialMediaEntry entry : testSet) {
            results.put(entry, getRandomBoolean());
        }

        return results;
}
