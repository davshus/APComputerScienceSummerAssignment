package projects.nim;
import java.awt.*;
import java.applet.*;
public class Player {
  private boolean team;
  private Color color;
  private String teamName;
  public Player(boolean newTeam) {
    team = newTeam;
    color = team ? Color.blue : Color.red;
    teamName = team ? "blue" : "red";
  }
  public boolean getTeam() {
    return team;
  }
  public Color getColor() {
    return color;
  }
  public String getTeamName() {
    return teamName;
  }
  public void updateDisplay(Graphics g) {
    g.setColor(color);
    g.drawString("You are the " + teamName + " player.", 25, 475);
  }
}
