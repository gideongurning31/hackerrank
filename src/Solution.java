import java.io.*;
import java.util.HashSet;

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

    private static int solution(int[] A) {
        HashSet<Integer> checks = new HashSet<>();
        int max = A.length;
        for (int a : A) {
            checks.add(a);
            if (max < a) {
                max = a;
            }
        }

        return checks.size() == max ? 1 : 0;
    }
}
