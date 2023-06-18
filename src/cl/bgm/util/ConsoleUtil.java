package cl.bgm.util;

import cl.bgm.sudoku.Cell;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ConsoleUtil {

    public static void printSudokuInputInstructions() {
        System.out.println("Ingresa las celdas vacías/números de tu tablero de sudoku 9x9:");
        System.out.println("- Para representar una celda vacía usa un '0'.");
        System.out.println("- Separa cada celda con un espacio.");
        System.out.println("- Debes proveer 9 números por fila.");
        System.out.println("- Para ingresar una fila y comenzar a escribir la siguiente presiona enter.");
        System.out.println();
    }

    public static Cell[][] readSudokuGrid() {
        ConsoleUtil.printSudokuInputInstructions();

        Cell[][] grid = new Cell[9][9];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = readSudokuRow(i);
        }

        return grid;
    }

    private static Cell[] readSudokuRow(int rowNumber) {
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();

        String[] numberStrings = new String[0];
        try {
            numberStrings = row.split(" ");
        } catch (PatternSyntaxException e) {
            System.out.println("La fila ingresada es inválida. Sigue las instrucciones.");
            readSudokuRow(rowNumber);
        }

        if (numberStrings.length != 9) {
            System.out.println("La fila ingresada contiene una cantidad de números inválida. Deben ser 9.");
            readSudokuRow(rowNumber);
        }

        Cell[] cells = new Cell[9];
        int j = 0;
        for (String numberString : numberStrings) {
            int number = ConsoleUtil.parseSudokuNumber(numberString);
            if (number == -1) {
                System.out.println("Valor inválido detectado: " + numberString + ". Ingresa la fila de nuevo.");
                readSudokuRow(rowNumber);
            }

            Cell cell = new Cell(rowNumber, j, number);
            cells[j] = cell;
            j++;
        }

        return cells;
    }

    private static int parseSudokuNumber(String numberString) {
        int number = -1;
        try {
            number = Integer.parseInt(numberString);
            if (number < 0 || number > 9) {
                number = -1;
            }
        } catch (NumberFormatException ignore) {
        }

        return number;
    }
}
