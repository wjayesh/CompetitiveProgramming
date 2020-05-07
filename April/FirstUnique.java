import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class FirstUnique {
    LinkedHashSet<Integer> set;
    Set<Integer> all;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        all = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        if(set.isEmpty()) {
            return -1;
        }
        return set.iterator().next();
    }
    
    public void add(int value) {
        if(all.add(value)) {
            set.add(value);
        } else {
            set.remove(value);
        }
    }

    public static void main(String[] args) {
        FirstUnique obj = new FirstUnique(new int[]{2, 3, 5, 5});
        obj.add(3);
        System.out.println(obj.showFirstUnique());
        obj.add(2);
        System.out.println(obj.showFirstUnique());
    }
}
