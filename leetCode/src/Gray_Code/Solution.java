package Gray_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		solution.grayCode(3);
	}

	public List<Integer> grayCode(int n)
	{
		List<Integer> list = new ArrayList<Integer>();
		if (n < 0)
			return list;
		if (n == 0)
		{
			list.add(0);
			return list;
		}
		char[] chars = new char[n];
		Arrays.fill(chars, '0');
		core(0, chars, list);
		return list;
	}

	private void core(int start, char[] chars, List<Integer> list)
	{
		if (start == chars.length)
		{
			String str = new String(chars);
			System.out.println(str);
			int num = parse(str);
			list.add(num);
		} else
		{
			core(start + 1, chars, list);
			flip(chars, start);
			core(start + 1, chars, list);
		}

	}

	private void flip(char[] chars, int start)
	{
		if (chars[start] == '0')
			chars[start] = '1';
		else
			chars[start] = '0';
	}

	private int parse(String str)
	{
		int result = 0;
		int pow = 1;
		for (int i = str.length() - 1; i >= 0; i--)
		{
			int num = str.charAt(i) - '0';
			result = result + num * pow;
			pow *= 2;
		}
		return result;
	}
}