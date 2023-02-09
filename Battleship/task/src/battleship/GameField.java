package battleship;

public class GameField {

    private int rows;
    private int columns;
    private boolean gridHdFc;
    private String[][] arGameField;

    private final static String YOU_MISSED = "M";
    private final static String YOU_HIT_A_SHIP = "X";

    public GameField(int rows, int columns, boolean gridHdFc)  {
        this.rows = rows;
        this.columns = columns;
        this.gridHdFc = gridHdFc;
        this.arGameField = new String[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String[][] getArGameField() {
        return arGameField;
    }

    public void showGameField(boolean isSetup, boolean isFogOfWar) {

        // Print header (first row)
        if (gridHdFc) {
            String hd = "";
            final int cols = this.getColumns();
            for (int i = 0; i <= cols; i++) {
                if (i == 0) {
                    hd = " ";
                } else if (i == cols) {
                    hd = " %d%n";
                } else {
                    hd = " %d";
                }
                System.out.printf(hd, i);
            }
        }

        // Print game field
        int A = 65;
        for (int i = 0; i < arGameField.length; i++) {
            for (int j = 0; j < arGameField[i].length; j++) {

                // Print first column
                if (j == 0 && gridHdFc) {
                    System.out.printf("%c ".toUpperCase(), 'a' + i);
                }

                // Useful for setup
                arGameField[i][j] = isSetup == true ? "~" : arGameField[i][j];

                // Useful for the "fog of war" option (true)
                if (isFogOfWar) {
                    System.out.printf("%s ", arGameField[i][j].replace('O', '~'));
                } else {
                    System.out.printf("%s ", arGameField[i][j]);
                }

            }
            System.out.printf("%n");
        }

    }

    public void updateGameField(int rowFC, int colFC, int rowTC, int colTC){
        if (rowFC == rowTC) {
            for (int i = Math.min(colFC, colTC); i <= Math.max(colFC, colTC); i++) {
                arGameField[rowFC][i] = "O";
            }
        } else if (colFC == colTC) {
            for (int i = Math.min(rowFC, rowTC); i <= Math.max(rowFC, rowTC); i++) {
                arGameField[i][colFC] = "O";
            }
        }
    }

    public boolean updateFieldAfterShot(int row, int col){
        boolean isHit = false;
        if (arGameField[row][col].equals("O") || arGameField[row][col].equals("X")) {
            arGameField[row][col] = YOU_HIT_A_SHIP;
            isHit = true;
        } else {
            arGameField[row][col] = YOU_MISSED;
        }
        return isHit;
    }

}
