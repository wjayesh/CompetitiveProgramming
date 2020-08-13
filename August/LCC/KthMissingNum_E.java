
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        for(int i=0;i<arr.length;i++){
            if(k > (arr[i]-start-1))
                k -= (arr[i]-start-1);
            else return start+k;
            start = arr[i];
        }
       
        return arr[arr.length-1]+k;
    }
}

/**
*
Example 1 -
[2,3,7,11], k = 5
Initially, start = 0

start = 0, end = 2. Between 0 and 2, there is 1 missing positive integer. Hence Decrement 1 from k = 4-1, k = 4
start = 2, end = 3. Between 2 and 3 there is no missing positive integer.
start = 3, end = 7. Between 3 and 7, there are 3 missing positive integer, substract 3 from k = 4-3, k = 1
start = 7, end = 11. Between 7 and 11, there are 3 missing positive integer. But now since k is already less than 3, our answer lies between 7 and 11.
Return start + k = 7 + 1 = 8
Answer = 8

**/
