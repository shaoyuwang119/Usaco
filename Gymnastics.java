import java.io.*;
import java.util.*;

public class Gymnastics {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
    
		int sessionNum = scan.nextInt();
		int cowNum = scan.nextInt();
    
		int[][] sessions = new int[sessionNum][cowNum];
		for (int s = 0; s < sessionNum; s++) {
			scan.nextLine();
			for (int c = 0; c < cowNum; c++) {
				sessions[s][c] = scan.nextInt() - 1;
			}
		}

		int betterPairs = 0;
		for (int c1 = 0; c1 < cowNum; c1++) {
			for (int c2 = 0; c2 < cowNum; c2++) {
				if (c1 == c2) { continue; }

				boolean valid = true;
				for (int[] s : sessions) {
					if (index(s, c1) < index(s, c2)) {
						valid = false;
						break;
					}
				}

				if (valid) { betterPairs++; }
			}
		}

    System.out.println(betterPairs);
	}

	static int index(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) { return i; }
		}
		return -1;
	}
}
