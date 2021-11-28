import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        String[] textInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> input = new ArrayList<>();
        for (String s : textInput) {
            input.add(Integer.parseInt(s));
        }

        int result = theJungleBook(input);
        System.out.println("Total cages needed: " + result);
        bufferedWriter.write(String.valueOf(result));
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static final List<List<Integer>> cages = new ArrayList<>();
    private static List<Integer> predators;

    public static int theJungleBook(List<Integer> p) {
        predators = p;
        if (predators.size() == 0 || predators.size() == 1) {
            return predators.size();
        }

        List<Integer> noPredatorCage = new ArrayList<>();
        List<Integer> commonCage = new ArrayList<>();
        for (int i = 0; i < predators.size(); i++) {
            if (predators.get(i) == -1) {
                noPredatorCage.add(i);
            } else {
                commonCage.add(i);
            }
        }

        cages.add(noPredatorCage);
        cages.add(commonCage);

        for (int i = 0; i < predators.size(); i++) {
            int predator1 = predators.get(i);

            if (predator1 == -1) {
                continue;
            }

            int predator2 = noPredatorCage.contains(predator1) ? Integer.MAX_VALUE : predators.get(predator1);
            for (int x = 1; x < cages.size(); x++) {
                if (!cages.get(x).contains(i)) {
                    continue;
                }

                boolean isWrongCage = cages.get(x).contains(predator1) || cages.get(x).contains(predator2);
                if (isWrongCage) {
                    // CHECKPOINT
                    cages.get(x).remove(cages.get(x).indexOf(i));
                    findOrCreate(i, predator1, predator2);
                    break;
                }
            }

        }

        cages.forEach(cage -> System.out.println(Arrays.toString(cage.toArray())));
        return cages.size();
    }

    private static void findOrCreate(int species, int predator1, int predator2) {
        boolean caged = false;
        for (int i = 1; i < cages.size(); i++) {
            if (!cages.get(i).contains(predator1) && !cages.get(i).contains(predator2)) {
                cages.get(i).add(species);
                caged = true;
                break;
            }
        }

        if (!caged) {
            List<Integer> newCage = new ArrayList<>();
            newCage.add(species);
            cages.add(newCage);
        }
    }
}
