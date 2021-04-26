import java.io.*;
import java.util.stream.*;

class Result {

  public static long taumBday(int b, int w, int bc, int wc, int z) {
    long bMin = Math.min(bc, wc + z);
    long wMin = Math.min(wc, bc + z);
    return (bMin * b) + (wMin * w);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    int t = Integer.parseInt(bufferedReader.readLine().trim());
    IntStream.range(0, t).forEach(tItr -> {
      try {
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int b = Integer.parseInt(firstMultipleInput[0]);
        int w = Integer.parseInt(firstMultipleInput[1]);
        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int bc = Integer.parseInt(secondMultipleInput[0]);
        int wc = Integer.parseInt(secondMultipleInput[1]);
        int z = Integer.parseInt(secondMultipleInput[2]);

        long result = Result.taumBday(b, w, bc, wc, z);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
