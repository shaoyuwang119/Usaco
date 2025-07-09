import java.util.*;

public class MooinTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stringLen = scan.nextInt();
        int queries = scan.nextInt();
        scan.nextLine();
        String string = scan.nextLine();
        long start = System.currentTimeMillis();
        char[] stringArr = string.toCharArray();

        for (; queries>0; queries--) {
            int value = -1;
            int left = scan.nextInt();
            int right = scan.nextInt();

            System.out.println(findLargestValue(left-1, right-1, stringArr));
        }
        //System.out.println(System.currentTimeMillis() - start + "ms");

    }

    static long findLargestValue(int left, int right, char[] arr) {
        long value = -1;
        int i;
        int k;

        for (i = left; i < right-2; i++) {
            //System.out.println("i = " + i);
            double iMax = Math.pow((double) (right-i)/2, 2);
            if (iMax < (double) value) {
                break;
            }

            for (k = right; k > i+1; k--) {
                double kMax = Math.pow((double) (k-i)/2, 2);
                if (kMax < (double) value) {
                    //System.out.println(k);
                    //System.out.println("asdfgfdsa");
                    break;
                }

                if (arr[k] == arr[i]) {
                    //System.out.println(left + " " + right + " eqas");
                    continue;
                }

                int j = (k+i)/2;
                //System.out.println(j);
                int jL = j;
                int jR = j+1;
                for (; jL > i; jL--) {
                    if (arr[jL] == arr[k]) {
                        //System.out.println("break!L " + jL + " " + j);
                        break;
                    }
                }
                for (; jR < k; jR++) {
                    if (arr[jR] == arr[k]) {
                        //System.out.println("break!R " + jR + " " + j);
                        break;
                    }
                }
                if (jL == i && jR == k) continue;

                if (j-jL < jR-j) {
                    j = jL;
                } else {
                    j = jR;
                }

                long newValue = (long) (k - j) * (j - i);
                if (newValue > value) {
                    value = newValue;
                    if (value == 0) {
                        //System.out.println(i+" "+jL+" "+k);
                    }
                    //System.out.println(i + " " + j + " " + k + " " + jL + " " + jR + " " + value);
                }
            }

        }

        return value;

    }
}
