class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

        int i = 0;
        for (int num : hs) {
            nums[i++] = num;
        }

        return hs.size();
    }
}