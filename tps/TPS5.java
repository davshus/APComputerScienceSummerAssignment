package tps;
public class TPS5 {
  public static void main(String[] args) {
    int n = 10;
    String[] str = new String[] {"to be changed", "won't be changed"};
    System.out.println("Before change()");
    System.out.println("n == " + n);
    System.out.println("str[0] == \"" + str[0] + "\"");
    change(n, str);
    System.out.println("After change()");
    System.out.println("n == " + n);
    System.out.println("str[0] == \"" + str[0] + "\"");
  }
  public static void change(int num, String[] arr) {
    num = 100;
    arr[0] = "changed";
  }
}
