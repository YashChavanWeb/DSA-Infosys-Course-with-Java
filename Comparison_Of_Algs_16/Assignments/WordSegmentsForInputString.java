package Comparison_Of_Algs_16.Assignments;

/*
 * Given a string and a list of words, find out the number of possible word segments that can be used to form the given string using the words present in wordsList. Count the number of possible word segments with the help of 'count' static variable. Implement the logic in findWordSegments() method. 
 */

import java.util.ArrayList;
import java.util.List;

public class WordSegmentsForInputString {

    static int count = 0;

    public static void findWordSegments(List<String> wordsList, String inputString) {
        int n = inputString.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty substring is always segmentable

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordsList.contains(inputString.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (dp[n]) {
            count++;
        }
    }

    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<String>();
        wordsList.add("i");
        wordsList.add("like");
        wordsList.add("pizza");
        wordsList.add("li");
        wordsList.add("ke");
        wordsList.add("pi");
        wordsList.add("zza");

        String inputString = "ilikepizza";
        findWordSegments(wordsList, inputString);
        System.out.println("Number of segments: " + count);
    }
}