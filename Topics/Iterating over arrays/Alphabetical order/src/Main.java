import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        // Create the array
        String[] strArray = inputLine.split(" ");
        boolean inAlphabeticalOrder = true;

        for (int i = 0; i < strArray.length - 1; i++) {
            if (strArray[i].compareTo(strArray[i + 1]) > 0) {
                inAlphabeticalOrder = false;
                // i = strArray.length;
                break;
            }
        }
        System.out.println(inAlphabeticalOrder);
    }
}
