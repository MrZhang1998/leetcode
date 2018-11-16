package Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = new int[] {};
		List<Integer> countSmaller = solution.countSmaller(nums);
		System.out.println(countSmaller);
	}

	public List<Integer> countSmaller(int[] nums)
	{
		List<Integer> result = new ArrayList<Integer>();
		int[] indexs = new int[nums.length];
		for (int i = 0; i < indexs.length; i++)
		{
			indexs[i] = i;
		}

		int[] count = new int[nums.length];
		Arrays.fill(count, 0);

		// write your code here
		int[] temp = new int[nums.length];
		merge_sort(nums, indexs, 0, nums.length-1, temp,count);
		
		for (int t : count)
		{
			result.add(t);
		}
		return result;
	}

	private void merge_sort(int[] nums, int[] indexs, int first, int end, int[] temp,int[] count)
	{
		if (first < end)
		{
			int mid = (end + first) / 2;
			merge_sort(nums, indexs, first, mid, temp,count);
			merge_sort(nums, indexs, mid + 1, end, temp,count);
			merge(nums, indexs, first, mid, end, temp,count);
		}
	}
	
	private void merge(int[] nums,int[] indexs, int first, int mid, int end, int[] temp,int[]count)
	{
		int i = first;
		int j = mid+1;
		int k = 0;
		int right_samller = 0;
		while(i<=mid && j<=end)
		{
			if(nums[indexs[i]]>nums[indexs[j]])
			{
				right_samller++;
				temp[k++] = indexs[j++];
			}else {
				count[indexs[i]] += right_samller;
				temp[k++] = indexs[i++];
			}
		}
		
		while(i<=mid)
		{
			count[indexs[i]] +=right_samller;
			temp[k++] = indexs[i++];
		}
		while(j<=end)
		{
			temp[k++] = indexs[j++];
		}
		
		for(i = 0; i<k;i++)
		{
			indexs[i+first] = temp[i];
		}
	}

}
