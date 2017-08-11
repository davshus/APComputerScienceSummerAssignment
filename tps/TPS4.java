package tps;
import java.util.Random;
public class TPS4 {
  public static void main(String[] args) {
    Random rand = new Random();
    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = rand.nextInt();
    }
    int[] doubleSize = new int[nums.length * 2];
    System.arraycopy(nums, 0, doubleSize, 0, nums.length);
    nums = doubleSize;
    System.out.println(nums.length);
    for (int n : nums) {
      System.out.println(n);
    }
    // Exception
    int err = nums[nums.length];
  }
}
