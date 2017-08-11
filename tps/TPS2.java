package tps;
import java.awt.Color;
public class TPS2 {
  public static void main(String[] args) {
    Color nulls[] = new Color[10];
    Color rainbow[] = new Color[] {Color.red, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta};
    try {
      System.out.println(nulls[0].darker()); // This should throw an error.
    } catch (NullPointerException e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
    System.out.println(rainbow[0].darker());
  }
}
