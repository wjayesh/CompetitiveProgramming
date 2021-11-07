class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
      int i = 0; // i means we have how many bits are 0 on the right
      while(m != n){
        m >>= 1;
        n >>= 1;
        i++;  
      }  
      return m << i;  
    }
}

/*
11010
11011
11100　　
11101　　
11110

output - 11000
 */