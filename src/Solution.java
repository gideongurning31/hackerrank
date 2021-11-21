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

    private static int solution(int[] A) {
        int eastCars = 0;
        int total = 0;
        for (int a : A) {
            if (a == 0) {
                eastCars++;
            } else {
                total += eastCars;
                if (total > 1000000000) {
                    return -1;
                }
            }
        }

        return total;
    }
}
