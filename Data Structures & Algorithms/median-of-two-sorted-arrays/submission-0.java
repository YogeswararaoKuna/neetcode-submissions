class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int arr[]=new int[m+n];
        int l=arr.length;
        for(int i=0;i<m;i++)
        {
            arr[i]=nums1[i];
        }
        for(int j=0;j<n;j++)
        {
            arr[m+j]=nums2[j];
        }
        Arrays.sort(arr);
        if((m+n)%2 != 0)
        {
            return arr[(m+n)/2]/1.0;
        }
        else
        {
            return (arr[l/2]+arr[l/2-1])/2.0;
        }
    }
}
