package AddTwoNumbers;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode h1 = l1;
      
        ListNode h2 = l2;
        ListNode new_head = null;
        ListNode last_node = null;
        int c = 0;
        while(h1!=null|| h2!=null||c!=0)
        {
        	int num1 =0;
        	int num2 =0;
        	if(h1!=null)
        		num1 = h1.val;
        	if(h2!=null)
        		num2 = h2.val;
        	int sum = num1+num2+c;
        	c = sum/10;
        	sum = sum%10;
        	ListNode node = new ListNode(sum);
        	if(new_head == null)
        	{
        		new_head = node;
        		last_node = node;
        	}else {
				last_node.next = node;
				last_node = node;
			}
        	if(h1!=null)
        		h1 = h1.next;
        	if(h2!=null)
        		h2 = h2.next;
        }
        return new_head;
        
    }
}