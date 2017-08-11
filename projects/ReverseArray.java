package projects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class ReverseArray {
  final static int SENTINEL = -999;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter -999 to stop.");
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (true) {
      int tmp = sc.nextInt();
      if (tmp == SENTINEL) break;
      list.add(new Integer(tmp));
    }
    Integer[] arr = list.toArray(new Integer[1]);
    System.out.println("Normal: " + Arrays.toString(arr));
    for (int i = 0; i < arr.length/2; i++) {
      Integer tmp = arr[i];
      arr[i] = arr[(arr.length - 1) - i];
      arr[(arr.length - 1) - i] = tmp;
    }
    System.out.println("Reversed: " + Arrays.toString(arr));
  }
}
