class H_IndexII_18 {
    public int hIndex(int[] arr) {
        int n = arr.length;
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(n - mid > arr[mid]) {
                l = mid + 1;
            } else if (n - mid < arr[mid]){
                r = mid - 1;
            } else {
                return arr[mid];
            }
        }
        return n - l;
    }
}
