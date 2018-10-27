package 倒数第K个节点;

import java.awt.List;

import AddTwoNumbers.ListNode;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode node2 = new ListNode(2, null);
		ListNode node1 = new ListNode(1, node2);
		
		solution.removeNthFromEnd(node1, 2);
	}
	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode node1 = head;
	        ListNode node2 = head;
	        while(n>0)
	        {
	            node1 = node1.next;
	            n--;
	        }
	        // n = nodes length 
	        if(node1 == null)
	        {
	        	// 长度为一 返回空
	        	if(node2.next == null)
	        		return null;
	        	// 长度不为一 
	        	else
	        		return head.next;
	        	
	        }
	        while(node1.next!=null)
	        {
	            node1 = node1.next;
	            node2 = node2.next;
	        }
	        
	        ListNode next = node2.next.next;
	        node2.next = next;
	        
	        return head;
	        
	    }

}
