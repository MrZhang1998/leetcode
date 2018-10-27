package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0; i<nums.length-2;i++)
    	{
    		int target = 0-nums[i];
    		int start = i+1;
    		int end = nums.length-1;
    		while(start<end)
    		{
    			if(nums[start]+nums[end]==target)
    			{
    				ArrayList<Integer> temp = new ArrayList<Integer>();
    				temp.add(nums[i]);
    				temp.add(nums[start]);
    				temp.add(nums[end]);
    				result.add(temp);
    				start++;
    				end--;
    				while(start<end&&nums[start-1]==nums[start])
    				{
    					start++;
    				}
    				while(start<end && nums[end+1]==nums[end])
    				{
    					end--;
    				}
    			}else if(nums[start]+nums[end]>target)
    			{
    				end--;
    			}else {
					start++;
				}
    		}
    		while(i<nums.length-2&&nums[i] == nums[i+1])
    		{
    			i++;
    		}
    		
    	}
    	System.out.println(result);
    	return result;
    }
    
    public static void main(String[] args)
	{
		Solution solution = new Solution();
		solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
	}
}