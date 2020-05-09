package May.utils;

public class DisjointSets {

    private int[] array;
  
    /**
     *  Construct a disjoint sets object.
     *
     *  @param numElements the initial number of elements--also the initial
     *  number of disjoint sets, since every element is initially in its own set.
     **/
    public DisjointSets(int numElements) {
      array = new int [numElements];
      for (int i = 0; i < array.length; i++) {
        array[i] = -1;
      }
    }
  
    /**
     *  union() unites two disjoint sets into a single set.  A union-by-rank
     *  heuristic is used to choose the new root.  This method will corrupt
     *  the data structure if root1 and root2 are not roots of their respective
     *  sets, or if they're identical.
     *
     *  @param root1 the root of the first set.
     *  @param root2 the root of the other set.
     **/
    public void union(int root1, int root2) {
      if (array[root2] < array[root1]) {
        array[root1] = root2;             // root2 is taller; make root2 new root
      } else {
        if (array[root1] == array[root2]) {
          array[root1]--;            // Both trees same height; new one is taller
        }
        array[root2] = root1;       // root1 equal or taller; make root1 new root
      }
    }
  
    /**
     *  find() finds the (int) name of the set containing a given element.
     *  Performs path compression along the way.
     *
     *  @param x the element sought.
     *  @return the set containing x.
     **/
    public int find(int x) {
      if (array[x] < 0) {
        return x;                         // x is the root of the tree; return it
      } else {
        // Find out who the root is; compress path by making the root x's parent.
        array[x] = find(array[x]);
        return array[x];                                       // Return the root
      }
    }
}