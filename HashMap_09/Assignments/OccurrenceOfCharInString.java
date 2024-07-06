package HashMap_09.Assignments;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, return a map containing the occurrences of the individual characters of the string. The map should be created in such a way that the keys are the individual characters and the values are the occurrences of each of the characters. Implement the logic inside findOccurrences() method.
 */

public class OccurrenceOfCharInString {

    public static Map<Character, Integer> findOccurrences(String input) {
        Map<Character, Integer> occurrenceMap = new HashMap<>();

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            // Check if character c is already in the map
            if (occurrenceMap.containsKey(c)) {
                // If yes, increment the count
                occurrenceMap.put(c, occurrenceMap.get(c) + 1);
            } else {
                // If no, add it with count 1
                occurrenceMap.put(c, 1);
            }
        }

        return occurrenceMap;
    }

    public static void main(String args[]) {
        String input = "occurrence";
        Map<Character, Integer> occurrenceMap = findOccurrences(input);

        System.out.println("Occurrences of characters\n=======================");
        for (Map.Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}
