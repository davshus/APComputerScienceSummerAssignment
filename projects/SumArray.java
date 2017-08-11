package projects;
import java.util.Scanner;
public class SumArray {
  final static int ROWS = 5;
  final static int COLUMNS = 4;
  final static int SENTINEL = -999;
  public static void main(String[] args) {
    boolean[][] valuedIntegers = new boolean[ROWS][COLUMNS];
    boolean[][] valuedDoubles = new boolean[ROWS][COLUMNS];
    int[][] integers = new int[ROWS][COLUMNS];
    double[][] doubles = new double[ROWS][COLUMNS];

    System.out.println("INTS");
    int filledIntegers = fillMatrix(integers, valuedIntegers);
    int sumIntegers = sumMatrix(integers, valuedIntegers);
    System.out.println("SUM = " + sumIntegers);
    System.out.println("AVG = " + average(sumIntegers, filledIntegers) + " " + sumIntegers + "/" + filledIntegers);

    System.out.println("DOUBLES");
    int filledDoubles = fillMatrix(doubles, valuedDoubles);
    double sumDoubles = sumMatrix(doubles, valuedDoubles);
    System.out.println("SUM = " + sumDoubles);
    System.out.println("AVG = " + average(sumDoubles, filledDoubles) + " " + sumDoubles + "/" + filledDoubles);
  }
  public static int fillMatrix(int[][] mat, boolean[][] valued) {
    System.out.println("Enter -999 to stop.");
    Scanner sc = new Scanner(System.in);
    int filled = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        int curr = sc.nextInt();
        if (curr == SENTINEL)
          return filled;
        mat[i][j] = curr;
        valued[i][j] = true;
        filled++;
      }
    }
    return filled;
  }
  public static int fillMatrix(double[][] mat, boolean[][] valued) {
    System.out.println("Enter -999 to stop.");
    Scanner sc = new Scanner(System.in);
    int filled = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        double curr = sc.nextDouble();
        if (curr == SENTINEL)
          return filled;
        mat[i][j] = curr;
        valued[i][j] = true;
        filled++;
      }
    }
    return filled;
  }
  public static int sumMatrix(int[][] mat, boolean[][] valued) {
    int[] rows = new int[mat.length];
    int sum = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (valued[i][j]) {
          rows[i] += mat[i][j];
          sum += mat[i][j];
        } else {
          System.out.println("Row " + (i + 1) + " = " + rows[i]);
          return sum;
        }
      }
      System.out.println("Row " + (i + 1) + " = " + rows[i]);
    }
    return sum;
  }
  public static double sumMatrix(double[][] mat, boolean[][] valued) {
    double[] rows = new double[mat.length];
    double sum = 0;
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (valued[i][j]) {
          rows[i] += mat[i][j];
          sum += mat[i][j];
        } else {
          System.out.println("Row " + (i + 1) + " = " + rows[i]);
          return sum;
        }
      }
      System.out.println("Row " + (i + 1) + " = " + rows[i]);
    }
    return sum;
  }
  public static double average(int sum, int num) {
    return sum / (double) num;
  }
  public static double average(double sum, int num) {
    return sum / (double) num;
  }
}
