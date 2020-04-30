import java.util.LinkedHashSet;

class FirstUnique {
    LinkedHashSet<Integer> set;

    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
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
        if(!set.contains(value)) {
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
