package LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        int index = 0;
        for(int i = 0; i<strs.length;i++){
            if(strs[i].length()<min)
                min = strs[i].length();
        }
        for(int i = 0; i<min;i++)
        {
            boolean f = true;
            for(int j = 1; j<strs.length;j++)
            {
                if(strs[j].charAt(i) != strs[j-1].charAt(i)){
                    f = false;
                    break;
                }   
            }
            if(f)
                index = i;
            else
                break;
        }
        return strs[0].substring(0,index+1);
    }
}