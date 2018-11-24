package Beautiful_Array;

import java.util.ArrayList;

class Solution
{
	public int[] beautifulArray(int N)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		while(res.size()<N)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int num : res)
				if(num*2-1<=N)
					temp.add(num*2-1);
			for(int num : res)
				if(num*2 <=N)
					temp.add(num*2);
			res = temp;
		}
		int[] array = new int[N];
		for(int i = 0; i<res.size();i++)
		{
			array[i] = res.get(i);
		}
		return array;
	}
}
