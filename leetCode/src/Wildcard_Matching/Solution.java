package Wildcard_Matching;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Solution solution = new Solution();
		boolean match = solution.isMatch(
				"",
				"");
		System.out.println(match);
	}

	public boolean isMatch(String s, String p)
	{
		if (s == null || p == null)
			return false;
		if (s.equals("") && p.equals(""))
			return true;

		// 去除多余的* *可以匹配任意， ** 和 * 的作用其实一样，但是会增加程序运行时间
		p = processString(p);
		return core(0, 0, s, p);

	}

	private String processString(String s)
	{
		if (s.equals(""))
			return s;
		String result = "";
		result = result + s.charAt(0);
		for (int i = 1; i < s.length(); i++)
		{
			char temp = s.charAt(i);
			if (temp == '*' && s.charAt(i - 1) == '*')
			{
				continue;
			} else
			{
				result = result + temp;
			}
		}
		return result;
	}

	private boolean core(int index_s, int index_p, String s, String p)
	{
		if (index_p == p.length() && index_s == s.length())
			return true;
		if (index_p >= p.length())
			return false;

		char pattern = p.charAt(index_p);
		if (pattern == '?')
		{
			return core(index_s + 1, index_p + 1, s, p);
		} else if (pattern == '*')
		{
			return core(index_s, index_p + 1, s, p) 
					|| (index_s < s.length() && core(index_s + 1, index_p + 1, s, p))
					|| (index_s < s.length() && core(index_s + 1, index_p, s, p));
		} else
		{
			if (index_s < s.length() && pattern == s.charAt(index_s))
				return core(index_s + 1, index_p + 1, s, p);
			else
				return false;
		}
	}

}
