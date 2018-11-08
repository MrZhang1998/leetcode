package Pow_x_n;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		double myPow = solution.myPow(34.00515, -3);
		System.out.println(myPow);
	}

	public double myPow(double x, int n)
	{
		if(n == 0)
			return 1;
		double t = myPow(x, n/2);
		if(Math.abs(n)%2 == 1)
		{
			return n<0?1/x*t*t:(x*t*t);
		}else {
			return t*t;
		}
	}
	
	

}
