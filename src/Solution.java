import java.io.*;

class Result {

  private static boolean isKaprekar(long x) {
    String sqrString = String.valueOf(x * x);
    if (sqrString.length() <= 1) {
      sqrString = "0".concat(sqrString);
    }

    int L = sqrString.length();
    String[] v = {sqrString.substring(0, L / 2), sqrString.substring(L / 2)};
    return Long.parseLong(v[0]) + Long.parseLong(v[1]) == x;
  }

  public static String kaprekarNumbers(int p, int q) {
    StringBuilder result = new StringBuilder();
    while (p <= q) {
      if (isKaprekar(p)) {
        result.append(p).append(" ");
      }
      p++;
    }

    return result.toString().isEmpty() ? "INVALID RANGE" : result.toString().trim();
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    int p = Integer.parseInt(bufferedReader.readLine().trim());
    int q = Integer.parseInt(bufferedReader.readLine().trim());

    System.out.println(Result.kaprekarNumbers(p, q));
  }
}
