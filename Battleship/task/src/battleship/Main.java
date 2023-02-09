package battleship;

public class Main {

    public static void main(String[] args) {

        // Set the game field
        GameField gF = new GameField(10, 10, true);
        gF.showGameField(true, false);

        //Create ships
        System.out.println();
        ShipsHandler shipsHandler = new ShipsHandler();
        shipsHandler.setupShips(gF);

        // TEST | Eseguo un test per verificare inserimento coordinate in locationCells
        //System.out.println();
        //shipsHandler.testInputCoord();
        //System.out.println();

        //The first shot
        GameHandler gameHandler = new GameHandler();
        gameHandler.startTheGame(gF);
        gameHandler.takeAShot(gF, shipsHandler);
    }
}
