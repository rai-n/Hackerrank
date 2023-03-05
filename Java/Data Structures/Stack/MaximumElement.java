import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Stack {
    ArrayList<Integer> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void add(Integer e) {
        list.add(e);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public Integer max() {
        // return list.stream().reduce((a,b) -> a>b ? a : b).get();

        Integer max = Integer.MIN_VALUE;

        for (Integer n : list) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

}

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here

        Stack s = new Stack();
        ArrayList<Integer> res = new ArrayList<>();

        operations.forEach(operation -> {
            String operand = operation.split(" ")[0];
            if (operand.equals("1")) {
                s.add(Integer.parseInt(operation.split(" ")[1]));
            } else if (operand.equals("2")) {
                s.pop();
            } else if (operand.equals("3")) {
                res.add(s.max());
            }
        });

        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
