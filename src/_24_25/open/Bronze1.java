import java.io.*;
import java.util.*;

public class Bronze1 {

    static HashMap<Integer, HashSet<Integer>> rules = new HashMap<>();
    // key represents symbol, values is a collection of symbols that the key loses against

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        long start = System.currentTimeMillis();
        scan.useDelimiter("");
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                String letter = scan.next();
                int w;
                int l;
                if (letter.equals("W")) {
                    w = i;
                    l = j;
                } else if (letter.equals("L")) {
                    w = j;
                    l = i;
                } else {
                    continue;
                }
                if (!rules.containsKey(l)) {
                    rules.put(l, new HashSet<>());
                }
                rules.get(l).add(w);
            }
            scan.nextLine();
        }

        scan.reset();
        for (int i=0; i<m; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int winners = guaranteedWinners(l, r);
            int sum = (int) ((2*winners-2)*(winners)/2);
            int winningCombs = (2*n - 1) * winners - sum;
            //System.out.println(winners + "winners");

            System.out.println(winningCombs);
            scan.nextLine();

        }

        //System.out.println(System.currentTimeMillis()-start + " ms");

    }

    static int guaranteedWinners(int a, int b) {
        HashSet<Integer> listA = rules.get(a);
        HashSet<Integer> listB = rules.get(b);
        int out = 0;

        for (int i : listA) {
            if (listB.contains(i)) {
                out++;
            }
        }

        return out;
    }
}
