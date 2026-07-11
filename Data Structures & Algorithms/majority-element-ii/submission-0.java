class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:hm.keySet())
        {
            if(hm.get(num)>(nums.length/3))
            {
                list.add(num);
            }
        }
        return list;
    }
}