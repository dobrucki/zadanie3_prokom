package pl.sudoku.solver;

import pl.sudoku.board.SudokuBoard;


/**
 * Basic interface for different Sudoku solver classes.
 * @author Jędrzej Dobrucki
 */
public interface SudokuSolver {

    /**
     * { @summary This method solves given SudokuBoard.
     * @param board The Sudoku board object reference }
     */
    void solve(SudokuBoard board);
}
