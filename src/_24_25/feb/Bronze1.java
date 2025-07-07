import java.util.*;

public class Bronze1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int U = scan.nextInt();
        scan.nextLine();
        int[][] grid = new int[N][N];
        for (int r=0; r<N; r++) {
            String line = scan.nextLine();
            for (int c=0; c<N; c++) {
                char letter = line.charAt(c);
                if (letter == '.') {
                    grid[r][c] = -1;
                } else {
                    grid[r][c] = 1;
                }
            }
        }

        int updates = originalUpdates(grid);
        System.out.println(updates);

        for (int i=0; i<U; i++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            //System.out.println(r + ", " + c);
            updates = findNewUpdates(grid, r-1, c-1, updates);
            System.out.println(updates);
            scan.nextLine();
        }

    }

    public static int originalUpdates(int[][] grid) {
        int updates = 0;
        int len = grid.length;
        for (int r = 0; r < len/2; r++) {
            for (int c = 0; c < len/2; c++) {
                updates += findUpdates(grid, r, c);
            }
        }
        return updates;
    }

    public static int findNewUpdates(int[][] grid, int r, int c, int last) {
        int updates = last;
        updates -= findUpdates(grid, r, c);
        if (r != -1 && c != -1) {
            grid[r][c] = -1 * grid[r][c];
        }
        //System.out.println(Arrays.deepToString(grid));
        updates += findUpdates(grid, r, c);
        return updates;
    }

    public static int findUpdates(int[][] grid, int r, int c) {
        int updates = 0;
        int len = grid.length;
        int tl = grid[r][c];
        int tr = grid[r][len-c-1];
        int bl = grid[len-r-1][c];
        int br = grid[len-r-1][len-c-1];

        if (tl == tr && tr == bl && bl == br) {
            return updates;
        }

        if (tl * tr * bl * br == -1) {
            updates ++;
            //System.out.println("+1: " + r1 + " " + c1);
        } else {
            updates += 2;
            //System.out.println("+2: " + r1 + " " + c1);
        }
        return updates;
    }

}
