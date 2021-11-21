import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] input = new int[textInput.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(textInput[i]);
        }

        System.out.println("Result: ".concat(String.valueOf(solution(input[0]))));
    }

    private static int solution(int N) {
        int i = 1;
        while (i < Integer.MAX_VALUE) {
            double pow = Math.pow(2L, i);
            if (N % pow != 0) {
                break;
            }

            i++;
        }

        return i - 1;
    }
}
