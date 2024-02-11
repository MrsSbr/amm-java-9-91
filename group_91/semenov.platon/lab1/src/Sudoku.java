import java.util.Set;
import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // Проверяем каждую строку, столбец и подсетку на наличие дубликатов
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubMatrix(board, i)) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки строки на наличие дубликатов
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '.' && !set.add(board[row][j])) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки столбца на наличие дубликатов
    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && !set.add(board[i][col])) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки подсетки 3x3 на наличие дубликатов
    private boolean isValidSubMatrix(char[][] board, int submatrix) {
        Set<Character> set = new HashSet<>();
        int rowOffset = (submatrix / 3) * 3;
        int colOffset = (submatrix % 3) * 3;
        for (int i = rowOffset; i < rowOffset + 3; i++) {
            for (int j = colOffset; j < colOffset + 3; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        char[][] matr = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','4','.','.','.','.','6','.'},
                {'5','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(s.isValidSudoku(matr));
    }
}