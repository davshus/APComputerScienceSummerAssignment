package projects.tictactoe;
public class Player {
  private boolean human;
  private char symbol;
  public Player(boolean human, char symbol) {
    this.human = human;
    this.symbol = symbol;
  }
  public boolean isHuman() {
    return human;
  }
  public char getSymbol() {
    return symbol;
  }
  public static int[] randomMove() {
    return new int[] {
      (int)(Math.random() * 3),
      (int)(Math.random() * 3)
    };
  }
}
