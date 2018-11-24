package Minimum_Window_Substring;

import java.util.*;

class Solution
{
	public String minWindow(String s, String t)
	{
		if (s == null || t == null)
			return "";
		if (s.equals("") && t.equals(""))
			return "";
		if (s.equals(""))
			return "";
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char temp : t.toCharArray())
		{
			if (map.containsKey(temp))
				map.put(temp, map.get(temp) + 1);
			else
			{
				map.put(temp, 1);
			}
		}
		int count = 0;
		int right = 0;
		int left = 0;
		int minLeft = 0;
		int minLen = s.length() + 1;
		for (; right < s.length(); right++)
		{
			char temp = s.charAt(right);
			if (map.containsKey(temp))
			{
				if (map.get(temp) > 0)
					count++;
				map.put(temp, map.get(temp) - 1);
			}

			while (count == t.length())
			{
				if (right - left + 1 < minLen)
				{
					minLen = right - left + 1;
					minLeft = left;
				}
				if (map.containsKey(s.charAt(left)))
				{
					map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
					if (map.get(s.charAt(left)) > 0)
						count--;
				}
				left++;
			}
		}
		if (minLen > s.length())
			return "";
		return s.substring(minLeft, minLeft + minLen);
	}

	public static void main(String[] args)
	{
		Solution solution = new Solution();
		String minWindow = solution.minWindow("cabwefgewcwaefgcf", "cae");
		System.out.println(minWindow);
	}
}