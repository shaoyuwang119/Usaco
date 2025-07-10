import java.util.*;

public class Mexes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[] a = new int[N+1];
        // each element of a represents how many numbers of that index exists

        for (int i=0; i<N; i++) {
            int index = scan.nextInt();
            a[index] += 1;
        }

        ArrayList<Integer> missings = new ArrayList<>();

        for (int i=0; i<a.length; i++) {
            if (a[i] == 0) {
                missings.add(i);
            }
        }

        for (int i=0; i<=N; i++) {
            int index = Collections.binarySearch(missings, i);
            if (index >= 0) {
                System.out.println(index);
            } else {
                int newIndex = index * -1 - 1;
                System.out.println(Math.max(newIndex, a[i]));
            }
        }
    }


}
