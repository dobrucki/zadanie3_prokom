package pl.sudoku.solver;

import pl.sudoku.board.SudokuBoard;


/**
 * Basic interface for different Sudoku solver classes.
 * @author Jędrzej Dobrucki
 */
public interface SudokuSolver {

    /**
     * @param board The Sudoku board object reference
     */
    void solve(SudokuBoard board);
}
