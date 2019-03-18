package pl.sudoku.sudokuboard;

public class SudokuBoard {

    //private final int[] board = new int[81];
    private final int[] board = {
            2, 3, 9, 7, 1, 8, 5, 6, 4,
            4, 1, 5, 2, 6, 9, 7, 3, 8,
            7, 8, 6, 5, 3, 4, 1, 2, 9,
            6, 9, 1, 8, 4, 3, 2, 7, 5,
            8, 5, 7, 1, 2, 6, 9, 4, 3,
            3, 2, 4, 9, 5, 7, 8, 1, 6,
            9, 7, 3, 6, 8, 2, 4, 5, 1,
            5, 6, 2, 4, 9, 1, 3, 8, 7,
            1, 4, 8, 3, 7, 5, 6, 9, 2
    };


    public int get(int x, int y){
        return board[y * 9 + x];
    }

    public void set(int x, int y, int num){
        board[y * 9 + x] = num;
    }

    public boolean checkBoard(){

        for(int i = 0; i < 9; i++){
            int result1 = 0;
            int result2 = 0;
            int result3 = 0;

            // rows and columns check
            for(int j = 0; j < 9; j++){
                result1 |= 1 << (board[i * 9 + j] - 1);
                result2 |= 1 << (board[j * 9 + i] - 1);
            }

            if(result1 != 511 || result2 != 511) return false;


            // 3x3 squares check
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    result3 |= 1 << (board[(j + i / 27 * 3)* 9 + k + (i / 3) * 3] - 1);

            if(result3 != 511) return false;

        }

        return true;
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
//        System.out.println(sb);
//        sb.set(1, 2, 9);
        System.out.println(sb);
        System.out.println(sb.checkBoard());
    }
}

