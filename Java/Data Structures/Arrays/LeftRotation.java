// O(n^2)

public static List<Integer> rotateLeft(int d, List<Integer> arr){
    // Write your code here
    for (int i=0; i< d; i++){
        
        int temp = arr.get(0);
        for (int j=0; j<= arr.size() -2; j++){
            arr.set(j, arr.get(j+1));
        }
        arr.set(arr.size()-1, temp);
        
    }
    return arr;
}

// O(N+N)
public static List<Integer> rotateLeft(int d, List<Integer> arr){
    Deque<Integer> deq = new ArrayDeque<Integer>();
    for (int i : arr){
        deq.add(i);
    }
    for (int i = 0; i < d; i++) {
        int temp = deq.remove();
        deq.addLast(temp);
    }
    
    return new ArrayList<>(deq);
}
