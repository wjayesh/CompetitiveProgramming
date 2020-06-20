class LongestDupSubS19 {
    private long q = (1<<31)-1 ; // a large prime
    private int R = 256 ; // radix

    // compute hash for key[0..m-1]
    private long hash(String key, int m) {
        long h = 0 ; 
        for ( int j = 0 ; j < m ; j ++ ) {
            h = (R * h + key.charAt(j)) % q ; 
        }
        return h ; 
    }

    private boolean compare(String s, int i1, int i2, int m) {
        for ( int i = 0 ; i < m ; i ++ ) {
            if ( s.charAt(i1+i) != s.charAt(i2+i) ) return false ; 
        }
        return true ; 
    }

    private int test(String s, int m) {
        Map<Long, List<Integer>> map = new HashMap<>() ; 
        long h = hash(s, m) ; 
        map.put(h, new ArrayList<>()) ; 
        map.get(h).add(0) ; 

        long RM = 1 ; // R^(m-1) % q
        for ( int i = 1 ; i <= m-1 ; i ++ ) {
            RM = (R * RM) % q ; 
        }

        // NOTE i is the ending index of current string
        for ( int i = m ; i < s.length() ; i ++ ) {
            // remove leading digit, add trailing digit, check for match
            h = ( h + q - RM*s.charAt(i-m)%q ) % q ;
            h = ( h * R + s.charAt(i) ) % q ;
            int startIndex = i - m + 1 ; 
            if ( map.containsKey(h) ) {
                for ( int prev: map.get(h) ) {
                    if ( compare(s, startIndex, prev, m) ) return startIndex ; 
                }
            }
            else {
                map.put(h, new ArrayList<>()) ; 
            }
            map.get(h).add(startIndex) ;             
        }

        return -1 ; 
    }

    public String longestDupSubstring(String S) {
        int lo = 0, hi = S.length() ; 
        // binary search to find SMALLEST length of string that cannot pass test
        while ( lo < hi ) {
            int mid = lo + (hi-lo)/2 ; 
            int index = test(S, mid) ; 
            if ( index < 0 ) hi = mid ;  
            else {
                lo = mid + 1 ;
            }
        }
        // lo-1 is the LARGEST length of string that CAN pass test
        int checkLen = lo-1 ; 
        if ( checkLen <= 0 ) return "" ; 
        int start = test(S, checkLen) ; 
        return S.substring(start, start + checkLen) ; 
    }
}
