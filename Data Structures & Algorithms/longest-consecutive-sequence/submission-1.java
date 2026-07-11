class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=1;
        int ans=1;
        if(n==0) return 0;
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            hs.add(nums[i]);
        }
        int[] arr=new int[hs.size()];
        int i=0;
        for(int num:hs)
        {
            arr[i++]=num;
        }
        Arrays.sort(arr);
        for(int j=0;j<arr.length-1;j++)
        {
            if(arr[j]+1==arr[j+1])
            {
                count++;
            }
            else
            {
                ans=Math.max(ans,count);
                count=1;
            }
        }
        ans=Math.max(ans,count);
        return ans;
    }
}
