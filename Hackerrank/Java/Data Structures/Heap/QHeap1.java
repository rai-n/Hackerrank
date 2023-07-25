import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> ts = new TreeSet<>();
        
        Integer amt = sc.nextInt();
        while (sc.hasNext()){
            final Integer op = sc.nextInt();
            if (op.equals(1)){
              ts.add(sc.nextInt());
            } else if (op.equals(2)){
                ts.remove(sc.nextInt());
            } else if (op.equals(3)){
                System.out.println(ts.first());
            } else {
                throw new RuntimeException("Entry should be 1, 2 or 3");
              }
        }
        
    }
}