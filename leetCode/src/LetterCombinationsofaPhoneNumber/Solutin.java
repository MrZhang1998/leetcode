package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solutin
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solutin solutin = new Solutin();
		List result = solutin.letterCombinations("89");
		System.out.println(result);
	}
	
	private ArrayList<Character> alphabet = new ArrayList<Character>();
	private ArrayList<String> result = new ArrayList<String>();
	public List<String> letterCombinations(String digits)
	{
		// init alphabet
		for(char i = 'a';i<='z';i++)
		{
			alphabet.add(i);
		}
		char[] temp = new char[digits.length()];
		core(0, digits.toCharArray(), temp);
		return result;
	}
	
	private void core(int index,char[] array,char [] temp)
	{
		if(index == array.length)
		{
			result.add(new String(temp));
			return;
		}
		int n = array[index]-'0';
		if(n==1)
		{
			temp[index] = ' ';
			core(index+1, array, temp);
		}else if(n<=6)
		{
			for(int i = (n-2)*3;i<(n-2)*3+3;i++)
			{
				temp[index] = alphabet.get(i);
				core(index+1, array, temp);
			}
		}else if(n == 7)
		{
			for(int i = (n-2)*3;i<(n-2)*3+4;i++)
			{
				temp[index] = alphabet.get(i);
				core(index+1, array, temp);
			}
		}else if(n == 8)
		{
			for(int i = (n-2)*3+1;i<(n-2)*3+4;i++)
			{
				temp[index] = alphabet.get(i);
				core(index+1, array, temp);
			}
		}else {
			for(int i = (n-2)*3+1;i<(n-2)*3+5;i++)
			{
				temp[index] = alphabet.get(i);
				core(index+1, array, temp);
			}
		}
	}

}
