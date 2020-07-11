public class Subsets11 {
  public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    int totalNumber = 1 << S.length;
    List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
    for (int i=0; i<totalNumber; i++) {
      List<Integer> set = new LinkedList<Integer>();
      for (int j=0; j<S.length; j++) {
        if ((i & (1<<j)) != 0) {
          set.add(S[j]);
        }
      }
      collection.add(set);
    }
    return collection;
  }
}
