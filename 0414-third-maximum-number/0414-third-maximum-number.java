class Solution {
    public int thirdMax(int[] nums) {
     final TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < 3 && i<nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 3; i < nums.length; i++) {
            final Integer smallest = set.first();
            if (set.size()<3) {
                set.add(nums[i]);
            }else if (nums[i]>smallest){
                final boolean added = set.add(nums[i]);
                if (added){
                    set.remove(smallest);
                }
            }
        }
        if (set.size()<3){
            return set.last();
        }

        return set.first();}
}