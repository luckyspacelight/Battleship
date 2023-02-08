package battleship;

public class Helper {

    public static int countDigits(int num1, int num2) {
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            count ++;
        }
        return count;
    }


    public static boolean checkErrors(int rowFC, int colFC, int rowTC, int colTC, Ship ship, GameField gf) {

        boolean noError = true;
        boolean isCloseToAShip = false;
        int cellsNumDigited = 0;


        if (rowFC == rowTC) {
            cellsNumDigited = countDigits(Math.min(colFC, colTC), Math.max(colFC, colTC));
        } else if (colFC == colTC) {
            cellsNumDigited = countDigits(Math.min(rowFC, rowTC), Math.max(rowFC, rowTC));
        }

        try {

            if (rowFC > 9 || colFC > 9 || rowTC > 9 || colTC > 9) {
                noError = false;
                throw new IllegalArgumentException("Error! Out of the 10x10 field. Try again:");
            }

            if (rowFC != rowTC && colFC != colTC) {
                noError = false;
                throw new IllegalArgumentException("Error! Wrong ship location! Try again:");
            }

            if (cellsNumDigited != ship.getCellsNumber()) {
                noError = false;
                throw new IllegalArgumentException("Error! Wrong length of the " + ship.getName() + ". Try again:");
            }

            isCloseToAShip = checkThePosition(rowFC, colFC, rowTC, colTC, gf, isCloseToAShip);

            if (isCloseToAShip) {
                noError = false;
                throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
            }


        } catch (IllegalArgumentException e) {
            System.out.printf("%n%s%n ", e.getMessage());
        } finally {
            return noError;
        }
    }


    public static boolean checkErrors(int row, int col) {

        boolean noError = true;

        try {
            if (row > 9 || col > 9 || row < 0 || col < 0) {
                noError = false;
                throw new IllegalArgumentException("Error! You entered the wrong coordinates! Try again:");
            }
        } catch (IllegalArgumentException e) {
            System.out.printf("%n%s%n%n", e.getMessage());
        } finally {
            return noError;
        }
    }

    public static boolean checkThePosition(int rowFC, int colFC, int rowTC, int colTC,
                                           GameField gf, boolean isCloseToAShip) {

        String[][] arGameField = gf.getArGameField();

        if(rowFC == rowTC) {
            for (int i = Math.min(colFC, colTC); i <= Math.max(colFC, colTC); i++) {
                int col = i;
                int row = rowFC;

                if (arGameField[row][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                if (arGameField[row][col = col == 9 ? 9 : col + 1].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                col = i;
                if (arGameField[row][col = col - 1 == 0 ? 0 : col - 1].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                col = i;
                if (arGameField[row = row == 9 ? 9 : row + 1][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                row = rowFC;
                if (arGameField[row = row == 0 ? 0 : row - 1][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }
            }
        } else if (colFC == colTC) {
            for (int i = Math.min(rowFC, rowTC); i <= Math.max(rowFC, rowTC); i++) {
                int row = i;
                int col = colFC;

                if (arGameField[i][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                if (arGameField[row][col = col == 9 ? 9 : col + 1].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                col = colFC;
                if (arGameField[row][col = col == 0 ? 0 : col - 1].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                col = colFC;
                if (arGameField[row = row == 9 ? 9 : row + 1][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }

                row = i;
                if (arGameField[row = row == 0 ? 0 : row - 1][col].equals("O")) {
                    isCloseToAShip = true;
                    break;
                }
            }
        }
        return isCloseToAShip;
    }
}
