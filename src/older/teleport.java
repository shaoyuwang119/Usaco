import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class teleport {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File("older.teleport.in"));
        FileWriter writer = new FileWriter("older.teleport.out");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();

        int dist = 0;
        int min = Math.min(Math.abs(x - a), Math.abs(y - a));
        int min2 = Math.min(Math.abs(x - b), Math.abs(y - b));
        if (min +  min2 < Math.abs(a - b)) {
            dist += min;
            dist += min2;
        } else {
            dist += Math.abs(a-b);
        }

        writer.write(dist + "");
        writer.close();
    }
}
