import java.io.*;
import java.util.Arrays;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int k = Integer.parseInt(textInput[1]);
    String[] arrayInput = textInput[0].split(",");
    int[] input = new int[arrayInput.length];
    for (int i = 0; i < arrayInput.length; i++) {
      input[i] = Integer.parseInt(arrayInput[i]);
    }

    System.out.println("Result: ".concat(Arrays.toString(arrayRotation(input, k))));
  }

  private static int[] result;

  private static int[] arrayRotation(int[] arr, int K) {
    result = arr;

    if (arr.length == 0) {
      return arr;
    }

    while (K != 0) {
      rotateOnce();
      K--;
    }

    return result;
  }

  private static void rotateOnce() {
    int n = result.length;
    final int nthValue = result[n - 1];
    System.arraycopy(result, 0, result, 1, n - 1);
    result[0] = nthValue;
  }
}
