package Edit_Distance;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int minDistance(String word1, String word2)
	{
		if(word1.equals(word2))
			return 0;
		int m = word1.length();
		int n = word2.length();
		if(m == 0)
			return n;
		if(n == 0)
			return m;
		if(word1.charAt(0) == word2.charAt(0))
			return minDistance(word1.substring(1), word2.substring(1));
		
		return 1+Math.min(
				minDistance(word1, word2.substring(1)), Math.min(minDistance(word1.substring(1), word2),minDistance(word1.substring(1), word2.substring(1)))
				);
	}

}
