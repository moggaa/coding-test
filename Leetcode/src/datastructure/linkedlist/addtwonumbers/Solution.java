package datastructure.linkedlist.addtwonumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode currentPointer = answer;
        int overSum = 0;
        while (l1 != null || l2 !=null){
            currentPointer.next = new ListNode(0);
            currentPointer = currentPointer.next;

            int totalSum = 0;
            totalSum += l1 != null ? l1.val:0;
            totalSum += l2 != null ? l2.val:0;
            totalSum += overSum;
            currentPointer.val = totalSum % 10;
            overSum = totalSum/10;


            l1 = l1!= null ? l1.next : l1;
            l2 = l2!= null ? l2.next : l2;

        }
        if (overSum != 0){
            currentPointer.next = new ListNode(overSum);
        }
        return answer.next;
    }

}