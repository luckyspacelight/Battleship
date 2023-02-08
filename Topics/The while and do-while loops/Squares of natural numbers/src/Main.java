import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int i = 1;
        while (Math.pow(i, 2) <= n) {
            System.out.println(i * i);
            i++;
        }

        /*
        for (int i = 1; Math.pow(i, 2) <= n; i++) {
            System.out.println(i * i);
        }
        */


    }
}