package labs;
public class ArraysPracticeLab {
  public static void main(String[] args) {
    int[] primitive = new int[10];
    StringBuffer[] mutable = new StringBuffer[10];
    String[] immutable = new String[10];
    System.out.println(primitive[0]);
    processPrimitive(primitive);
    System.out.println(primitive[0]);
    System.out.println(mutable[0]);
    processMutable(mutable);
    System.out.println(mutable[0]);
    System.out.println(immutable[0]);
    processImmutable(immutable);
    System.out.println(immutable[0]);

    System.out.println(primitive[0]);
    changeElement(primitive[0]);
    System.out.println(primitive[0]);
    System.out.println(mutable[0]);
    changeElement(mutable[0]);
    System.out.println(mutable[0]);
    System.out.println(immutable[0]);
    changeElement(immutable[0]);
    System.out.println(immutable[0]);
  }
  public static void processPrimitive(int[] arr) {
    arr[0] = 100;
  }
  public static void processMutable(StringBuffer[] arr) {
    arr[0] = new StringBuffer("test");
  }
  public static void processImmutable(String[] arr) {
    arr[0] = "meh";
  }
  public static void changeElement(int elem) {
    elem = 10;
  }
  public static void changeElement(StringBuffer elem) {
    elem.append(": StringBuffer mutated?");
  }
  public static void changeElement(String elem) {
    elem = "String mutated?";
  }
}
