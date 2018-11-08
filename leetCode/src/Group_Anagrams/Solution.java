package Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat", "", "" };
		List<List<String>> groupAnagrams = solution.groupAnagrams(strs);
		System.out.println(groupAnagrams);
	}

	public List<List<String>> groupAnagrams(String[] strs)
	{
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String temp : strs)
		{
			char[] chars = temp.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (map.containsKey(key))
			{
				map.get(key).add(temp);
			} else
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(temp);
				map.put(key, list);
			}
		}
		return new ArrayList<List<String>>(map.values());

	}

}
