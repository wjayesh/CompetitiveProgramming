package May;

import java.util.HashMap;

import May.utils.DisjointSets;

public class CoronavirusSpreadCC {
    HashMap<Integer, Integer> map = new HashMap<>();
    int smallest, largest = 0;
    public int[] bestWorstScenario(int[] pos) {
        int length = 0;
        smallest = pos.length;
        DisjointSets ds = new DisjointSets(pos.length);
        for(int i = 1; i < pos.length; i++) {
            if(pos[i] - pos[i-1] <= 2) {
                ds.union(i, i-1);
                length = map.getOrDefault(ds.find(i), 0);
                map.put(ds.find(i), length + 1);
            } 
            if(pos[i] - pos[i-1] > 2 || i == pos.length-1){
                if(length < smallest) {
                    smallest = length + 1;
                } 
                if (length > largest) {
                    largest = length + 1;
                }
            } 
        }
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        CoronavirusSpreadCC obj = new CoronavirusSpreadCC();
        int[] output = obj.bestWorstScenario(new int[]{1,3,5,7, 10, 13});
        System.out.println(output[0] + " " + output[1]);
    }
    
}