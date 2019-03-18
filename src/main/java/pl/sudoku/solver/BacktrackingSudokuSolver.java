package pl.sudoku.solver;

import pl.sudoku.board.SudokuBoard;

public class BacktrackingSudokuSolver implements SudokuSolver {

    public void solve(SudokuBoard board) {
        clearBoard(board);



    }

    private void clearBoard(SudokuBoard board){
        for(int i = 0; i < 81; i++)
            board.set(i, i % 9, 0);
    }

    private boolean isPossible(SudokuBoard board, int x, int y, int num){
        for(int i = 0; i < 9; i++){
            if(num == board.get(i, y)) return false;
            if(num == board.get(x, i)) return false;
        }

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board.get(x / 3 * 3 + j, y / 3 * 3 + i) == num) return false;

        return true;
    }

    public static void main(String[] args){
        SudokuBoard sb = new SudokuBoard();
        BacktrackingSudokuSolver ss = new BacktrackingSudokuSolver();
        System.out.println(sb);
    }
}
