package NextPermutation;

import java.util.Arrays;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.nextPermutation(new int[] {4,2,5,5,3,2,1});
	}

	public void nextPermutation(int[] nums)
	{
		if (nums.length == 1)
			return;
		int index = nums.length - 1;
		while (index > 0 && nums[index] <= nums[index - 1])
		{
			index--;
		}
		index--;
		if(index == -1)
		{
			reverse(nums);
			return;
		}
		int current = nums[index];
		Arrays.sort(nums, index+1, nums.length);
		for(int i = index+1; i<nums.length;i++)
		{
			if( current<nums[i])
			{
				nums[index] = nums[i];
				nums[i] = current;
				break;
			}
		}
		
	}
	
	private void reverse(int[] nums)
	{
		int left = 0; int right = nums.length-1;
		while(left<right)
		{
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
