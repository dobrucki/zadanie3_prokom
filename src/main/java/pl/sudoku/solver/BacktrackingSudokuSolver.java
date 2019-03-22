package pl.sudoku.solver;

import pl.sudoku.board.SudokuBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * This class implements Backtracking algorithm for solving sudoku.
 * @author Jędrzej Dobrucki
 */
public class BacktrackingSudokuSolver implements SudokuSolver {

    /**
     * Contains possible numbers for sudoku board.
     */
    private final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * The aSIZE of sudoku board.
     */
    private final int aSIZE = 9;

    /**
     * The bSIZE of sudoku board.
     */
    private final int bSIZE = 3;

    /**
     * @param board The Sudoku board object reference
     */
    public final void solve(final SudokuBoard board) {
        clearBoard(board);
        solveR(board);
    }

    /**
     * @param board The Sudoku board object reference
     * @return boolean value
     */
    private boolean solveR(final SudokuBoard board) {
        for (int i = 0; i < aSIZE; i++) {
            for (int j = 0; j < aSIZE; j++) {
                if (board.get(i, j) != 0) {
                    continue;
                }
                ArrayList al = randomCollection();
                for (int num = 0; num < aSIZE; num++) {
                    if (isPossible(board, i, j, (Integer) al.get(num))) {
                        board.set(i, j, (Integer) al.get(num));
                        if (solveR(board)) {
                            return true;
                        } else {
                            board.set(i, j, 0);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }


    /**
     * @param board The sudoku board reference
     */
    private void clearBoard(final SudokuBoard board) {
        for (int i = 0; i < aSIZE * aSIZE; i++) {
            board.set(i / aSIZE, i % aSIZE, 0);
        }
    }

    /**
     * @param board The sudoku board reference
     * @param x x-coordinate in board
     * @param y y-coordinate in board
     * @param num value to test if possible
     * @return true if possible, else false
     */
    private boolean isPossible(
            final SudokuBoard board, final int x, final int y, final int num
    ) {
        for (int i = 0; i < aSIZE; i++) {
            if (num == board.get(i, y)) {
                return false;
            }
            if (num == board.get(x, i)) {
                return false;
            }
        }
        for (int i = 0; i < bSIZE; i++) {
            for (int j = 0; j < bSIZE; j++) {
                if (board.get(x / aSIZE + j, y / aSIZE + i) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return collection of @numbers in random sequence
     */
    private ArrayList<Integer> randomCollection() {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(numbers));
        Collections.shuffle(al);
        return al;
    }
}
