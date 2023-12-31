package cl.bgm;

import cl.bgm.sudoku.Sudoku;

public class SudokuSolver {

    public static void main(String[] args) {
        // Sudoku sudoku = Sudoku.fromCommandLine();
        Sudoku sudoku = Sudoku.fromArray(Boards.SAMPLE_1);
        if (sudoku == null) return;

        System.out.println();
        System.out.println("Sudoku:");
        System.out.println(sudoku);
        System.out.println();

        System.out.println("Solución:");
        sudoku.solve();
        if (!sudoku.isSolved()) {
            System.out.println("Este tablero no tiene solución!");
        }
    }
}
