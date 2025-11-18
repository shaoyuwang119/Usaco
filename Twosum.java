import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();

		Map<Integer, Integer> m = new HashMap<>();
    
		for (int i = 0; i < n; i++) {
			int a = Scanner.nextInt();
			if (m.containsKey(x - a)) {
				System.out.println("Indices are " + i + " " + m.get(x - a);
				return;
			}
      
			m.put(a, i);
		}

		System.out.println("Impossible");
	}
}
