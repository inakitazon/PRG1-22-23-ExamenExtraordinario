import java.util.Scanner;

public class Main {
    public static final int NUM_ROWS = 15;
    public static final int NUM_COLS = 10;
    private double[][] cells = new double[NUM_ROWS][NUM_COLS];

    private int currentRow = 0;
    private int currentCol = 0;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printCells();
            System.out.print("Introduce un comando (w/a/s/d para mover, f para salir, e para ingresar valor): ");
            String command = scanner.next();
            switch (command.toLowerCase()) {
                case "w":
                    if (currentRow > 0) {
                        currentRow--;
                    }
                    break;
                case "a":
                    if (currentCol > 0) {
                        currentCol--;
                    }
                    break;
                case "s":
                    if (currentRow < NUM_ROWS - 1) {
                        currentRow++;
                    }
                    break;
                case "d":
                    if (currentCol < NUM_COLS - 1) {
                        currentCol++;
                    }
                    break;
                case "e":
                    System.out.print("Introduce el valor: ");
                    double value = scanner.nextDouble();
                    // Ensure that the value only has up to 6 digits
                    value = value % 1_000_000;
                    cells[currentRow][currentCol] = value;
                    break;
                case "f":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando desconocido.");
                    break;
            }
        }
    }

    private void printCells() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (i == currentRow && j == currentCol) {
                    System.out.print("[" + (int) cells[i][j] + "]" + "\t");
                } else {
                    System.out.print((int) cells[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
