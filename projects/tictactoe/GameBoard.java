package projects.tictactoe;
public class GameBoard {
  // 0 = empty
  // 1 = X
  // 2 = O
  private int[][] board;
  public GameBoard() {
    board = new int[3][3];
  }
  public int[][] getBoard() {
    return board;
  }
  // Returns true if valid move and move was made, false otherwise
  public boolean makeMove(String input, Player p) {
    if (!validateHumanInput(input)) return false;
    return makeMove(computeHumanInput(input), p);
  }
  // Precondition: coordinates are valid
  public boolean makeMove(int[] coords, Player p) {
    return makeMove(coords[0], coords[1], p);
  }
  //Precondition: x and y are valid
  public boolean makeMove(int x, int y, Player p) {
    char symbol = p.getSymbol();
    int num = 0;
    switch (p.getSymbol()) {
      case 'X':
        num = 1;
        break;
      case 'O':
        num = 2;
        break;
    }
    if (board[x][y] > 0) return false;
    board[x][y] = num;
    return true;
  }
  //Returns winning symbol if there is a winner, - if draw, 0 otherwise
  public char calcWinner() {
    boolean isEmptySpace = false;
    int winnerDiagDown = board[0][0], winnerDiagUp = board[0][board.length - 1];
    for (int i = 0; i < board.length; i++) {
      int winnerVert = board[i][0], winnerHoriz = board[0][i];
      for (int j = 0; j < board[0].length; j++) {
        winnerVert = winnerVert == board[i][j] ? winnerVert : 0;
        winnerHoriz = winnerHoriz == board[j][i] ? winnerHoriz : 0;
        isEmptySpace = isEmptySpace || board[i][j] == 0;
      }
      if (winnerVert != 0) return parseNum(winnerVert);
      if (winnerHoriz != 0) return parseNum(winnerHoriz);
      winnerDiagDown = winnerDiagDown == board[i][i] ? winnerDiagDown : 0;
      winnerDiagUp = winnerDiagUp == board[i][(board.length - 1) - i] ? winnerDiagUp : 0;
    }
    if (winnerDiagDown != 0) return parseNum(winnerDiagDown);
    if (winnerDiagUp != 0) return parseNum(winnerDiagUp);
    if (!isEmptySpace) return '-';
    return 0;
  }
  private boolean validateHumanInput(String input) {
    if (input.length() != 2) return false;
    char[] pair = input.toUpperCase().toCharArray();
    if (pair[0] >= 'A' && pair[0] <= 'C') {
      //Swap order of pair
      char tmp = pair[0];
      pair[0] = pair[1];
      pair[1] = tmp;
    }
    // Pair is now in either format {1,2,3}{A,B,C} OR invalid
    // Check for validity
    return pair[0] >= '1' && pair[0] <= '3' && pair[1] >= 'A' && pair[1] <= 'C';
  }
  // VALIDATE HUMAN INPUT FIRST
  private int[] computeHumanInput(String input) {
    char[] pair = input.toUpperCase().toCharArray();
    if (pair[0] >= 'A' && pair[0] <= 'C') {
      //Swap order of pair
      char tmp = pair[0];
      pair[0] = pair[1];
      pair[1] = tmp;
    }
    int[] ans = new int[2];
    char num = pair[0], letter = pair[1];
    ans[0] = num - '1';
    ans[1] = letter - 'A';
    return ans;
  }
  public char[][] parseBoard() {
    char[][] ans = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        ans[i][j] = parseNum(board[i][j]);
      }
    }
    return ans;
  }
  public static char parseNum(int n) {
    switch(n) {
      case 0:
        return ' ';
      case 1:
        return 'X';
      case 2:
        return 'O';
      default:
        System.err.println("An error occurred... Check GameBoard.parseNum(int n)");
        return 0;
    }
  }
  public String toString() {
    char[][] inter = parseBoard();
    return "   1   2   3\n" +
    "     |   |   \n" +
    "A  " + inter[0][0] + " | " + inter[1][0] + " | " + inter[2][0] + " \n" +
    "  ___|___|___\n" +
    "     |   |   \n" +
    "B  " + inter[0][1] + " | " + inter[1][1] + " | " + inter[2][1] + " \n" +
    "  ___|___|___\n" +
    "     |   |   \n" +
    "C  " + inter[0][2] + " | " + inter[1][2] + " | " + inter[2][2] + " \n" +
    "     |   |   ";
  }
}
