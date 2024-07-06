package Algs_Techniques_15.Greedy_Approach.Exercises;

import java.util.*;

public class NoOfActivitiesInStartAndEnd {

    public static int findMaxActivities(int[] start, int[] finish) {
        if (start == null || finish == null || start.length == 0 || finish.length == 0) {
            return 0;
        }

        int n = start.length;
        // Create a list of activities based on finish times
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }

        // Sort activities based on finish times (ascending order)
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return Integer.compare(a1.finish, a2.finish);
            }
        });

        // Initialize variables
        int maxActivities = 0;
        int lastFinishTime = Integer.MIN_VALUE;

        // Iterate through sorted activities and count max activities
        for (Activity activity : activities) {
            if (activity.start >= lastFinishTime) {
                maxActivities++;
                lastFinishTime = activity.finish;
            }
        }

        return maxActivities;
    }

    public static void main(String[] args) {
        int[] start1 = { 1, 3, 0, 5, 8, 5 };
        int[] finish1 = { 2, 4, 6, 7, 9, 9 };

        int[] start2 = { 1, 3, 0, 5, 9, 8 };
        int[] finish2 = { 3, 5, 8, 10, 12, 13 };

        System.out
                .println("Maximum activities that can be performed (sample 1): " + findMaxActivities(start1, finish1)); // Output:
                                                                                                                        // 4
        System.out
                .println("Maximum activities that can be performed (sample 2): " + findMaxActivities(start2, finish2)); // Output:
                                                                                                                        // 4
    }
}

class Activity {
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}