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

        bufferedWriter.write(String.valueOf(chocolateFeast(input[0], input[1], input[2])));
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int chocolateFeast(int money, int cost, int wrapCost) {
        if (money < cost) {
            return 0;
        }

        int total = 0;
        int wrapper = 0;
        while (money >= cost) {
            total++;
            wrapper++;
            money -= cost;
        }

        int bonus = 0;
        while (wrapper >= wrapCost) {
            bonus++;
            wrapper -= wrapCost;
            wrapper++;
        }

        return total + bonus;
    }
}
