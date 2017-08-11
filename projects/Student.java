// Note: this class has a natural ordering that is inconsistent with equals.
package projects;
public class Student implements Comparable {
  private String name;
  private double[] grades;
  public Student() {
    name = "";
    grades = new double[5];
  }
  public Student(String newName, double[] newGrades) {
    name = newName;
    grades = newGrades;
  }
  public String getName() {
    return name;
  }
  public void setName(String newName) {
    name = newName;
  }
  public double[] getGrades() {
    return grades;
  }
  public void setGrades(double[] newGrades) {
    grades = newGrades;
  }
  public double average() {
    double sum = 0;
    for (double n : grades) {
      sum += n;
    }
    return sum / grades.length;
  }
  public int compareTo(Object otherObj) {
    Student other = (Student) otherObj;
    double myAvg = average(), otherAvg = other.average();
    if (Math.abs(myAvg - otherAvg) < 10e-7) {
      return 0;
    }
    if (myAvg > otherAvg) {
      return 1;
    }
    return -1;
  }
  public String toString() {
    String ans = name + ":";
    for (double grade : grades) {
      ans += " " + grade;
    }
    return ans;
  }
}
