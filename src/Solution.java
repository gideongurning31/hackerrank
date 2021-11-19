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

    String[] binarySpliced = binary.replace("1", "#1").split("#");

    for (int i = 0; i < binarySpliced.length - 1; i++) {
      if (!binarySpliced[i + 1].equals("0")) {
        System.out.println(binarySpliced[i]);
        setLongestGap(binarySpliced[i].length() - 1);
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
