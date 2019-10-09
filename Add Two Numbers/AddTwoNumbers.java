package leetcode;

import java.util.ArrayList;

/**
 *
 * @author KPeggy
 * 2. Add Two Numbers Accept. Runtime: 3 ms, Memory Usage: 44.3 MB
 * https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers {
    public AddTwoNumbers(){
        int[] testCase = {2,3,1};
        int[] testCase2 = {1,8};
        ListNode ex1 = getListNode(testCase);
        ListNode ex2 = getListNode(testCase2);
        
        ListNode ans = addTwoNumbers(ex1,ex2);
        while(ans != null){
           System.out.print(ans.val);
           ans = ans.next;
           if(ans != null) System.out.print("->");
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerList;
        int carry = 0, sum = 0;
        ArrayList ans = new ArrayList();
                
        while(l1!=null || l2!=null){
            int first_val = (l1 != null) ? l1.val : 0;
            int second_val = (l2 != null) ? l2.val : 0;
            sum = first_val + second_val + carry;
            carry = sum / 10;
            ans.add(sum % 10);
            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
            if(l1 == null && l2 ==null && carry >0) ans.add(carry); //Special Case about [5], [5]
        }
        answerList = convertToListNode(ans);
        return answerList;
    }
    
    public ListNode getListNode(int[] testCase) { //Declade TestCase
        ListNode obj[] = new ListNode[testCase.length] ; 
        for(int i=0;i<testCase.length;i++){
            obj[i] = new ListNode(testCase[i]);           
        }
        for(int i =0;i<obj.length;i++){
            if(i+1 != obj.length) obj[i].next = obj[i+1];
        }
        ListNode head = obj[0];
        return head;
    }
    
    public ListNode convertToListNode(ArrayList ans){ //Convert Ans ArrayList to ListNode
        ListNode obj[] = new ListNode[ans.size()] ; 
        for(int i=0;i<ans.size();i++){
            obj[i] = new ListNode((int) ans.get(i));           
        }
        for(int i =0;i<obj.length;i++){
            if(i+1 != obj.length) obj[i].next = obj[i+1];
        }
        ListNode head = obj[0];
        return head;
    }
    
    public class ListNode { // Problem's Definition for singly-linked list.
     int val;
     ListNode next;
     ListNode(int x) { val = x; }    
    }

}
