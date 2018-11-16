package The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		List<int[]> skyline = solution.getSkyline(buildings);
		solution.print(skyline);
		
	}
	private void print(List<int[]> skyline)
	{
		for(int i = 0 ; i<skyline.size(); i++)
		{
			int[] temp = skyline.get(i);
			for(int num : temp)
			{
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
	public List<int[]> getSkyline(int[][] buildings)
	{
		List<int[]> list = new ArrayList<int[]>();
		if(buildings == null || buildings.length == 0 || buildings[0].length == 0)
			return list;
		// 获取关键点
		Set<Integer> set = new HashSet<Integer>();
		for (int[] building : buildings)
		{
			set.add(building[0]);
			set.add(building[1]);
		}
		Integer[] array = set.toArray(new Integer[0]);
		Arrays.sort(array);
		// inint value
		int start = buildings[0][0];
		int current_height = buildings[0][2];
		
		for (int k = 0; k<array.length; k++)
		{
			int i = array[k];
			// find max height
			int max = 0;
			for (int j = 0; j < buildings.length; j++)
			{
				if (buildings[j][0] <= i && buildings[j][1] > i && buildings[j][2] > max)
					max = buildings[j][2];
				if (buildings[j][0] > i)
					break;
			}
			if (i == start)
			{
				list.add(new int[] { start, max });
				current_height = max;
			} else if (max != current_height)
			{
				list.add(new int[] { i, max });
				current_height = max;
			}
		}
		
		return list;
	}
}