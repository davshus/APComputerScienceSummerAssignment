package projects.nim;
import java.awt.*;
import java.applet.*;
public class Stone {
  private int x;
  private int y;
  private int width;
  private int height;
  private Color color;
  private Rectangle rect;
  public Stone(int newX, int newY, int newWidth, int newHeight, Color newColor) {
    x = newX;
    y = newY;
    width = newWidth;
    height = newHeight;
    color = newColor;
    calcRectangle();
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }
  public Color getColor() {
    return color;
  }
  public Rectangle getRect() {
    return rect;
  }
  public void setX(int newX) {
    x = newX;
    calcRectangle();
  }
  public void setY(int newY) {
    y = newY;
    calcRectangle();
  }
  public void setWidth(int newWidth) {
    width = newWidth;
    calcRectangle();
  }
  public void setHeight(int newHeight) {
    height = newHeight;
    calcRectangle();
  }
  public void setColor(Color newColor) {
    color = newColor;
  }
  public void calcRectangle() {
    rect = new Rectangle(x, y, width, height);
  }
}
