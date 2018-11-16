package Kth_Largest_Element_in_an_Array;

public class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int[]nums = new int[] {3,2,3,1,2,4,5,5,6};
		int k = 4;
		int findKthLargest = solution.findKthLargest(nums, k);
		System.out.println(findKthLargest);
	}
	
	public int findKthLargest(int[] nums, int k)
	{
		return quick_sort(nums, 0, nums.length-1, nums.length -k);
	}
	
	private int quick_sort(int[] a, int start, int end, int kth)
	{
		if(start == end)
			return a[start];
		int i = start;
		int j = end;
		int key = a[start];
		while(i<j)
		{
			while(i<j&&a[j]>=key)
			{
				j--;
			}
			a[i] = a[j];
			while(i<j&&a[i]<=key)
			{
				i++;
			}
			a[j] = a[i];
		}
		a[i] = key;
		if(i == kth)
		{
			return a[kth];
		}
		if(i>kth)
		{
			return quick_sort(a, start, i-1, kth);
		}
		return quick_sort(a, i+1, end, kth);
	}
}
