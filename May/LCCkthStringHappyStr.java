public class LCCkthStringHappyStr {
  final char[] ch= {'a', 'b', 'c'};
    String result;
    int n, k, count;
    public String getHappyString(int n, int k) {
        result = "";
        this.n = n;
        this.k = k;
        count = 0;
        backTrack(-1, "");
        return result;
    }
    private void backTrack(int lastUsed, String str){
        if(str.length() == n){
            count++;
            if(count == k){
                result = str;
            }
            return;
        }
        for(int i = 0; i < 3; i++){
            if(i!= lastUsed){
                backTrack(i, str + ch[i]);
            }
        }
    }
}
