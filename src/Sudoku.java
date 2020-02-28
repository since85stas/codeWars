import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Sudoku {
    /*Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid with digits from 1 to 9,
    so that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks) contain all of the digits from 1 to 9.
            (More info at: http://en.wikipedia.org/wiki/Sudoku)

    Sudoku Solution Validator
    Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board,
     and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's,
      which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.

    The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

    Examples
    validSolution([
                          [5, 3, 4, 6, 7, 8, 9, 1, 2],
                          [6, 7, 2, 1, 9, 5, 3, 4, 8],
                          [1, 9, 8, 3, 4, 2, 5, 6, 7],
                          [8, 5, 9, 7, 6, 1, 4, 2, 3],
                          [4, 2, 6, 8, 5, 3, 7, 9, 1],
                          [7, 1, 3, 9, 2, 4, 8, 5, 6],
                          [9, 6, 1, 5, 3, 7, 2, 8, 4],
                          [2, 8, 7, 4, 1, 9, 6, 3, 5],
                          [3, 4, 5, 2, 8, 6, 1, 7, 9]
                          ]);  => true
    validSolution([
                          [5, 3, 4, 6, 7, 8, 9, 1, 2],
                          [6, 7, 2, 1, 9, 0, 3, 4, 8],
                          [1, 0, 0, 3, 4, 2, 5, 6, 0],
                          [8, 5, 9, 7, 6, 1, 0, 2, 0],
                          [4, 2, 6, 8, 5, 3, 7, 9, 1],
                          [7, 1, 3, 9, 2, 4, 8, 5, 6],
                          [9, 0, 1, 5, 3, 7, 2, 1, 4],
                          [2, 8, 7, 4, 1, 9, 6, 3, 5],
                          [3, 0, 0, 4, 8, 1, 1, 7, 9]
                          ]);  => false */
    public static void main(String[] args) {
        check( new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 0, 3, 4, 8},
                {1, 0, 0, 3, 4, 2, 5, 6, 0},
                {8, 5, 9, 7, 6, 1, 0, 2, 0},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 0, 1, 5, 3, 7, 2, 1, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 0, 0, 4, 8, 1, 1, 7, 9}
                          });
    }

    public static boolean check(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            boolean b = checkLine(sudoku[i]);
            if (!b) return false;
        }

        for (int i = 0; i < 9; i++) {
            boolean b = checkLine(getColumn(sudoku,i));
            if (!b) return false;
        }

        int[] matr = new int[9];
        for (int k = 0; k < 3; k++) {
            int num=0;
            for (int j = (k*3) %10; j < (k*3+3)%10; j++) {
                for (int i = 0; i < 3; i++) {
                    matr[num] = sudoku[i][j];
                    ++num;
                }
            }
            boolean b = checkLine(matr);
            if (!b) return false;
        }

        matr = new int[9];
        for (int k = 0; k < 3; k++) {
            int num=0;
            for (int j = (k*3) %10; j < (k*3+3)%10; j++) {
                for (int i = 3; i < 6; i++) {
                    matr[num] = sudoku[i][j];
                    ++num;
                }
            }
            boolean b = checkLine(matr);
            if (!b) return false;
        }

        matr = new int[9];
        for (int k = 0; k < 3; k++) {
            int num=0;
            for (int j = (k*3) %10; j < (k*3+3)%10; j++) {
                for (int i = 6; i < 9; i++) {
                    matr[num] = sudoku[i][j];
                    ++num;
                }
            }
            boolean b = checkLine(matr);
            if (!b) return false;
        }

        return true;
    }

    public static boolean checkLine( int[] line) {
        String s = Arrays.stream(line).sorted().mapToObj(i -> String.valueOf(i)).reduce((s1,s2) -> s1+s2).toString();
        return s.equals("Optional[123456789]");
    }

    public  static int[] getColumn(int[][] matrix, int column) {
        return IntStream.range(0, matrix.length)
                .map(i -> matrix[i][column]).toArray();
    }


        public static boolean check2(int[][] sudoku) {
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    for (int i2 = 0; i2 < sudoku.length; i2++) {
                        for (int j2 = 0; j2 < sudoku.length; j2++) {
                            if(sudoku[i][j]==0)
                                return false;
                            if(i==i2 && j==j2)
                                continue;
                            if(sudoku[i][j]==sudoku[i2][j2])
                                if (i/3==i2/3 && j/3==j2/3 || i==i2 || j==j2)
                                    return false;
                        }
                    }
                }
            }
            return true;
        }
}
