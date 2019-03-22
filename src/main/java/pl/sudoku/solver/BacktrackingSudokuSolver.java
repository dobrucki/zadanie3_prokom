package pl.sudoku.solver;

import pl.sudoku.board.SudokuBoard;

import java.util.*;

public class BacktrackingSudokuSolver implements SudokuSolver {

    private final Random rnd = new Random();

    private final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void solve(SudokuBoard board) {
        clearBoard(board);
//        board.set(0, 0, rnd.nextInt(9) + 1);
        solveR(board);
    }


    private boolean solveR(SudokuBoard board){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i, j) != 0) continue;
                ArrayList al = randomCollection();
                for (int num = 0; num < 9; num++){
                    if (isPossible(board, i, j, (Integer)al.get(num))){
                        board.set(i, j, (Integer)al.get(num));
                        if (solveR(board)) return true;
                        else board.set(i, j, 0);
                    }
                }
                return false;
            }
        }
        return true;
    }

    private void clearBoard(SudokuBoard board){
        for(int i = 0; i < 81; i++)
            board.set(i / 9, i % 9, 0);
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

    private ArrayList<Integer> randomCollection(){
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(numbers));
        Collections.shuffle(al);
        return al;
    }

    public static void main(String[] args){
        SudokuBoard sb = new SudokuBoard();
        BacktrackingSudokuSolver ss = new BacktrackingSudokuSolver();
        //System.out.println(ss.firstFree(sb));
        System.out.println(sb);
        ss.solve(sb);
        System.out.println(sb);
        System.out.println(sb.checkBoard());

    }
}
