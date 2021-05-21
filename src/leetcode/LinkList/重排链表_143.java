package leetcode.LinkList;

/**
 * @Author: zhaoanwei
 * @Date: 2020/10/13
 */
public class 重排链表_143 {
//    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//    示例 1:
//
//    给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//    示例 2:
//
//    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val = val; this.next = next;}
    }
    public void reorderList(ListNode head) {
        //边界判断
        if (head==null||head.next==null) return;
        //快慢指针找到链表中点
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = head;
        ListNode q = head;
        while (q!=null&&q.next!=null){
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        mergeList(head, reverseList(p));
    }

    /**
     * 反转链表
     * @param head
     */
    private ListNode reverseList(ListNode head){
        //边界判断
        if (head==null||head.next==null) return head;
        //经典三指针法
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode p = head;
        ListNode q = head.next;
        while (q!=null){
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = p.next;
        }
        return pre.next;
    }

    /**
     * 将list2交叉合并到list1
     * @param list1
     * @param list2
     */
    private void mergeList(ListNode list1, ListNode list2){
        ListNode p1 = list1;
        ListNode q1;
        ListNode p2 = list2;
        ListNode q2;
        while (p1!=null&&p2!=null){
            q1 = p1.next;
            q2 = p2.next;
            p1.next = p2;
            if (q1==null) break;
            p2.next = q1;
            p1 = q1;
            p2 = q2;
        }
    }

    public static void main(String[] args) {
//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(3);
//        ListNode list2 = new ListNode(5);
//        mergeList(list1, list2);
//        int i = 0;
    }
}
