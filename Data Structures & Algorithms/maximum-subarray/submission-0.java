class Solution {
    public int maxSubArray(int[] nums) {
        int curr=0;
        int maxsum=Integer.MIN_VALUE;
        for(int num:nums)
        {
            curr+=num;
            maxsum=Math.max(curr,maxsum);
            if(curr<0)
            {
                curr=0;
            }
        }
        return maxsum;
    }
}
