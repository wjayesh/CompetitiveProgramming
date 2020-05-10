package April;
import java.util.Arrays;

public class CountingElementsDay7 {
    public static int countElements(int[] arr) {
        int[] incrementedArr = new int[arr.length];
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            incrementedArr[i] = arr[i] + 1;
        }
        int i = 0, j = 0, count = 0;
        while(i < arr.length) {
            if (arr[i] == incrementedArr[j]) {
                count++;
                while(arr[i] == incrementedArr[++j]){
                    count++;
                }
                i++;
            } else if (arr[i] > incrementedArr[j]){
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1, 1, 1, 2, 2, 3}));
    }

}