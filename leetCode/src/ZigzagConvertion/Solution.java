package ZigzagConvertion;
public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String string = solution.convert("AB", 1);
		System.out.println(string);
		
	}

	public String convert(String s, int numRows)
	{
		if (s.equals(""))
			return "";
		if(numRows == 1)
			return s;
		char[][] chars = new char[numRows][s.length()];
		for (int i = 0; i < chars.length; i++)
		{
			for (int j = 0; j < chars[0].length; j++)
			{

				chars[i][j] = (char) -1;
			}
		}
		int x = 0;
		int y = 0;
		int x_offset = 1;
		int y_offset = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char temp = s.charAt(i);
			if (x == 0)
			{
				x_offset = 1;
				y_offset = 0;
			} else if (x == numRows - 1)
			{
				x_offset = -1;
				y_offset = 1;
			}
			chars[x][y] = temp;
			x += x_offset;
			y += y_offset;
		}

		char[] new_chars = new char[s.length()];
		int index = 0;
		for (int i = 0; i < chars.length; i++)
		{
			for (int j = 0; j < chars[0].length; j++)
			{
				if (chars[i][j] != (char) -1)
					new_chars[index++] = chars[i][j];
			}
		}
		return new String(new_chars);
	}

}
