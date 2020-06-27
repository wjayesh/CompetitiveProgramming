class PerfectSquares27 {
    public int numSquares(int n) {
        return recurse((double)n);
    }
    
    private int recurse(double rem) {
        if(rem == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; Math.pow(i,2) <= rem; i++) {
            min = Math.min(min, recurse(rem-Math.pow(i,2)));
        }
        return min + 1;
    }
}
