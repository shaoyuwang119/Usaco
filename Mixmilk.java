import java.io.*;
import java.util.*;

public class MixMilk {
	static final int N = 3;  // The number of buckets (which is 3)
	static final int TURN_NUM = 100;

	public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);

		// capacity[i] is the maximum capacity of bucket i
		int[] capacity = new int[N];
		// milk[i] is the current amount of milk in bucket i
		int[] milk = new int[N];

		for (int i = 0; i < N; i++) {
			capacity[i] = scan.nextInt();
			milk[i] = scan.nextInt();
      scan.nextLine();
		}

		for (int i = 0; i < TURN_NUM; i++) {
			int bucket1 = i % N;
			int bucket2 = (i + 1) % N;

			/*
			 * The amount of milk to pour is the minimum of the remaining milk
			 * in bucket 1 and the available capacity of bucket 2
			 */
			int amt = Math.min(milk[bucket1], capacity[bucket2] - milk[bucket2]);

			milk[bucket1] -= amt;
			milk[bucket2] += amt;
		}

		for (int m : milk) { System.out.println(m); }
		io.close();
	}
