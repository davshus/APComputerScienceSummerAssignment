package projects;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
public class SpellChecker {
  final static int RESULT_COUNT = 3;
  public static void main(String[] args) throws Exception {
    Scanner wordsSC = new Scanner(new File("bigwords.txt"));
    ArrayList<String> wordsAL = new ArrayList<String>();
    while (wordsSC.hasNext()) {
      wordsAL.add(wordsSC.nextLine());
    }
    Scanner sc = new Scanner(System.in);
    String[] words = wordsAL.toArray(new String[1]);
    while (true) {
      System.out.println("Please enter a word or QUIT.");
      String word = sc.nextLine();
      if (word.equals("QUIT")) break;
      word = word.toLowerCase();
      SpellCheckerResult[] results = new SpellCheckerResult[words.length];
      boolean found = false;
      for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word)) {
          found = true;
          break;
        }
        results[i] = new SpellCheckerResult(words[i], word);
      }
      if (found) {
        System.out.println("The word was spelled correctly.");
        System.out.println("Would you like to enter another word? yes/no");
        String response = sc.nextLine();
        if (response.equals("yes")) continue;
        else if (response.equals("no")) break;
        else {
          System.out.println("Assuming yes...");
          continue;
        }
      }
      Arrays.sort(results);
      // Gives user the top RESULT_COUNT results
      for (int i = 0; i < RESULT_COUNT; i++) {
        System.out.println("Did you mean " + results[i].getWord() + "? yes/no");
        String response = sc.nextLine();
        if (response.equals("yes")) break;
        else if (response.equals("no")) {
          if (i == RESULT_COUNT - 1) {
            System.out.println("No Good Match");
          }
        } else {
          System.out.println("Assuming yes...");
          break;
        }
      }
      System.out.println("Would you like to enter another word? yes/no");
      String response = sc.nextLine();
      if (response.equals("yes")) continue;
      else if (response.equals("no")) break;
      else {
        System.out.println("Assuming yes...");
        continue;
      }
    }
  }
  public static void reverse(SpellCheckerResult[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      SpellCheckerResult tmp = arr[i];
      arr[i] = arr[(arr.length - 1) - i];
      arr[(arr.length - 1) - i] = tmp;
    }
  }
  public static int levenshtein(String a, String b) {
    int m = a.length(), n = b.length();
    int[] arr0 = new int[n + 1];
    int[] arr1 = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
      arr0[i] = i;
    }

    for (int i = 0; i < m; i++) {
      arr1[0] = i + 1;
      for (int j = 0, substitutionCost = 0; j < n; j++) {
        if (a.charAt(i) == b.charAt(j)) substitutionCost = 0;
        else substitutionCost = 1;
        arr1[j + 1] = Math.min(Math.min(arr1[j] + 1, arr0[j + 1] + 1), arr0[j] + substitutionCost);
      }
      System.arraycopy(arr1, 0, arr0, 0, arr0.length);
    }
    return arr0[n];
  }
}
