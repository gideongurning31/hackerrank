import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int[] input = new int[textInput.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(textInput[i]);
        }

        bufferedWriter.write(bubbleSort(input));
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String bubbleSort(int[] arr) {
        int unsortedPartition = arr.length;
        while (unsortedPartition != 0) {
            for (int i = 0; i < unsortedPartition - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            unsortedPartition--;
        }

        StringBuilder result = new StringBuilder();
        for (int i : arr) {
            result.append(i).append(" ");
        }

        return result.toString().trim();
    }
}
