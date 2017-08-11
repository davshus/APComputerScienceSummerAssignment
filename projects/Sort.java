package projects;
import java.util.Arrays;
public class Sort {
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < (arr.length - 1); i++) {
      for (int j = (i +1); j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
  public static void bubbleSort(double[] arr) {
    for (int i = 0; i < (arr.length - 1); i++) {
      for (int j = (i +1); j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          double temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
  public static void bubbleSort(Comparable[] arr) {
    for (int i = 0; i < (arr.length - 1); i++) {
      for (int j = (i +1); j < arr.length; j++) {
        if (arr[i].compareTo(arr[j]) > 0) {
          Comparable temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
  public static void javaSort(int[] arr) {
    Arrays.sort(arr);
  }
  public static void javaSort(double[] arr) {
    Arrays.sort(arr);
  }
  public static void javaSort(Comparable[] arr) {
    Arrays.sort(arr);
  }
}
