package battleship;

import java.util.Scanner;

public class Ship {

    private String name;
    private int cellsNumber;
    private String[] locationCells;

    public Ship(String name, int cellsNumber) {
        this.name = name;
        this.cellsNumber = cellsNumber;
    }

    public String[] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(String[] locationCells) {
        this.locationCells = locationCells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellsNumber() {
        return cellsNumber;

    }

    public void setCellsNumber(int cellsNumber) {
        this.cellsNumber = cellsNumber;
    }

    public void placeShip(GameField gf) {

        Scanner scanner = new Scanner(System.in);
        String startString = "Enter the coordinates of the";
        System.out.printf("%s %s (%d cells):%n", startString, this.getName(), this.getCellsNumber());
        boolean noError = true;
        String fromCell = "";
        String toCell = "";
        int rowFC = 0;
        int colFC = 0;
        int rowTC = 0;
        int colTC = 0;

        do {
            fromCell = scanner.next().toUpperCase();
            toCell = scanner.next().toUpperCase();

            // First coordinate (from Cell)
            rowFC = fromCell.substring(0,1).charAt(0) - 65;
            colFC = Integer.parseInt(fromCell.substring(1)) - 1;

            // Second coordinate (to Cell)
            rowTC = toCell.substring(0,1).charAt(0) - 65;
            colTC = Integer.parseInt(toCell.substring(1)) - 1;

            // Check errors
            noError = Helper.checkErrors(rowFC, colFC, rowTC, colTC, this, gf);

        } while (noError == false);


        if (noError) {
            // Update ship fields
            this.setLocationCells(new String[] {fromCell, toCell});

            // Update Game Field
            gf.updateGameField(rowFC, colFC, rowTC, colTC);

            // Show the Game Field
            System.out.println();
            gf.showGameField(false);
            System.out.println();
        }
    }

}
