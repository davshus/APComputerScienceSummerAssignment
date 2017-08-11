package tps;
public class TPS1 {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		String[] strs = new String[6];
		for (String s : strs) {
			System.out.println(s);
		}
		strs = new String[] {"meh", "cool", "name", "fox", "dog", "name"};
		for (String s : strs) {
			System.out.println(s);
		}
	}
}
