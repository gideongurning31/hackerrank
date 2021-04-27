import java.io.*;

class Result {
  public static long minimumDistances(int[] a) {
    long minDistance = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] == a[j]) {
          if (minDistance == 0) minDistance = j - i;
          minDistance = Math.min(minDistance, j - i);
        }
      }
    }

    return minDistance == 0 ? -1 : minDistance;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
    int n = Integer.parseInt(bufferedReader.readLine().trim());
    int[] x = new int[n];
    String[] a = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    for (int i = 0; i < n; i++) {
      x[i] = Integer.parseInt(a[i]);
    }

    bufferedWriter.write(String.valueOf(Result.minimumDistances(x)));
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
  }
}
