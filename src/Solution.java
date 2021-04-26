import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  public static List<Integer> acmTeam(List<char[]> candidates) {
    int maxTopic = 0;
    int teamCount = 0;

    List<Integer> teams = new ArrayList<>();
    for (int i = 0; i < candidates.size(); i++) {
      for (int j = i + 1; j < candidates.size(); j++) {
        int knownTopics = 0;
        for (int x = 0; x < candidates.get(0).length; x++) {
          if (Integer.parseInt(String.valueOf(candidates.get(i)[x])) + Integer.parseInt(String.valueOf(candidates.get(j)[x])) != 0) {
            knownTopics++;
          }
        }
        teams.add(knownTopics);
        maxTopic = Math.max(maxTopic, knownTopics);
      }
    }

    for (int x : teams) {
      if (x == maxTopic) {
        teamCount++;
      }
    }

    List<Integer> result = new ArrayList<>();
    result.add(maxTopic);
    result.add(teamCount);
    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
    int n = Integer.parseInt(firstMultipleInput[0]);
    int m = Integer.parseInt(firstMultipleInput[1]);

    List<char[]> topic = IntStream.range(0, n).mapToObj(i -> {
      try {
        return bufferedReader.readLine().toCharArray();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }).collect(toList());

    List<Integer> result = Result.acmTeam(topic);
    bufferedWriter.write(
            result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
