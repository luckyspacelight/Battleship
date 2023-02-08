import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exception e = new Exception(sc.nextLine());
        Exception customException = new CustomException(e);

        System.out.println(customException.getMessage());
    }
}

class CustomException extends Exception {
    CustomException(Exception e) {
        super(e);
    }
}