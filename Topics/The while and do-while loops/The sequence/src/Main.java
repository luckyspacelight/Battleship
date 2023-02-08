import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        Integer[] numbers = new Integer[nElements];

        // Fill the array with numbers
        for (int i = 0; i < nElements; i++) {
            if (scanner.hasNext()) {
                numbers[i] = scanner.nextInt();
            }
        }
        // Sorts the specified array into ascending numerical order
        Arrays.sort(numbers, Collections.reverseOrder());

        boolean isNotDivisible = true;
        int i = 0;
        final int divisor = 4;
        while (i < numbers.length && isNotDivisible) {
            if (numbers[i] % divisor == 0) {
                isNotDivisible = false;
                System.out.println(numbers[i]);
            }
            i++;
        }
    }
}