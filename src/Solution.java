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

        bufferedWriter.write(selectionSort(input));
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static String selectionSort(int[] arr) {
        int maxPartition = arr.length - 1;
        while (maxPartition >= 0) {
            int maxIndex = 0;
            for (int i = 0; i <= maxPartition; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            int maxPerLoop = arr[maxIndex];
            arr[maxIndex] = arr[maxPartition];
            arr[maxPartition] = maxPerLoop;
            maxPartition--;
        }

        StringBuilder result = new StringBuilder();
        for (int i : arr) {
            result.append(i).append(" ");
        }

        return result.toString().trim();
    }
}
