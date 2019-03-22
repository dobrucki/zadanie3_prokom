package pl.sudoku.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import pl.sudoku.board.SudokuBoard;

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
     * The size of sudoku board.
     */
    private final int size = 9;

    /**
     * The squareSize of sudoku board.
     */
    private final int squareSize = 3;

    /**{ @summary This method solves given SudokuBoard. }
     * @param board The Sudoku board object reference
     */
    public final void solve(final SudokuBoard board) {
        //clearBoard(board);
        solveR(board);
    }

    /**
     * { @summary This method is recursive implementation of backtracking algorithm. }
     * @param board The Sudoku board object reference
     * @return boolean value
     */
    private boolean solveR(final SudokuBoard board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i, j) != 0) {
                    continue;
                }
                ArrayList al = randomCollection();
                for (int num = 0; num < size; num++) {
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
     * { @summary This method clears given SudokuBoard (sets all fields to 0). }
     * @param board The sudoku board reference
     */
    private void clearBoard(final SudokuBoard board) {
        for (int i = 0; i < size * size; i++) {
            board.set(i / size, i % size, 0);
        }
    }

    /**
     * { @summary This method checks if it is possible to insert given number into board. }
     * @param board The sudoku board reference
     * @param x x-coordinate in board
     * @param y y-coordinate in board
     * @param num value to test if possible
     * @return true if possible, else false
     */
    private boolean isPossible(
            final SudokuBoard board, final int x, final int y, final int num
    ) {
        for (int i = 0; i < size; i++) {
            if (num == board.get(i, y)) {
                return false;
            }
            if (num == board.get(x, i)) {
                return false;
            }
        }
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                if (board.get(x / size + j, y / size + i) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * { @summary This method generates collection of randomly sequenced numbers. }
     * @return collection of @numbers in random sequence
     */
    private ArrayList<Integer> randomCollection() {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(numbers));
        Collections.shuffle(al);
        return al;
    }
}
