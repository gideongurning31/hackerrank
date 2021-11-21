import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] input = new int[textInput.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(textInput[i]);
        }

        System.out.println("Result: ".concat(String.valueOf(solution(input))));
    }

    private static int result = Integer.MAX_VALUE;

    private static int solution(int[] A) {
        int rightSum = 0;
        for (int a : A) {
            rightSum += a;
        }

        int leftSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            minDiffAbs(leftSum - rightSum);
        }

        return result;
    }

    private static void minDiffAbs(int val) {
        int absVal = val >= 0 ? val : -1 * val;
        if (result > absVal) {
            result = absVal;
        }
    }
}
