package pl.sudoku.board;

/**
 * This class represents sudoku game board.
 */
public class SudokuBoard {
    /**
     * Size of the board.
     */
    private final int size = 9;
    /**
     * Size of the square.
     */
    private final int squareSize = 3;
    /**
     * This array represents sudoku board, contains all the numbers.
     */
    private final int[] board = new int[size * size];

    /**
     * { @summary This method returns number standing in the given field. }
     * @param x x coordinate in the board
     * @param y y coordinate in the board
     * @return value of that field
     */
    public final int get(final int x, final int y) {
        return board[y * size + x];
    }

    /**
     * { @summary This method sets number in the given field. }
     * @param x x coordinate in the board
     * @param y y coordinate in the board
     * @param num number that will be set in that field
     */
    public final void set(final int x, final int y, final int num) {
        board[y * size + x] = num;
    }

    /**
     * { @summary This method checks if board is correctly solved. }
     * @return true if the board is correctly solved
     */
    public final boolean checkBoard() {

        for (int i = 0; i < size; i++) {
            int result1 = 0;
            int result2 = 0;
            int result3 = 0;

            // rows and columns check
            for (int j = 0; j < size; j++) {
                result1 |= 1 << (board[i * size + j] - 1);
                result2 |= 1 << (board[j * size + i] - 1);
            }

            if (result1 != (1 << size) - 1 || result2 != (1 << size) - 1) {
                return false;
            }

            // 3x3 squares check
            for (int j = 0; j < squareSize; j++) {
                for (int k = 0; k < squareSize; k++) {
                    result3 |= 1
                            << (board[(j + i / size * size)
                            * size + k + (i / squareSize) * squareSize] - 1);
                }
            }

            if (result3 != (1 << size) - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * { @summary This method return String representation of sudoku board. }
     * @return String representation of the sudoku board
     */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <  size << 1; i++) {
            sb.append(board[i]);
            if (i % size == size - 1) {
                sb.append("\n");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

