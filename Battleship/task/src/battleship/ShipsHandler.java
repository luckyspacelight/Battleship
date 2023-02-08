package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShipsHandler {

    private Ship ship01;
    private Ship ship02;
    private Ship ship03;
    private Ship ship04;
    private Ship ship05;
    private Ship[] ships;

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
        this.ship01 = new Ship(ShipNames.AIRCRAFT_CARRIER.name, ShipNames.AIRCRAFT_CARRIER.cellsNum);
        this.ship02 = new Ship(ShipNames.BATTLESHIP.name, ShipNames.BATTLESHIP.cellsNum);
        this.ship03 = new Ship(ShipNames.SUBMARINE.name, ShipNames.SUBMARINE.cellsNum);
        this.ship04 = new Ship(ShipNames.CRUISER.name, ShipNames.CRUISER.cellsNum);
        this.ship05 = new Ship(ShipNames.DESTROYER.name, ShipNames.DESTROYER.cellsNum);

        ships = new Ship[5];
        ships[0] = ship01;
        ships[1] = ship02;
        ships[2] = ship03;
        ships[3] = ship04;
        ships[4] = ship05;
    }


    public Ship getShip01() {
        return ship01;
    }

    public void setShip01(Ship ship01) {
        this.ship01 = ship01;
    }

    public Ship getShip02() {
        return ship02;
    }

    public void setShip02(Ship ship02) {
        this.ship02 = ship02;
    }

    public Ship getShip03() {
        return ship03;
    }

    public void setShip03(Ship ship03) {
        this.ship03 = ship03;
    }

    public Ship getShip04() {
        return ship04;
    }

    public void setShip04(Ship ship04) {
        this.ship04 = ship04;
    }

    public Ship getShip05() {
        return ship05;
    }

    public void setShip05(Ship ship05) {
        this.ship05 = ship05;
    }

    @Override
    public String toString() {
        String ships = ship01.getName() + "\n";
        ships += ship02.getName() + "\n";
        ships += ship03.getName() + "\n";
        ships += ship04.getName() + "\n";
        ships += ship05.getName() + "\n";
        return ships;
    }

    public void setupShips(GameField gf) {
        for (Ship ship : ships) {
            ship.placeShip(gf);
        }
    }

}
