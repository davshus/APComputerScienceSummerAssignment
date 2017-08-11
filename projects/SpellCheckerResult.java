package projects;
//IMMUTABLE
public class SpellCheckerResult implements Comparable {
  private String target;
  private int distance;
  private String word;
  public SpellCheckerResult(String newWord, String newTarget) {
    word = newWord;
    target = newTarget;
    distance = SpellChecker.levenshtein(word, target);
  }
  public String getTarget() {
    return target;
  }
  public String getWord() {
    return word;
  }
  public int getDistance() {
    return distance;
  }
  public int compareTo(Object otherObj) {
    SpellCheckerResult other = (SpellCheckerResult) otherObj;
    if (distance == other.getDistance()) return 0;
    if (distance > other.getDistance()) return 1;
    return -1;
  }
  public String toString() {
    return target + " -> " + word + ": " + distance;
  }
}
