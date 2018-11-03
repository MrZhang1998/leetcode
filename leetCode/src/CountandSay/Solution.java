package CountandSay;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String countAndSay = solution.countAndSay(30);
		System.out.println(countAndSay);
	}

	public String countAndSay(int n)
	{
		if (n <= 0)
			return "";
		if (n == 1)
			return "1";
		// 避免最后一个字符不判断。
		String current = "1"+"*";
		while (n > 1)
		{
			char temp = current.charAt(0);
			int num = 1;
			String next = "";
			for (int i = 1; i < current.length(); i++)
			{
				if (current.charAt(i) == current.charAt(i - 1))
				{
					num++;
				} else
				{
					next += num;
					next += temp;
					temp = current.charAt(i);
					num = 1;
				}
			}
			current = next+"*";
			n--;
		}
		return current.substring(0,current.length()-1);
	}
}
