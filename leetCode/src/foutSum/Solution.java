package foutSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		System.out.println(solution.fourSum(nums, 0));
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-3;i++)
        {
        	if(i>0&&nums[i] == nums[i-1])
        		continue;
        	for(int j = i+1; j<nums.length-2;j++)
        	{
        		if(j>i+1&&nums[j] == nums[j-1])
        			continue;
        		int start = j+1;
        		int end = nums.length-1;
        		int now = target - nums[i]-nums[j];
        		while(start<end)
        		{
        			if(nums[start]+nums[end] == now)
        			{
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(nums[start]);
        				list.add(nums[end]);
        				result.add(list);
        				start++;
        				end--;
        				// distinct
        				while(start<end&&nums[start] == nums[start-1])
        					start++;
        				while(start<end&&nums[end] == nums[end+1])
        					end--;
        			}else if(nums[start]+nums[end]>now)
        			{
        				end--;
        			}else {
        				start++;
        			}
        		}
        	}
        }
        return result;
    }
}
