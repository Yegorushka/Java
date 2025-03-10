import java.io.*;
import java.util.*;

public class Matrix_new {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        while (true) { // Цикл для запроса на повтор
            @SuppressWarnings("resource")
            Scanner in = new Scanner(System.in);
            File file = new File("Data.txt");
            
            try (PrintWriter pw = new PrintWriter(file)) { // Запись в файл
                System.out.println("Программа для вычисления обратной матрицы.");
                System.out.println("Используются только квадратные матрицы.");
                System.out.println("Данные хранятся в файле <-- Data.txt -->");
                System.out.print("Ввести матрицу вручную или использовать рандомайзер? [Y/N] --> ");
                
                String y_n = in.nextLine().toUpperCase();
                boolean isManualInput = y_n.startsWith("Y");
                boolean isRandom = y_n.startsWith("N");

                if (isManualInput || isRandom) {
                    float[][] matrix = new float[3][3];
                    
                    if (isManualInput) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print("Введите элемент A" + (i + 1) + (j + 1) + ": ");
                                matrix[i][j] = in.nextFloat();
                                pw.println("A" + (i + 1) + (j + 1) + " = " + matrix[i][j]);
                            }
                        }
                    } else { // Если выбран случайный ввод
                        Random rand = new Random();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                matrix[i][j] = rand.nextInt(9) + 1;
                            }
                        }
                    }
                    
                    System.out.println("\nВведенная матрица:");
                    for (float[] row : matrix) {
                        for (float elem : row) {
                            System.out.printf("%6.2f", elem);
                            pw.printf("%6.2f", elem);
                        }
                        System.out.println();
                        pw.println();
                    }
                    
                    float determinant = calculateDeterminant(matrix);
                    System.out.printf("\nОпределитель матрицы: %6.2f\n", determinant);
                    pw.printf("Определитель матрицы: %6.2f\n", determinant);
                    
                    if (determinant != 0) {
                        float[][] inverseMatrix = calculateInverseMatrix(matrix, determinant);
                        
                        System.out.println("\nОбратная матрица:");
                        for (float[] row : inverseMatrix) {
                            for (float elem : row) {
                                System.out.printf("%6.2f", elem);
                                pw.printf("%6.2f", elem);
                            }
                            System.out.println();
                            pw.println();
                        }
                    } else {
                        System.out.println("\nМатрица вырождена, обратной матрицы не существует.");
                        pw.println("Матрица вырождена, обратной матрицы не существует.");
                    }
                } else {
                    System.out.println("Неверный ввод. Повторите попытку.");
                    continue;
                }
                
                System.out.print("Хотите ли вы перезапустить код? [Y/N] --> ");
                if (!in.nextLine().toUpperCase().startsWith("Y")) {
                    break;
                }
            }
        }
    }

    // Функция для вычисления определителя 3x3
    private static float calculateDeterminant(float[][] matrix) {
        return matrix[0][0] * matrix[1][1] * matrix[2][2] +
               matrix[0][1] * matrix[1][2] * matrix[2][0] +
               matrix[0][2] * matrix[1][0] * matrix[2][1] -
               matrix[0][2] * matrix[1][1] * matrix[2][0] -
               matrix[0][1] * matrix[1][0] * matrix[2][2] -
               matrix[0][0] * matrix[1][2] * matrix[2][1];
    }

    // Функция для вычисления обратной матрицы
    private static float[][] calculateInverseMatrix(float[][] matrix, float determinant) {
        float[][] adjMatrix = new float[3][3];
        
        // Вычисление алгебраических дополнений
        adjMatrix[0][0] = (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2]);
        adjMatrix[0][1] = -(matrix[0][1] * matrix[2][2] - matrix[2][1] * matrix[0][2]);
        adjMatrix[0][2] = (matrix[0][1] * matrix[1][2] - matrix[1][1] * matrix[0][2]);
        
        adjMatrix[1][0] = -(matrix[1][0] * matrix[2][2] - matrix[2][0] * matrix[1][2]);
        adjMatrix[1][1] = (matrix[0][0] * matrix[2][2] - matrix[2][0] * matrix[0][2]);
        adjMatrix[1][2] = -(matrix[0][0] * matrix[1][2] - matrix[1][0] * matrix[0][2]);
        
        adjMatrix[2][0] = (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]);
        adjMatrix[2][1] = -(matrix[0][0] * matrix[2][1] - matrix[2][0] * matrix[0][1]);
        adjMatrix[2][2] = (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
        
        // Делим каждое значение на определитель
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                adjMatrix[i][j] /= determinant;
            }
        }
        return adjMatrix;
    }
}
