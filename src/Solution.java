import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int x = Integer.parseInt(textInput[0]);
    int y = Integer.parseInt(textInput[1]);
    int d = Integer.parseInt(textInput[2]);

    System.out.println("Result: ".concat(String.valueOf(frogJump(x, y, d))));
  }

  private static int frogJump(int x, int y, int d) {
    int distance = y - x;
    int distanceRemainder = distance % d;
    int roundDistance = distance - distanceRemainder;
    int totalJumped = roundDistance / d;

    if (distanceRemainder > 0) {
      return totalJumped + 1;
    }

    return totalJumped;
  }

}
