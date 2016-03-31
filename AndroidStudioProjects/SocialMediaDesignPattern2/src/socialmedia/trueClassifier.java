package socialmedia;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hunter on 3/30/2016.
 */
public class trueClassifier extends Experimenter {

    public Map<SocialMediaEntry, Boolean> classifyEntries(Set<SocialMediaEntry> trainingSet,
                                                          Set<SocialMediaEntry> testSet) {

        System.out.println("Running Trueclassifier...");

        // In a real use case, build a machine learning model from the training set,
        // then use it to classify the entries in the test set.


        Map<SocialMediaEntry, Boolean> results = new HashMap<>();

        // Right now this is putting a "true" for everything
        // TODO: This method will need to be changes / replaced.
        for (SocialMediaEntry entry : testSet) {
            results.put(entry, true);
        }

        return results;
    }
}
