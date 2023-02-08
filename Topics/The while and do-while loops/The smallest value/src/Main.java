import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();

        long n = 1;
        long result = 1;

        while (result <= m) {
            n++;
            result *= n;
        }
        System.out.println(n);
    }
}
