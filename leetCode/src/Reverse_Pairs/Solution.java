package Reverse_Pairs;
public class Solution
{

	public int reversePairs(int[] nums)
	{
		if(nums==null || nums.length <=1)
			return 0;
		int[] temp = new int[nums.length];
		return merge_sort(nums, 0, nums.length-1, temp);
	}

	private int merge_sort(int a[], int first, int end, int[] temp)
	{
		if (first >= end)
			return 0;
		int mid = (end + first) / 2;
		int ans_left = merge_sort(a, first, mid, temp);
		int ans_right = merge_sort(a, mid + 1, end, temp);
		return ans_left + ans_right + merge(a, first, mid, end, temp);
	}

	private int merge(int[] a, int first, int mid, int end, int[] temp)
	{
		System.out.println("first = " + first +","+"end ="+end);
		int i = first;
		int j = mid + 1;
		int m = mid;
		int k = 0;
		int ans = 0;
		int count = 0;
		for(;i<=mid;i++)
		{
			while(j<=end&&(long)a[i]>(long)2*a[j])
			{
				j++;
				count++;
			}
			ans+=count;
		}
		i = first;
		j = mid+1;
		while (i <= m && j <= end)
		{
			
			if (a[i] < a[j])
			{
				temp[k++] = a[i];
				i++;
			} else
			{
				temp[k++] = a[j];
				if(a[i]>2*a[j])
					count++;
				j++;
			}
		}
		while (i <= mid)
		{
			temp[k++] = a[i++];
		}
		while (j <= end)
		{
			temp[k++] = a[j++];
		}

		for (i = 0; i < k; i++)
		{
			a[i + first] = temp[i];
		}
		return ans;
	}

	public static void main(String[] args)
	{	
		Solution solution = new Solution();
		int[]nums = new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		int reversePairs = solution.reversePairs(nums);
		System.out.println(reversePairs);
	}
}
