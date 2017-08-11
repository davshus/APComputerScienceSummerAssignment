package tps;
public class TPS6 {
  public static void main(String[] args) {
    String[] strs = new String[] {"Not MMMM", "Not MMMM"};
    System.out.println("Before change()");
    System.out.println("strs[0] == " + strs[0]);
    System.out.println("strs[1] == " + strs[1]);
    change(strs, strs[1]);
    System.out.println("After change()");
    System.out.println("strs[0] == " + strs[0]);
    System.out.println("strs[1] == " + strs[1]);
    String[] num = new String[] {"MMMM", "MMMM"};
    nullify(num);
    //EXCEPTION
    System.out.println(num[0].substring(0, 1));
  }
  public static void change(String[] arr, String elem) {
    arr[0] = "MMMM";
    elem = "MMMM";
  }
  public static void nullify(String[] arr) {
    arr[0] = null;
  }
}
