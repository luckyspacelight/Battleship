package battleship;

public class ShipsHandler {

    private Ship shipP1_01;
    private Ship shipP1_02;
    private Ship shipP1_03;
    private Ship shipP1_04;
    private Ship shipP1_05;

    private Ship shipP2_01;
    private Ship shipP2_02;
    private Ship shipP2_03;
    private Ship shipP2_04;
    private Ship shipP2_05;

    private Ship[] ships1;
    private Ship[] ships2;

    enum ShipNames {

        AIRCRAFT_CARRIER(1, "Aircraft Carrier", 5),
        BATTLESHIP(2, "Battleship", 4),
        SUBMARINE(3, "Submarine", 3),
        CRUISER(4, "Cruiser", 3),
        DESTROYER(5, "Destroyer", 2);

        int ordinal;
        String name;
        int cellsNum;

        ShipNames(int ordinal, String name, int cellsNum) {
            this.ordinal = ordinal;
            this.name = name;
            this.cellsNum = cellsNum;
        }
    }

    public ShipsHandler() {
        this.shipP1_01 = new Ship(ShipNames.AIRCRAFT_CARRIER.name, ShipNames.AIRCRAFT_CARRIER.cellsNum);
        this.shipP1_02 = new Ship(ShipNames.BATTLESHIP.name, ShipNames.BATTLESHIP.cellsNum);
        this.shipP1_03 = new Ship(ShipNames.SUBMARINE.name, ShipNames.SUBMARINE.cellsNum);
        this.shipP1_04 = new Ship(ShipNames.CRUISER.name, ShipNames.CRUISER.cellsNum);
        this.shipP1_05 = new Ship(ShipNames.DESTROYER.name, ShipNames.DESTROYER.cellsNum);

        this.shipP2_01 = new Ship(ShipNames.AIRCRAFT_CARRIER.name, ShipNames.AIRCRAFT_CARRIER.cellsNum);
        this.shipP2_02 = new Ship(ShipNames.BATTLESHIP.name, ShipNames.BATTLESHIP.cellsNum);
        this.shipP2_03 = new Ship(ShipNames.SUBMARINE.name, ShipNames.SUBMARINE.cellsNum);
        this.shipP2_04 = new Ship(ShipNames.CRUISER.name, ShipNames.CRUISER.cellsNum);
        this.shipP2_05 = new Ship(ShipNames.DESTROYER.name, ShipNames.DESTROYER.cellsNum);

        // Player 1 ships
        ships1 = new Ship[5];
        ships1[0] = shipP1_01;
        ships1[1] = shipP1_02;
        ships1[2] = shipP1_03;
        ships1[3] = shipP1_04;
        ships1[4] = shipP1_05;

        // Player 2 ships
        ships2 = new Ship[5];
        ships2[0] = shipP2_01;
        ships2[1] = shipP2_02;
        ships2[2] = shipP2_03;
        ships2[3] = shipP2_04;
        ships2[4] = shipP2_05;

    }

    public Ship[] getShips(int player) {
        if (player == 1) {
            return ships2;
        }
        return ships1;

    }

    public void setupShips(GameField gf, int player) {
        if (player == 1)
            for (Ship ship : ships1) {
                ship.placeShip(gf);
            }
        else if (player == 2) {
            for (Ship ship : ships2) {
                ship.placeShip(gf);
            }
        }
    }

}
