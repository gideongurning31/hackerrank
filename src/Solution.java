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

        int X = 5;
        System.out.println("Result: ".concat(String.valueOf(solution(X, input))));
    }

    private static int solution(int X, int[] A) {
        HashSet<Integer> leafPosts = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            leafPosts.add(A[i]);
            if (leafPosts.size() == X) {
                return i;
            }
        }

        return -1;
    }
}
