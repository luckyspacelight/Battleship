import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arSize = scanner.nextInt();
        int[] anArray = new int[arSize];

        for (int i = 0; i < arSize; i++) {
            if (scanner.hasNext()) {
                anArray[i] = scanner.nextInt();
            }
        }
        Arrays.sort(anArray);
        System.out.println(anArray[0]);
    }
}
