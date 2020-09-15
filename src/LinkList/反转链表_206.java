package LinkList;

import java.util.Scanner;

public class 反转链表_206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length];
        for (int i=0;i<strs.length;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i=1;i<nums.length;i++){
            p.next=new ListNode(nums[i]);
            p=p.next;
        }
        p.next=null;
        ListNode res = reverseList(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode h = new ListNode(-1);
        h.next=head;
        ListNode p = head;
        ListNode q = p.next;
        while(q!=null){
            p.next=q.next;
            q.next=h.next;
            h.next=q;
            q=p.next;
        }
        return h.next;
    }
}
