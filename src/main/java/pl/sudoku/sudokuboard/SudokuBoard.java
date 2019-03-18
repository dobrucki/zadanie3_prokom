package pl.sudoku.sudokuboard;

public class SudokuBoard {

    private final int[] board = new int[81];


    public int get(int x, int y){
        return board[y * 9 + x];
    }

    public void set(int x, int y, int num){
        board[y * 9 + x] = num;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <  81; i++){
            sb.append(board[i]);
            if (i % 9 == 8) sb.append("\n");
            else sb.append(", ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        SudokuBoard sb = new SudokuBoard();
        System.out.println(sb);
        sb.set(1, 2, 9);
        System.out.println(sb);
    }
}

