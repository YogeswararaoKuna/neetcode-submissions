class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=Integer.MAX_VALUE;
        int l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++)
        {
            sum+=nums[r];
            while(sum>=target)
            {
                len=Math.min(len,r-l+1);
                sum-=nums[l];
                l++;
            }

        }
        if(len==Integer.MAX_VALUE) return 0;
        return len;
    }
}