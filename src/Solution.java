import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int[] input = new int[textInput.length];
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(textInput[i]);
    }

    System.out.println("Result: ".concat(String.valueOf(permMissingElement(input))));
  }

  private static int permMissingElement(int[] A) {
    int[] completeArr = new int[A.length + 1];

    for (int x : A) {
      completeArr[x - 1] = x;
    }

    for (int i = 0; i < completeArr.length; i++) {
      if (completeArr[i] == 0) {
        return i + 1;
      }
    }

    return 0;
  }

}
