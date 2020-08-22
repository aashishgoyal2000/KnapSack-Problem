import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, long[] values, long[] weights) {
        double value = 0;
        long[][] arr = new long[values.length][2];
        for (int i = 0; i < values.length; i++) {
            arr[i][0] = values[i];
            arr[i][1] = weights[i];
        }
        
        Arrays.sort(arr, new Comparator<long[]>() {  
          @Override              
          public int compare(final long[] entry1, final long[] entry2) { 
            if ((double)((double)entry1[0]/(double)entry1[1]) < (double)((double)entry2[0]/(double)entry2[1])) 
                return 1; 
            else
                return -1; 
          } 
        });
        double tot = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i][1] <= capacity) {
                tot += (double)arr[i][0];
                capacity -= arr[i][1];
            } else {
                double temp = (double)((double)arr[i][0]/(double)arr[i][1]);
                tot += (double)temp*(double)capacity;
                break;
            }

            if (capacity <= 0) {
                break;
            }
        }
        tot = (tot * 100.0d)/100.0d;
        return tot;
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        long[] values = new long[n];
        long[] weights = new long[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println( getOptimalValue(capacity, values, weights));
    }
} 
