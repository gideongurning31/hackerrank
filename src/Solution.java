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

        bufferedWriter.write(String.valueOf(howManyGames(input[0], input[1], input[2], input[3])));
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int howManyGames(int price, int discount, int minPrice, int wallet) {
        // When I'm broke
        if (wallet < price) {
            return 0;
        }

        int subTotal = 0;
        int shoppingChart = 0;
        while (price > minPrice && wallet > subTotal) {
            shoppingChart++;
            subTotal += price;
            price -= discount;
        }

        // Reached the minimum price
        if (wallet == subTotal) {
            return shoppingChart;
        } else if (wallet < shoppingChart) {
            return shoppingChart - 1;
        }

        // Buy multiple items with remaining money on minimum price
        int walletLeft = wallet - subTotal;
        int remainder = walletLeft % minPrice;
        shoppingChart += (walletLeft - remainder) / minPrice;

        return shoppingChart;
    }
}
