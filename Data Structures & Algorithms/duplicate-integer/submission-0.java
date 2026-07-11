class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }
        if(nums.length==hs.size()) return false;
        return true;
    }
}