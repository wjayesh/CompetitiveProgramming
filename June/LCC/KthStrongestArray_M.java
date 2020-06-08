public class KthStrongestArray_M {
  public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int median = (len%2)==0? (arr[(len-1)/2]) : arr[len/2];
        arr=Arrays.stream(arr)
            .boxed()
            .sorted((a,b) -> (Math.abs(b-median)-Math.abs(a-median))==0 ? b-a : (Math.abs(b-median)-Math.abs(a-median))) 
            .mapToInt(Integer::intValue)
            .limit(k)
            .toArray();
    
        return arr;
    }
}
