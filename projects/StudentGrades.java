package projects;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
public class StudentGrades {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("grades.txt"));
    Student[] students = new Student[25];
    int currentStudent = 0;
    int studentCount = 0;
    while (sc.hasNext()) {
      String name = sc.next();
      double[] grades = new double[5];
      for (int i = 0; i < 5; i++) {
        grades[i] = sc.nextDouble();
      }
      students[currentStudent] = new Student(name, grades);
      currentStudent++;
      studentCount++;
      if (studentCount > 25) {
        throw new Exception("Too many students. There cannot be more than 25.");
      }
    }

    // Truncate students
    Student[] bubbleSortStudents = new Student[studentCount];
    System.arraycopy(students, 0, bubbleSortStudents, 0, studentCount);
    Student[] javaSortStudents = new Student[studentCount];
    System.arraycopy(students, 0, javaSortStudents, 0, studentCount);

    Sort.bubbleSort(bubbleSortStudents);
    Sort.javaSort(javaSortStudents);

    System.out.println("Bubble Sort");
    for (Student s : bubbleSortStudents) {
      System.out.println(s.getName() + ": " + s.average());
    }

    System.out.println();

    System.out.println("Arrays.sort");
    for (Student s : javaSortStudents) {
      System.out.println(s.getName() + ": " + s.average());
    }
  }
}
