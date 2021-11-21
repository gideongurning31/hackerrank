import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        System.out.println("Result: ".concat(String.valueOf(solution(textInput[0]))));
    }

    private static int solution(String s) {
        if (s.length() == 0) {
            return -1;
        } else if (s.length() == 1) {
            return 0;
        }

        final int l = s.length();
        final int modulo = l % 2;
        final int halfWay = (s.length() - modulo) / 2;
        for (int i = halfWay, j = halfWay; j >= 0; i++, j--) {
            try {
                if (s.charAt(i) != s.charAt(j)) {
                    return -1;
                }
            } catch (StringIndexOutOfBoundsException e) {
                return -1;
            }
        }

        return halfWay;
    }
}
