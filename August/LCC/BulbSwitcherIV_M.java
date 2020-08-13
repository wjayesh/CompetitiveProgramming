
class Solution {
    public int minFlips(String target) {
        int n = target.length();
        int flips = 0;
        char status = '0';
        for (int i = 0; i < n; i++) {
            if (status != target.charAt(i)) {
                flips++;
            }
            status = flips % 2 == 1 ? '1' : '0'; 
        }
        return flips;
    }
}

// maintain state of the remaining array. if state doesn't match for the current index, flip.
