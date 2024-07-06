package HashMap_09.Assignments;

import java.util.HashMap;
import java.util.Map;

/*
 * Merge two hash maps in such a way that no data is lost. If the maps contain duplicate keys with different values, then while merging add the value of the duplicate key with a new key by concatenating "new" with the key. Implement the logic inside mergeMaps() method and return a HashMap containing the entries of both the HashMaps passed to the method.
 */

public class MergeHashMaps {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapOne, Map<String, Integer> mapTwo) {
        Map<String, Integer> mergedMap = new HashMap<>();

        // Copy entries from mapOne to mergedMap
        for (Map.Entry<String, Integer> entry : mapOne.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }

        // Merge entries from mapTwo into mergedMap
        for (Map.Entry<String, Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (mergedMap.containsKey(key)) {
                // Key already exists in mergedMap
                // Concatenate "new" with the key and add the value
                mergedMap.put("new" + key, value);
            } else {
                // Key does not exist in mergedMap, add it directly
                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> mapOne = new HashMap<>();
        mapOne.put("Kelly", 10);
        mapOne.put("Micheal", 20);
        mapOne.put("Ryan", 30);

        Map<String, Integer> mapTwo = new HashMap<>();
        mapTwo.put("Jim", 15);
        mapTwo.put("Andy", 45);

        Map<String, Integer> mergedMap = mergeMaps(mapOne, mapTwo);

        System.out.println("Merged Map\n===========");
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}
