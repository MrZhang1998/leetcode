package 最长不重复子串;

import java.util.HashSet;
import java.util.Set;

class Solution {
	
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int length = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for(int j = 0; j<array.length;j++)
        {
        	 for(int i =j ; i<array.length;i++)
             {
             	if(!set.contains(array[i]))
             	{
             		set.add(array[i]);
             		length++;
             	}else {
     				max = max>length?max:length;
     				set.clear();
     				break;
     			}
             }
        }
       
        return Math.max(length, max);
    }
    
    public int lengthOfLongestSubstring2(String s) {
    	int i = 0; int j = 0;
    	Set<Character> set = new HashSet<Character>();
    	int max = 0;
    	while(i<s.length()&&j<s.length())
    	{
    		if(!set.contains(s.charAt(j)))
    		{
    			set.add(s.charAt(j++));
    			max = Math.max(max, j-i);
    		}else {
				set.remove(s.charAt(i++));
			}
    	}
    	return max;
    }
}
