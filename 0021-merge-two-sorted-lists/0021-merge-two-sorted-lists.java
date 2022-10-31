/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode assembler ;
        ListNode otherListPointer ;
        ListNode headMerged ;

        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            headMerged = list1;
            assembler = list1;
            otherListPointer = list2;
          }else {
            headMerged = list2;
            assembler = list2;
            otherListPointer = list1;
          }

        while (assembler.next!=null && otherListPointer!=null){

            if (assembler.next.val<=otherListPointer.val){
                assembler = assembler.next;
            }else {
                ListNode tempNode = assembler.next;
                assembler.next = otherListPointer;
                otherListPointer = tempNode;
            }
        }

        if (assembler.next == null){
            assembler.next = otherListPointer;
        }

          return headMerged;
    }
}