package projects;
import java.util.Scanner;
import java.io.File;
public class SortComparison {
  public static void main(String[] args) throws Exception {
    Scanner ints = new Scanner(new File("bigints.txt"));
    Scanner doubles = new Scanner(new File("bigdoubles.txt"));
    Scanner grades = new Scanner(new File("biggrades.txt"));
    int[] bubbleIntsArr = new int[10000];
    double[] bubbleDoublesArr = new double[10000];
    Student[] bubbleGradesArr = new Student[10000];
    int[] javaIntsArr = new int[10000];
    double[] javaDoublesArr = new double[10000];
    Student[] javaGradesArr = new Student[10000];
    for (int i = 0; i < 10000; i++) {
      int intstmp = ints.nextInt();
      double doublestmp = doubles.nextDouble();
      String nametmp = grades.next();
      double[] gradestmp = new double[5];
      for (int j = 0; j < 5; j++) {
        gradestmp[j] = grades.nextDouble();
      }
      Student studenttmp = new Student(nametmp, gradestmp);
      bubbleIntsArr[i] = intstmp;
      javaIntsArr[i] = intstmp;
      bubbleDoublesArr[i] = doublestmp;
      javaDoublesArr[i] = doublestmp;
      bubbleGradesArr[i] = studenttmp;
      javaGradesArr[i] = studenttmp;
    }
    long
      start,
      end,
      bubbleIntsTime,
      bubbleDoublesTime,
      bubbleGradesTime,
      javaIntsTime,
      javaDoublesTime,
      javaGradesTime;

    start = System.currentTimeMillis();
    Sort.bubbleSort(bubbleIntsArr);
    end = System.currentTimeMillis();
    bubbleIntsTime = end - start;
    start = System.currentTimeMillis();
    Sort.javaSort(javaIntsArr);
    end = System.currentTimeMillis();
    javaIntsTime = end - start;

    start = System.currentTimeMillis();
    Sort.bubbleSort(bubbleDoublesArr);
    end = System.currentTimeMillis();
    bubbleDoublesTime = end - start;
    start = System.currentTimeMillis();
    Sort.javaSort(javaDoublesArr);
    end = System.currentTimeMillis();
    javaDoublesTime = end - start;

    start = System.currentTimeMillis();
    Sort.bubbleSort(bubbleGradesArr);
    end = System.currentTimeMillis();
    bubbleGradesTime = end - start;
    start = System.currentTimeMillis();
    Sort.javaSort(javaGradesArr);
    end = System.currentTimeMillis();
    javaGradesTime = end - start;

    System.out.println("TEST 1: Integers");
    System.out.println("Bubble: " + bubbleIntsTime + "ms");
    System.out.println("Java: " + javaIntsTime + "ms");
    System.out.print(bubbleIntsTime > javaIntsTime ? "Java" : "Bubble");
    System.out.println(" wins!");
    System.out.println();

    System.out.println("TEST 2: Doubles");
    System.out.println("Bubble: " + bubbleDoublesTime + "ms");
    System.out.println("Java: " + javaDoublesTime + "ms");
    System.out.print(bubbleDoublesTime > javaDoublesTime ? "Java" : "Bubble");
    System.out.println(" wins!");
    System.out.println();

    System.out.println("TEST 3: Students/Grade Averages");
    System.out.println("Bubble: " + bubbleGradesTime + "ms");
    System.out.println("Java: " + javaGradesTime + "ms");
    System.out.print(bubbleGradesTime > javaGradesTime ? "Java" : "Bubble");
    System.out.println(" wins!");
    System.out.println();
  }
}
