import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PrintSequences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        while (T-- > 0) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            scan.nextLine();

            String seq = scan.nextLine();
            System.out.println(printable(seq, K, N));
        }
    }

    static String printable(String seq, int K, int N) {
        if (K == 1 || N == 1) {
            return "YES";
        }

        seq = seq.replace(" ", "");

        if (K == 2) {
            for (int x=1; x<=N; x++) {
                if (N % x != 0) continue;
                for (int y=0; y<=N/x; y++) {
                    int z = N/x - y;
                    String s = ("1".repeat(y) + "2".repeat(z)).repeat(x);
                    if (s.equals(seq)) return "YES";
                    s = ("2".repeat(y) + "1".repeat(z)).repeat(x);
                    if (s.equals(seq)) return "YES";
                }
            }
        }

        if (K == 3) {
            for (int x=1; x<=N; x++) {
                if (N % x != 0) continue;
                for (int y=0; y<N/x; y++) {
                    int z = N/x - y;

                    for (int a=1; a<=y; a++) {
                        if (y % a != 0) continue;
                        for (int b=0; b<=y/a; b++) {
                            int c = y/a - b;
                            String s = (("0".repeat(b) + "1".repeat(c)).repeat(a) + "2".repeat(z)).repeat(x);
                            int[] matches = new int[] {-1, -1, -1};
                            int i;
                            for (i=0; i<N; i++) {
                                if (matches[s.charAt(i)-'0'] == -1) {
                                    matches[s.charAt(i)-'0'] = seq.charAt(i)-'0';
                                } else if (matches[s.charAt(i)-'0'] != seq.charAt(i)-'0') {
                                    break;
                                }
                            }
                            if (i == N) {
                                return "YES";
                            }
                            // check reversed
                            matches = new int[] {-1, -1, -1};
                            for (i=0; i<N; i++) {
                                if (matches[s.charAt(i)-'0'] == -1) {
                                    matches[s.charAt(i)-'0'] = seq.charAt(N-1-i)-'0';
                                } else if (matches[s.charAt(i)-'0'] != seq.charAt(N-1-i)-'0') {
                                    break;
                                }
                            }
                            if (i == N) {
                                return "YES";
                            }

                        }
                    }
                }
            }
        }

        return "NO";
    }
}
