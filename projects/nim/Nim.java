package projects.nim;
import java.util.Stack;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Nim extends Applet implements MouseListener {
  Player bluePlayer, redPlayer, currentPlayer;
  Stack<Stone>[] stacks;
  final int STACK_LENGTH = 3;
  final int[] STACK_SIZES = new int[] {3, 5, 8};
  final Color[] STACK_COLORS = new Color[] {Color.red, Color.green, Color.blue};
  final int[] STACK_LOCATIONS = new int[] {30, 190, 350};
  final int STACK_WIDTH = 100;
  final Rectangle nextButton = new Rectangle(10, 10, 75, 50);
  boolean gameOver;
  Player winner;
  int lockedStack;
  @SuppressWarnings("unchecked")
  public void init() {
    addMouseListener(this);
    gameOver = false;
    lockedStack = -1;
    setBackground(Color.white);
    bluePlayer = new Player(true);
    redPlayer = new Player(false);
    currentPlayer = bluePlayer;
    stacks = (Stack<Stone>[])new Stack[3];
    for (int i = 0; i < stacks.length; i++) {
      stacks[i] = new Stack<Stone>();
      for (int j = 0; j < STACK_SIZES[i]; j++) {
        int currY = 400 - (45 * j);
        stacks[i].push(new Stone(STACK_LOCATIONS[i], currY, STACK_WIDTH, 30, STACK_COLORS[i]));
      }
    }
  }
  public void paint(Graphics g) {
    if (gameOver) {
      g.setColor(winner.getColor());
      g.drawString("The " + winner.getTeamName() + " player wins!", 200, 250);
      return;
    }
    currentPlayer.updateDisplay(g);
    boolean empty = true;
    for (Stack<Stone> stack : stacks) {
      empty = empty && stack.empty();
      for (Stone stone : stack) {
        g.setColor(stone.getColor());
        g.drawRect(stone.getX(), stone.getY(), stone.getWidth(), stone.getHeight());
        g.fillRect(stone.getX(), stone.getY(), stone.getWidth(), stone.getHeight());
      }
    }
    g.setColor(Color.magenta);
    g.drawRect((int)nextButton.getX(), (int)nextButton.getY(), (int)nextButton.getWidth(), (int)nextButton.getHeight());
    g.fillRect((int)nextButton.getX(), (int)nextButton.getY(), (int)nextButton.getWidth(), (int)nextButton.getHeight());
    g.setColor(Color.white);
    g.drawString("NEXT TURN", (int)nextButton.getX() + 5, (int)(nextButton.getY() + nextButton.getHeight()/2 + 2));
    if (empty) endGame();
  }
  private Stone selectedStone(int x, int y) {
    for (Stack<Stone> stack : stacks) {
      for (Stone stone : stack) {
        if (stone.getRect().contains(x, y)) return stone;
      }
    }
    return null;
  }
  private Stack<Stone> selectedStack(int x, int y) {
    for (Stack<Stone> stack : stacks) {
      if (!stack.empty() && stack.peek().getRect().contains(x,y)) return stack;
    }
    return null;
  }
  private Player otherPlayer() {
    return currentPlayer == bluePlayer ? redPlayer : bluePlayer;
  }
  private void nextTurn() {
    lockedStack = -1;
    currentPlayer = otherPlayer();
    repaint();
  }
  private boolean removeFromStack(int n) {
    if (lockedStack < 0) lockedStack = n;
    if (lockedStack == n) stacks[n].pop();
    return lockedStack == n;
  }
  private void endGame() {
    gameOver = true;
    winner = otherPlayer();
    repaint();
  }
  public void mouseClicked(MouseEvent e)
  {
    Stack<Stone> s = selectedStack(e.getX(), e.getY());
    if (s != null) {
      int i = 0;
      for (i = 0; i < stacks.length; i++) {
        if (stacks[i] == s) break;
      }
      removeFromStack(i);
      repaint();
    } else if (nextButton.contains(e.getX(), e.getY())) {
      nextTurn();
      repaint();
    }
  }
  //Necessary Mouse events:
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
