import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int maxChars = 50;
        char[] chars = new char[maxChars];
        int number = reader.read(chars);
        String output = "";
        for (int i = 0; i < number; i++) {
            output = chars[i] + output;
        }
        reader.close();
        System.out.print(output);
    }
}