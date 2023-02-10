package battleship;

import java.util.Scanner;

public class GameHandler {

    public void showTwoScreens(GameField gf1, GameField gf2, int player) {

        if (player == 1) {
            gf2.showGameField(false, true);
            System.out.println("---------------------");
            gf1.showGameField(false, false);
            System.out.println();
        } else if (player == 2) {
            gf1.showGameField(false, true);
            System.out.println("---------------------");
            gf2.showGameField(false, false);
            System.out.println();
        }

    }


    public Boolean takeAShot(GameField gf1, GameField gf2, ShipsHandler sh, int player, boolean unsunkShips) {

        boolean noError = true;
        boolean shipIsSunk = false;
        String theShot = "";

        int rowShot = 0;
        int colShot = 0;

        Scanner sc = new Scanner(System.in);
        System.out.printf("Player %d, it's your turn:%n%n", player);


            do {
                // Input shot coordinate
                theShot = sc.nextLine().toUpperCase();

                // Shot coordinate
                rowShot = theShot.substring(0,1).charAt(0) - 65;
                colShot = Integer.parseInt(theShot.substring(1)) - 1;

                // Check errors
                noError = Helper.checkError(rowShot, colShot);

            } while (noError == false);

            if (noError) {
                // Update Game Field
                boolean isTheShipHit = false;
                if (player == 1) {
                    isTheShipHit = gf2.updateFieldAfterShot(rowShot, colShot);
                } else if (player == 2) {
                    isTheShipHit = gf1.updateFieldAfterShot(rowShot, colShot);
                }

                // Update the ship coordinate
                if (isTheShipHit) {
                    for (Ship ship : sh.getShips(player)) {
                        String[][] arTest = ship.getLocationCells();
                        for (int i = 0; i < arTest.length; i++) {
                            if (theShot.equals(arTest[i][0])) {
                                arTest[i][1] = "X";
                            }
                            System.out.println("TEST: theShot=" + theShot + " Position="+ arTest[i][0] + " -> " + arTest[i][1]);
                        }
                    }
                }

                if (isTheShipHit) {

                    // Check if a ship is sunk
                    for (Ship ship : sh.getShips(player)) {
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
                        for (Ship ship : sh.getShips(player)) {
                            if (ship.isSunk() == false) {
                                unsunkShips = true;
                                break;
                            }
                        }
                    }

                    if (shipIsSunk) {
                        if (unsunkShips == false) {
                            System.out.println("\nYou sank the last ship. You won. Congratulations!");
                            return false;
                        } else {
                            System.out.println("\nYou sank a ship!");
                            shipIsSunk = false;
                        }
                    } else {
                        System.out.println("\nYou hit a ship!");
                    }
                } else {
                    System.out.println("\nYou missed!");
                }
            }
            Helper.passToAnotherPlayer();
        return true;
    }

}
