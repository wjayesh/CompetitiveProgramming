package April;
import java.util.*;

public class CrioMock3_2 {

    long key;
    long value;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        List<CrioMock3_2> objects = createMap(scanner.nextLong());
        long k = scanner.nextLong();
        scanner.close();;
        // Collections.sort(digits);
        // Collections.reverse(digits);
        // long sum = digits.get(0);
        // long prev = digits.get(0);
        // for (int i = 1; i<digits.size(); i++) {
        //     if (map.get(digits.get(i)) > map.get(prev))
        //         sum = sum * 10 + digits.get(i);
        // }
        // System.out.println(sum);
        long sum = 0;
        Collections.sort(objects, ((o1, o2) -> (int)((o1.value == o2.value)? o2.key - o1.key:o2.value-o1.value)));
        // Collections.reverse(objects);
        for (int i = 0; i<objects.size(); i++) {
            if (objects.get(i).key + k <= c) {
                long prevIndex = -1;
                while(k != 0 && objects.get(i).key > prevIndex) {
                    prevIndex = objects.get(i).key;
                    sum = sum * 10 + objects.get(i).value;
                    k--; i++;
                }
            }
        }
        
        System.out.println(sum);
        
    
    }
    
    static List<Long> digits = new LinkedList<Long>();
    static long c = 0;
    static List<CrioMock3_2> createMap(long n) {
        List<CrioMock3_2> list = new ArrayList<>();
        
        
        while (n != 0) {
            long d = n % 10;
            digits.add(d);
            c++;
            n /= 10;
        }
        long count = c;
        for (long digit:digits) {
            CrioMock3_2 obj = new CrioMock3_2();
            obj.key = count--;
            obj.value = digit;
            list.add(obj);
        }
        return list;
        
    }
    
    
}