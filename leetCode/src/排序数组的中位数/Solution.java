package 排序数组的中位数;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1<n2)
        {
        	int[] temp =  nums1;
        	nums1 = nums2;
        	nums2 = temp;
        }	
        n1 = nums1.length;
        n2 = nums2.length;
        int low = 0;
        int high = n2*2;
        while(low<=high)
        {
        	int mid2 = (low+high)/2;
        	int mid1 = n1+n2 - mid2;
        	double L1 = mid1 == 0?Integer.MIN_VALUE:nums1[(mid1-1)/2];
        	double L2 = mid2 == 0?Integer.MIN_VALUE:nums2[(mid2-1)/2];
        	double R1 = mid1 == n1*2?Integer.MAX_VALUE:nums1[mid1/2];
        	double R2 = mid2 == n2*2?Integer.MAX_VALUE:nums2[mid2/2];
        	if(L1>R2)
        		low = mid2+1;
        	else if(L2>R1)
        		high = mid2-1;
        	else 
        		return (Math.max(L1, L2)+Math.min(R1, R2))/2;
        }
        return -1;
    }
    
    public static void main(String[] args)
	{
		Solution solution = new Solution();
		double re = solution.findMedianSortedArrays(new int []{1},new int[]{2,3});
		System.out.println(re);
	}
}
