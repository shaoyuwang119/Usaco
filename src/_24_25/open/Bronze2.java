package _24_25.open;

import java.io.*;
import java.util.*;

public class Bronze2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        for (int c=0; c<cases; c++) {
            int cows = scan.nextInt();
            int photoCows = 0;
            scan.nextLine();
            HashMap<Integer, Integer> heights = new HashMap<>();
            int largest = 0;

            for (int i=0; i<cows; i++) {
                int height = scan.nextInt();
                if (!heights.containsKey(height)) {
                    heights.put(height, 0);
                }
                heights.put(height, heights.get(height)+1);
                if (height > largest) {
                    largest = height;
                }

            }
            //System.out.println("largest " + largest);
            // set the value of the largest key to 0
            heights.put(largest, 0);
            photoCows++;
            //System.out.println(heights);

            for (int cow : heights.keySet()) {
                if (heights.get(cow) > 1) {
                    photoCows += 2;
                }
            }

            System.out.println(photoCows);
            scan.nextLine();
        }


    }
}
