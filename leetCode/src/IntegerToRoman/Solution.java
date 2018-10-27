package IntegerToRoman;

public class Solution
{
	private String[] thousand = { "","M", "MM", "MMM" };
	private String[] hundred = { "","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	private String[] ten = { "","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private String[] one = { "","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.intToRoman(3));
	}

	public String intToRoman(int num)
	{
		if(num<=0)
			return "";
		String result = "";
		int index = 0;
		while(num!=0)
		{
			switch (index)
			{
			case 0:
				result = one[num%10]+result;
				break;

			case 1:
				result = ten[num%10]+result;
				break;
			case 2:
				result = hundred[num%10]+result;
				break;
			case 3:
				result = thousand[num%10]+result;
				break;
			}
			num/=10;
			index++;
		}
		return result;
	}
}
