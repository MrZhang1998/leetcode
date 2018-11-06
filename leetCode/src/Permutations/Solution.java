package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[]nums = new int[] {1,2,3};
		List<List<Integer>> permute = solution.permute(nums);
		System.out.println(permute);
	}

	public List<List<Integer>> permute(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		boolean[] isVisited = new boolean[nums.length];
		Arrays.fill(isVisited, false);
		backTrace(nums, isVisited, 0, temp, result);
		return result;
	}
	
	private void backTrace(int[] nums, boolean[] isVisited ,int index ,List<Integer> temp ,List<List<Integer>>result)
	{
		if(index == nums.length)
		{
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = 0; i<nums.length;i++)
		{
			if(isVisited[i]== false)
			{
				isVisited[i] = true;
				temp.add(nums[i]);
				backTrace(nums, isVisited, index+1, temp, result);
				isVisited[i] = false;
				temp.remove(temp.size()-1);
			}
		}
	}

}
