import java.io.*;

class Result {

  public static int specialProblems = 0;
  private static int currentPage = 0;
  private static int problemNo = 1;

  private static void isSpecialProblem(int problemsInChapter, int limit) {
    while (problemsInChapter != 0 && limit != 0) {
      if (problemNo == currentPage) specialProblems++;
      problemNo++;
      problemsInChapter--;
      limit--;
    }
  }

  public static int workbook(int limit, int[] chapters) {
    int i = 0;
    while (i < chapters.length) {
      currentPage++;
      isSpecialProblem(chapters[i], limit);

      if (limit >= chapters[i]) {
        problemNo = 1;
        i++;
      } else {
        problemNo += problemNo == 1 ? limit : 0;
        chapters[i] -= limit;
      }
    }

    return specialProblems;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);
    int k = Integer.parseInt(firstMultipleInput[1]);

    String[] s = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }

    int result = Result.workbook(k, arr);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
  }
}
