package tps;
public class TPS3 {
	//USAGE: Put random arguments after java tps.TPS3
	public static void main(String[] args) {
		String[] other = new String[args.length * 2];
		for (int i = 0; i < args.length; i++) {
			other[i] = args[i];
		}
		args = other;
		System.out.println(args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
