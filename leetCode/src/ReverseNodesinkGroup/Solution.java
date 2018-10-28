package ReverseNodesinkGroup;

import AddTwoNumbers.ListNode;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode head = solution.generateNodes();
		ListNode new_head = solution.reverseKGroup(head, 2);
	}
	
	private ListNode generateNodes()
	{
		ListNode head = new ListNode(0);
		ListNode node = head;
		for(int i = 1;i<=5;i++)
		{
			ListNode temp = new ListNode(i);
			node.next = temp;
			node = temp;
		}
		return head;
	}

	public ListNode reverseKGroup(ListNode head, int k)
	{
		if(getKNode(head,k) == null)
			return head;
		ListNode new_head = null;
		ListNode node = head;
		ListNode tail = null;
		while(node!=null)
		{
			ListNode kth_node = getKNode(node,k);
			if(kth_node == null)
			{
				tail.next = node;
				break;
			}
			
			// set the new list head
			if(new_head == null)
			{
				new_head = kth_node;
			}
			kth_node = kth_node.next;
			ListNode next = core(node, k);
			if(tail == null)
			{
				tail = node;
			}else {
				tail.next = next;
				tail = node;
			}
			
			// svae the ramin list
			node = kth_node;
		}
		return new_head;
	}
	
	private ListNode getKNode(ListNode head,int k)
	{
		if(k<=0)
			return null;
		int count = 1;
		while(count<k&&head!=null)
		{
			head = head.next;
			count++;
		}
		return head;
	}
	
	private ListNode core(ListNode head, int k)
	{
		ListNode node = head.next;
		ListNode new_head = head;
		while(k>1)
		{
			ListNode temp = node.next;
			node.next = new_head;
			new_head = node;
			node = temp;
			k--;
		}
		head.next = null;
		return new_head;
	}
}
