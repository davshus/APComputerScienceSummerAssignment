package tps;
import java.util.Arrays;
public class TPS9 {
  public static void main(String[] args) {
    int[] arr1 = new int[] {3, 4, 4, 6264, 42, -23, 45, 1, 55, 545, -3241, -31};
    String[] arr2 = new String[] {"Shustin", "David", "Farrell", "Keenan", "Miron"};
    System.out.println("Before sort()");
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    sort(arr1);
    sort(arr2);
    System.out.println("After sort()");
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
  }
  public static void sort(int[] v) {
    for (int c1 = 0; c1 < (v.length - 1); c1++) {
      for (int c2 = (c1 +1); c2 < v.length; c2++) {
        if (v[c1] > v[c2]) {
          int temp = v[c1];
          v[c1] = v[c2];
          v[c2] = temp;
        }
      }
    }
  }
  public static void sort(String[] v) {
    for (int c1 = 0; c1 < (v.length - 1); c1++) {
      for (int c2 = (c1 +1); c2 < v.length; c2++) {
        if (v[c1].compareTo(v[c2]) > 0) {
          String temp = v[c1];
          v[c1] = v[c2];
          v[c2] = temp;
        }
      }
    }
  }
}
