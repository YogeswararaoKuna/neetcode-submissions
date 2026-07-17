class Solution {
    public boolean search(int[] nums, int target) {
       int l=0;
       int r=nums.length-1;
       while(l<=r)
       {
        if(nums[l]==target) return true;
        if(nums[r]==target) return true;
;
        l++;
        r--;
       } 
       return false;
    }
}