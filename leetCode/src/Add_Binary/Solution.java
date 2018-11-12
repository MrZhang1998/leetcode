package Add_Binary;

class Solution
{
	public String addBinary(String a, String b)
	{
		int c = 0;
		int i = a.length() - 1;
		int j = b.length() -1;
		String result = "";
		while (i>=0&&j>=0)
		{
			int num_a = a.charAt(i) - '0';
			int num_b = b.charAt(j) - '0';
			int add = num_a + num_b + c;
			c = add / 2;
			add = add % 2;
			result  = add + result;
			i--;
			j--;
		}
		while(i>=0)
		{
			int num_a = a.charAt(i) - '0';
			int add = num_a + c;
			c = add / 2;
			add = add % 2;
			result  = add + result;
			i--;
		}
		while(j>=0)
		{
			int num_b = b.charAt(j) - '0';
			int add = num_b + c;
			c = add / 2;
			add = add % 2;
			result  = add + result;
			j--;
		}
		if(c!=0)
		{
			result = c+result;
		}
		return result;
	}
}
