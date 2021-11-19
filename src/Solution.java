import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    String enter = firstMultipleInput[0];
    String leave = firstMultipleInput[1];
    System.out.println("Result: ".concat(String.valueOf(parkingFee(enter, leave))));
  }

  private static final int ENTRANCE_FEE = 2;
  private static final int FIRST_HOUR_FEE = 3;
  private static final int OVER_ONE_HOUR_FEE = 4;

  private static int parkingFee(String E, String L) {
    String[] enter = E.split(":");
    String[] leave = L.split(":");

    int enterHour = Integer.parseInt(enter[0]);
    int leaveHour = Integer.parseInt(leave[0]);
    int enterMinute = Integer.parseInt(enter[1]);
    int leaveMinute = Integer.parseInt(leave[1]);

    if (enterHour == leaveHour || (leaveHour - enterHour == 1 && enterMinute >= leaveMinute)) {
      return ENTRANCE_FEE + FIRST_HOUR_FEE;
    }

    return ENTRANCE_FEE + FIRST_HOUR_FEE + calculateOver2Hour(enterHour, enterMinute, leaveHour, leaveMinute);
  }

  private static int calculateOver2Hour(int eH, int eM, int lH, int lM) {
    int overByMinute = eM >= lM ? 0 : 1;
    int overByHour = lH - eH - 1;
    return (overByHour + overByMinute)*OVER_ONE_HOUR_FEE;
  }
}
