import java.util.Scanner;

class Main {
    static final  int NUMBER_THREE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String space = " ";
        System.out.print(n + space);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * NUMBER_THREE + 1;
            }
            space = (n == 1) ? "" : " ";
            System.out.print(n + space);
        }
    }
}
