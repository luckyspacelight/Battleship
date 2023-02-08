import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        // Method 1
        byte[] bytes = inputStream.readAllBytes();
        for (byte b : bytes) {
            System.out.print(b);
        }
        inputStream.close();

        /*
        - Method 2
        int byteAsNumber = inputStream.read();
        while (byteAsNumber != -1) {
            System.out.print(byteAsNumber);
            byteAsNumber = inputStream.read();
        }
        inputStream.close();
        */

    }
}
