import java.util.*;

public class q12 {

    
    public static Set<Integer> getSortedUniqueElements(int[] arr) {
        
        Set<Integer> sortedUniqueElements = new TreeSet<>();
        
        for (int num : arr) {
            sortedUniqueElements.add(num);
        }

        return sortedUniqueElements;
    }

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 2, 8, 5, 4};

        Set<Integer> result = getSortedUniqueElements(arr);

        System.out.println("Sorted unique elements: " + result);
    }
}
