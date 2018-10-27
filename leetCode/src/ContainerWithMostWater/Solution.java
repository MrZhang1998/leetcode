/**
 * 
 */
package ContainerWithMostWater;

/**
 * @author 桃花宣
 *
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int [] height = new int[] {1,8,6,2,5,4,8,3,7};
		int result = solution.maxArea1(height);
		System.out.println(result);
	}
	
	public int maxArea1(int[] height)
	{
		int left = 0, right = height.length - 1;
		int maxArea = 0;
		
		while (left < right) {
			int h = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, h* (right - left));
			while(left<right&&height[left]<=h)
				left++;
			while(left<right&&height[right]<=h)
				right--;
		}

		return maxArea;
	}
	
	public int maxArea(int[] height)
	{
		int max = 0;
		for(int i = 0; i<height.length-1;i++)
		{
			for(int j = i+1; j<height.length;j++)
			{
				int min = height[i]>height[j]?height[j]:height[i];
				int result = (j-i)*min;
				if(result>max)
					max = result;
			}
		}
		return max;
	}

}
