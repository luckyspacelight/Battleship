import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int boxSizes = 3;
        int[] arBox1 = new int[boxSizes];
        int[] arBox2 = new int[boxSizes];

        // Input Box 1
        for (int i = 0; i < boxSizes; i++) {
            arBox1[i] = scanner.nextInt();
        }
        Arrays.sort(arBox1);

        // Input Box 2
        for (int i = 0; i < boxSizes; i++) {
            arBox2[i] = scanner.nextInt();
        }
        Arrays.sort(arBox2);

        int box1Counter = 0;
        int box2Counter = 0;

        for (int i = 0; i < boxSizes; i++) {
            if (arBox1[i] > arBox2[i]) {
                box1Counter++;
            } else if (arBox2[i] > arBox1[i]) {
                box2Counter++;
            }
        }

        if (box1Counter == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (box2Counter == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }

    }
}