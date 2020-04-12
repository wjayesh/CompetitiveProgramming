import java.io.*;
import java.util.*;

public class CrioMock3_1 {

    static HashSet<Integer> cache = new HashSet<Integer>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int key = scanner.nextInt();
        scanner.close();
        int result = 0;
        
        result = calcMoves(n, key);
        if (found == 1) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
        
        
    }
    
    static int found = 0;
    static int calcMoves(int n, int key) {
            if (n == key) {
                found = 1;
                return 0;
            }
            if (cache.contains(n)) {
                return 1000000;
            }
            if (n == 0 && key != 0) {
                return 1000000;
            }
            
            int b = 1 + calcMoves(n/10, key);
            int a = 1 + calcMoves(reverseInt(n), key);
            int moves = Math.min(a, b);
            
            return moves;
    }
    
        
    static int reverseInt(int n) {
        cache.add(n);
         int sum = 0;
         while (n != 0) {
             int d = n % 10;
             if (d != 0)
             sum = 10 * sum + d;
             n /= 10;
         }
        return sum;
    }
        
}