package projects;
public class BigEZ {
  public static void main(String[] args) {
    int N = 1000;
    if (args.length > 0)
      N = Integer.parseInt(args[0]);
    int[] iterations = new int[N];
    for (int i = 0; i < N; i++) {
      int currIterationCount = 0;
      double sum = 0;
      while (sum <= 1) {
        double rand = Math.random();
        rand -= rand % 0.1;
        sum += rand;
        currIterationCount++;
      }
      iterations[i] = currIterationCount;
    }
    int iterationsSum = 0;
    for (int i : iterations) {
      iterationsSum += i;
    }
    System.out.println("Average iterations: " + ((double) iterationsSum / N));
  }
}
