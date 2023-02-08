package battleship;

import java.util.Scanner;

public class GameHandler {

    public void startTheGame(GameField gf) {
        System.out.println("The game starts!\n");
        gf.showGameField(false);
        System.out.println();
    }

    public void takeAShot(GameField gf) {

        boolean noError = true;
        int rowShot = 0;
        int colShot = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Take a shot!\n");

        do {
            // Input shot coordinate
            String theShot = scanner.nextLine().toUpperCase();

            // Shot coordinate
            rowShot = theShot.substring(0,1).charAt(0) - 65;
            colShot = Integer.parseInt(theShot.substring(1)) - 1;

            // Check errors
            noError = Helper.checkErrors(rowShot, colShot);

        } while (noError == false);

        if (noError) {
            // Update Game Field
            boolean isTheShipHit = gf.updateFieldAfterShot(rowShot, colShot);

            // Show the Game Field
            System.out.println();
            gf.showGameField(false);
            System.out.println();
            if (isTheShipHit) {
                System.out.println("You hit a ship!");
            } else {
                System.out.println("You missed!");
            }
        }
    }

}
