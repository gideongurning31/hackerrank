import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        String textInput = bufferedReader.readLine().replaceAll("\\s+$", "");

        bufferedWriter.write(charCount(textInput));
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String charCount(String input) {
        HashMap<Character, Integer> mapper = new HashMap<>();
        List<Character> numerics = new ArrayList<>();
        char[] excludes = " 1234567890".toCharArray();
        for (char c : excludes) {
            numerics.add(c);
        }

        char[] inputArr = input.toCharArray();
        for (char c : inputArr) {
            if (!numerics.contains(c)) {
                char key = Character.toUpperCase(c);
                mapper.put(key, mapper.getOrDefault(key, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("{ ");
        mapper.keySet().forEach(key -> result.append(key).append(": ").append(mapper.get(key)).append(", "));
        result.deleteCharAt(result.length() - 1).deleteCharAt(result.length() - 1);
        result.append(" }");

        return result.toString();
    }
}
