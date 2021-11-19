import java.io.*;

public class Solution {

  private static int longestGap = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    for (String n : firstMultipleInput) {
      int value = Integer.parseInt(n);
      System.out.println("Result: ".concat(String.valueOf(longestBinaryGap(value))));
    }
  }

  private static int longestBinaryGap(int N) {
    String binary = Integer.toBinaryString(N);

    if (binary.length() <= 1) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < binary.length() - 1; i++) {
      for (int j = 1; j < binary.length(); j++) {
        int firstChar = binary.charAt(i) == 48 ? 0 : 1;
        int nextChar = binary.charAt(j) == 48 ? 0 : 1;

        if (firstChar == 0) {
          count = 0;
        } else {
          if (nextChar == 0) {
            count++;
          } else {
            setLongestGap(count);
            count = 0;
          }
        }
      }
    }

    return longestGap;
  }

  private static void setLongestGap(int gap) {
    if (longestGap < gap) {
      longestGap = gap;
    }
  }
}
