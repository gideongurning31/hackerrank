import java.io.*;

class Result {
  public static int beautifulTriplets(int d, int[] arr) {
    int result = 0;
    int L = arr.length;

    for (int i = 0; i < L; i++) {
      for (int j = i + 1; j < L; j++) {
        if (arr[j] - arr[i] == d) {
          for (int k = j + 1; k < L; k++) {
            if (arr[k] - arr[j] == d) result++;
          }
        }
      }
    }

    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int d = Integer.parseInt(firstMultipleInput[1]);

    String[] arrStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int[] arr = new int[arrStr.length];
    for (int i = 0; i < arrStr.length; i++) {
      arr[i] = Integer.parseInt(arrStr[i]);
    }

    bufferedWriter.write(String.valueOf(Result.beautifulTriplets(d, arr)));
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
  }
}
