package battleship;

public class Main {

    private final static int GAMEFIELD_ROWS = 10;
    private final static int GAMEFIELD_COLS = 10;
    private final static int PLAYER_1 = 1;
    private final static int PLAYER_2 = 2;

    public  static void main(String[] args) {

        // Set the Player 01 game field
        String[][] arGameField1 = new String[GAMEFIELD_ROWS][GAMEFIELD_COLS];
        GameField gF1 = new GameField(true, arGameField1);

        // Set the Player 02 game field
        String[][] arGameField2 = new String[GAMEFIELD_ROWS][GAMEFIELD_COLS];
        GameField gF2 = new GameField(true, arGameField2);

        // Show the Player 01 game field
        System.out.println("Player 1, place your ships on the game field\n");
        gF1.showGameField(true, false);

        //Create Player 01 ships
        ShipsHandler shipsHandler = new ShipsHandler();
        System.out.println();

        //Create Player 01 ships
        shipsHandler.setupShips(gF1, PLAYER_1);

        //  Add the message to pass the move to another player
        Helper.passToAnotherPlayer();

        // Show the Player 02 game field
        System.out.println("Player 2, place your ships on the game field\n");
        gF2.showGameField(true, false);

        //Create Player 02 ships
        System.out.println();
        shipsHandler.setupShips(gF2, PLAYER_2);

        //  Add the message to pass the move to another player
        Helper.passToAnotherPlayer();

        //The game
        GameHandler gameHandler = new GameHandler();
        boolean turn = true;
        boolean notSunkShips = true;

        while (notSunkShips) {
            if (turn) {
                gameHandler.showTwoScreens(gF1, gF2, PLAYER_1);
                notSunkShips = gameHandler.takeAShot(gF1, gF2, shipsHandler, PLAYER_1, notSunkShips);
            } else {
                gameHandler.showTwoScreens(gF1, gF2, PLAYER_2);
                notSunkShips = gameHandler.takeAShot(gF1, gF2, shipsHandler, PLAYER_2, notSunkShips);
            }
            turn = !turn;
        }
    }
}
