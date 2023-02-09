package battleship;

import java.util.Scanner;

public class GameHandler {

    public void startTheGame(GameField gf) {
        System.out.println("The game starts!\n");
        gf.showGameField(false, true);
        System.out.println();
    }

    public void takeAShot(GameField gf, ShipsHandler sh) {

        boolean noError = true;
        boolean unsunkShips = true;
        boolean shipIsSunk = false;
        String theShot = "";

        int rowShot = 0;
        int colShot = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Take a shot!\n");

        while (unsunkShips) {

            do {
                // Input shot coordinate
                theShot = scanner.nextLine().toUpperCase();

                // Shot coordinate
                rowShot = theShot.substring(0,1).charAt(0) - 65;
                colShot = Integer.parseInt(theShot.substring(1)) - 1;

                // Check errors
                noError = Helper.checkError(rowShot, colShot);

            } while (noError == false);

            if (noError) {
                // Update Game Field
                boolean isTheShipHit = gf.updateFieldAfterShot(rowShot, colShot);

                // Update the ship coordinate
                if (isTheShipHit) {
                    for (Ship ship : sh.getShips()) {
                        String[][] arTest = ship.getLocationCells();
                        for (int i = 0; i < arTest.length; i++) {
                            if (theShot.equals(arTest[i][0])) {
                                arTest[i][1] = "X";
                            }
                        }
                    }
                }

                // Show the Game Field
                System.out.println();
                gf.showGameField(false, true);

                /* TODO Inserire il controllo di affondamento di una nave */
                if (isTheShipHit) {

                    // Check if a ship is sunk
                    for (Ship ship : sh.getShips()) {
                        if (!ship.isSunk()){
                            for (int i = 0; i < ship.getLocationCells().length; i++) {
                                ship.setSunk(true);
                                if (ship.getLocationCells()[i][1].equals("O")) {
                                    ship.setSunk(false);
                                    break;
                                }
                            }

                            //Ship sunk!
                            if (ship.isSunk()) {
                                shipIsSunk = true;
                                break;
                            }
                        }
                    }

                    // I check if all ships are sunk
                    if (shipIsSunk) {
                        unsunkShips = false;
                        for (Ship ship : sh.getShips()) {
                            if (ship.isSunk() == false) {
                                unsunkShips = true;
                                break;
                            }
                        }
                    }

                    if (shipIsSunk) {
                        if (unsunkShips == false) {
                            System.out.println("\nYou sank the last ship. You won. Congratulations!");
                        } else {
                            System.out.println("\nYou sank a ship! Specify a new target:\n");
                            shipIsSunk = false;
                        }
                    } else {
                        System.out.println("\nYou hit a ship! Try again:\n");
                    }
                } else {
                    System.out.println("\nYou missed! Try again:\n");
                }
            }
        }

    }
}
