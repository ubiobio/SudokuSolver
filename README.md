SudokuSolver
===

Un programa para resolver sudokus 9x9 hecho en Java, implementando backtracking fundamental.

## Paquetes y clases
El proyecto tiene dos paquetes principales:
  * [sudoku](https://github.com/ubiobio/SudokuSolver/tree/master/src/cl/bgm/sudoku): Contiene clases relacionadas al juego "Sudoku".
    * [Cell](https://github.com/ubiobio/SudokuSolver/blob/master/src/cl/bgm/sudoku/Cell.java): Representa una celda en el tablero del sudoku.
    * [Sudoku](https://github.com/ubiobio/SudokuSolver/blob/master/src/cl/bgm/sudoku/Sudoku.java): Representa el sudoku como juego.
  * [util](https://github.com/ubiobio/SudokuSolver/tree/master/src/cl/bgm/util): Paquete utilitario.
    * [ConsoleUtil](https://github.com/ubiobio/SudokuSolver/blob/master/src/cl/bgm/util/ConsoleUtil.java): Provee métodos para leer desde consola.

## Compilación
Para compilar este proyecto, se recomienda utilizar cualquier IDE moderno. Por ejemplo, SodokuSolver fue desarrollado
utilizando  [IntelliJ IDEA](https://www.jetbrains.com/idea/). Desde este entorno puedes importar el proyecto y
ejecutarlo dentro del mismo.

Para compilar manualmente desde consola, muévete dentro del directorio `build/`, y ejecuta lo siguiente:
```sh
jar cmvf META-INF\MANIFEST.MF SudokuSolver.jar cl\bgm\*
```

Luego, para ejecutar el programa:
```sh
java -jar SudokuSolver.jar
```

## Uso
El programa puede utilizarse directamente desde la consola de comandos, en donde puedes escribir sudokus manualmente
llamando a la función `Sudoku.fromCommandLine()` de la siguiente forma:

### Input
```
0 0 3 0 0 0 0 0 0
0 0 0 0 5 0 0 0 0
0 0 0 0 0 0 4 0 0
0 0 0 0 0 0 0 0 0
0 2 0 0 0 0 0 0 0
0 0 0 0 0 0 0 4 0
0 0 0 0 0 0 0 0 0
0 0 0 0 7 0 0 0 0
0 0 0 0 0 0 0 0 0
```

### Output
```
X-----------------------X
| 1 4 3 | 2 6 7 | 5 8 9 |
| 2 6 8 | 4 5 9 | 1 3 7 |
| 5 7 9 | 1 3 8 | 4 2 6 |
|-----------------------|
| 3 1 4 | 5 2 6 | 7 9 8 |
| 6 2 7 | 8 9 4 | 3 1 5 |
| 8 9 5 | 7 1 3 | 6 4 2 |
|-----------------------|
| 4 3 2 | 6 8 5 | 9 7 1 |
| 9 5 1 | 3 7 2 | 8 6 4 |
| 7 8 6 | 9 4 1 | 2 5 3 |
X-----------------------X
```

O puede que quieras resolver un Sudoku representado por un array 2d clásico:
```java
public interface Boards {
    int[][] SAMPLE_1 = {
            {0, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
}
```

También puedes cargar un tablero de sudoku llamando la función `Sudoku.fromArray(tuArreglo2D)`. Esto retornará un
objeto `Sudoku`, listo para ser resuelto.
