package battleship;

import java.util.Scanner;

public class Ship {

    private String name;
    private int cellsNumber;
    private String[][] locationCells;
    private boolean isSunk;

    public Ship(String name, int cellsNumber) {
        this.name = name;
        this.cellsNumber = cellsNumber;
        this.locationCells = new String[cellsNumber][2];
        isSunk = false;
    }

    public String[][] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(String[][] locationCells) {
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

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void placeShip(GameField gf) {

        Scanner scanner = new Scanner(System.in);
        String startString = "Enter the coordinates of the";
        System.out.printf("%s %s (%d cells):%n", startString, this.getName(), this.getCellsNumber());

        boolean noError = true;

        String fromCell = "";
        String toCell = "";

        String rowFCstr = "";
        String colFCstr = "";
        String rowTCstr = "";
        String colTCstr = "";

        int rowFC = 0;
        int colFC = 0;
        int rowTC = 0;
        int colTC = 0;

        do {
            fromCell = scanner.next().toUpperCase();
            toCell = scanner.next().toUpperCase();

            // First coordinate (from Cell)
            rowFCstr = fromCell.substring(0,1);
            colFCstr = fromCell.substring(1);
            rowFC = fromCell.substring(0,1).charAt(0) - 65;
            colFC = Integer.parseInt(fromCell.substring(1)) - 1;

            // Second coordinate (to Cell)
            rowTCstr = toCell.substring(0,1);
            colTCstr = toCell.substring(1);
            rowTC = toCell.substring(0,1).charAt(0) - 65;
            colTC = Integer.parseInt(toCell.substring(1)) - 1;

            // Check errors
            noError = Helper.checkErrors(rowFC, colFC, rowTC, colTC, this, gf);

        } while (noError == false);


        if (noError) {

            // Insert ship cells in the ship location array
            if(rowFCstr.equals(rowTCstr)) {  // Horizontal ship
                for (int i = Math.min(colFC, colTC), j = 0; i <= Math.max(colFC, colTC) && j < locationCells.length; i++, j++) {
                    locationCells[j][0] = rowFCstr + (i + 1);
                    locationCells[j][1] = "O";
                }
            } else if (colFC == colTC) {   // Vertical ship
                for (int i = Math.min(rowFC, rowTC), j = 0; i <= Math.max(rowFC, rowTC) && j < locationCells.length; i++, j++) {
                    locationCells[j][0] = (char) (rowFC + 65) + colFCstr;
                    locationCells[j][1] = "O";
                }
            }

            // Update Game Field
            gf.updateGameField(rowFC, colFC, rowTC, colTC);

            // Show the Game Field
            System.out.println();
            gf.showGameField(false, false);
            System.out.println();
        }
    }

}
