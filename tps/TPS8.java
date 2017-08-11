package tps;
public class TPS8 {
  public static void main(String[] args) {
    int[][] graph = new int[3][3];
    graph[0][0] = 1;
    graph[0][1] = 2;
    graph[0][2] = 3;
    graph[1][0] = 4;
    graph[1][1] = 5;
    graph[1][2] = 6;
    graph[2][0] = 7;
    graph[2][1] = 8;
    graph[2][2] = 9;
    for (int[] col : graph) {
      for (int point : col) {
        System.out.print(" " + point);
      }
      System.out.println();
    }
  }
}
