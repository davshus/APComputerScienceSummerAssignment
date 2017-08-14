package projects.tictactoe;
import java.util.Scanner;
public class TicTacToe {
  private static Player human, computer, currentPlayer, winner;
  private static GameBoard board;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    board = new GameBoard();
    human = new Player(true, 'O');
    computer = new Player(false, 'X');
    currentPlayer = computer;
    printRules();
    String readyToContinue = sc.next().toLowerCase();
    if (readyToContinue.equals("no")) return;
    else if (!readyToContinue.equals("yes")) System.out.println("Assuming yes...");
    boolean done = false;
    while (!done) {
      if (currentPlayer.isHuman()) {
        String move = null;
        printDivider();
        printBoard();
        do {
          System.out.print("Please enter a valid move: ");
          move = sc.next();
        } while (!board.makeMove(move, currentPlayer));
      } else {
        System.out.println("Computer is moving...");
        while (!board.makeMove(Player.randomMove(), currentPlayer));
      }
      char winnerSymbol = board.calcWinner();
      if (winnerSymbol == 0) {
        nextTurn();
        continue;
      }
      boolean draw = false;
      if (winnerSymbol == '-') draw = true;
      else if (winnerSymbol == human.getSymbol()) winner = human;
      else winner = computer;
      printDivider();
      printBoard();
      System.out.println(draw ? "There was a draw." : (winner.isHuman() ? "You win!" : "CPU wins..."));
      System.out.println("Would you like to play again? YES/no");
      String playAgain = sc.next().toLowerCase();
      if (playAgain.equals("no")) done = true;
      else if (!playAgain.equals("yes")) System.out.println("Assuming yes...");
      nextGame();
    }
  }
  private static void nextTurn() {
    currentPlayer = currentPlayer == human ? computer : human;
  }
  private static void nextGame() {
    if (human.getSymbol() == 'X') {
      human = new Player(true, 'O');
      computer = new Player(false, 'X');
      currentPlayer = computer;
    } else {
      human = new Player(true, 'X');
      computer = new Player(false, 'O');
      currentPlayer = human;
    }
    board = new GameBoard();
    winner = null;
  }
  private static void printRules() {
    String rules = "Welcome to Tic-Tac-Toe!\n" +
                  "There are two players.\n" +
                  "\t* X - moves first\n" +
                  "\t* O - moves last\n" +
                  "The computer starts as X, but the players alternate each game.\n" +
                  "Every turn will display a game board, like this example.\n" +
                  "\n" +
                  "   1   2   3 \n" +
                  "     |   |   \n" +
                  "A  X | O | X \n" +
                  "  ___|___|___\n" +
                  "     |   |   \n" +
                  "B  O | X | O \n" +
                  "  ___|___|___\n" +
                  "     |   |   \n" +
                  "C  X | O | X \n" +
                  "     |   |   \n" +
                  "\n" +
                  "You and the computer will alternate making moves.  You can input your moves using coordinates such as:\n" +
                  "\t* 1A\n" +
                  "\t* 3C\n" +
                  "\t* B2\n" +
                  "\t* A1\n" +
                  "\n" +
                  "Are you ready to continue? YES/no";
    System.out.println(rules);
  }
  private static void printDivider() {
    System.out.println("---------------------------------------------------------");
  }
  public static void printBoard() {
    System.out.println(board);
  }
}
