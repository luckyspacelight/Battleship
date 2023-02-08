import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int maxNum = 100;
        char[] chars = new char[maxNum];
        int totalChars = reader.read(chars);
        reader.close();

        String inputString = "";
        for (int i = 0; i < totalChars; i++) {
            inputString += chars[i];
        }

        inputString = inputString.trim();

        int countWords = 0;
        if (!inputString.isEmpty()) {
            String[] arrWords = inputString.split("\\s+");
            countWords = arrWords.length;
        }

        System.out.println(countWords);

        /*  SOLUZIONI MIGLIORI (Da "Solutions")

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        int count = input.isEmpty() ? 0 : input.split("\\s+").length;
        System.out.println(count);
        reader.close();

        OPPURE:

        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {

            // Reader is supertype of BufferedReader
            // and BufferedReader is the actual object created
            // at runtime so we are free to cast reader to BufferedReader
            // to get the readLine() functionality
            String line = ((BufferedReader) reader).readLine();

            // read line is only white spaces or empty (length == 0) return 0
            // otherwise we remove all leading and trailing white spaces
            // from line to use split by white space (1 or more)
            int result = line.isBlank() ? 0 : line.trim().split("\\s+").length;

            System.out.println(result);
        }
        */

    }
}