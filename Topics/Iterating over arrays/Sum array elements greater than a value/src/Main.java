import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayNumber = scanner.nextInt();
        int[] myArray = new int[arrayNumber];

        for (int i = 0; i < arrayNumber; i++) {
            if (scanner.hasNext()) {
                myArray[i] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();

        int sum = 0;
        for (int ma : myArray) {
            if (ma > n) {
                sum += ma;
            }
        }

        System.out.println(sum);
    }
}