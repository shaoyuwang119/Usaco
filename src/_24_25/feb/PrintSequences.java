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
            boolean yay = printable(seq, K);
            if (yay) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static boolean printable(String seq, int K) {
        if (K == 1) {
            return true;
        }

        seq += " ";
        if (K == 2) {
            StringBuilder chunkSB = new StringBuilder();
            char buildChar = seq.charAt(0);
            int i=0;
            for (int c = 0; c <2; c++) {
                while (i < seq.length() && seq.charAt(i) == buildChar) {
                    chunkSB.append(buildChar);
                    chunkSB.append(" ");
                    i+= 2;
                }
                if (i < seq.length()) {
                    buildChar = seq.charAt(i);
                } else {
                    break;
                }
            }

            String chunk = chunkSB.toString();
            System.out.println(chunk);

            int len = chunk.length();
            if (seq.length() % len != 0) {
                return false;
            }

            i=0; // repurpose i
            for (i=len; i<seq.length(); i+=len) {
                String testChunk = seq.substring(i, i+len);
                if (!testChunk.equals(chunk)) {
                    return false;
                }
            }

            return true;

        }

        // if K == 3
        return false;
    }
}
