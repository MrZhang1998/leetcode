package Majority_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution
{
	public int majorityElement(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : nums)
		{
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i, 1);
		}
		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
		for(Entry<Integer,Integer> entry : entrySet)
		{
			if(entry.getValue()>nums.length/2)
			{
				return entry.getKey();
			}
		}
		return -1;
	}
}
