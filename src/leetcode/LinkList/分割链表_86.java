package leetcode.LinkList;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/8
 */
public class 分割链表_86 {
//    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//    你应当 保留 两个分区中每个节点的初始相对位置。
//
//    示例 1：
//    输入：head = [1,4,3,2,5,2], x = 3
//    输出：[1,2,2,4,3,5]
//
//    示例 2：
//    输入：head = [2,1], x = 2
//    输出：[1,2]
//             
//    提示：
//
//    链表中节点的数目在范围 [0, 200] 内
//        -100 <= Node.val <= 100
//        -200 <= x <= 200
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        if (head==null) return null;
        //确定最终头节点
        ListNode node = head;
        while (node.val>=x) {
            node = node.next;
            if (node==null) return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        ListNode q = head;
        int len=1;
        while (q.next!=null) {
            q = q.next;
            len++;
        }
        while (len-->0) {
            if (p.val>=x) {
                if (p==q) break;
                pre.next=p.next;
                q.next=p;
                p.next=null;
                p=pre.next;
                q=q.next;
            }else {
                pre=pre.next;
                p=p.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(0);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(2);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        ListNode partition = partition(head1, 2);
        int i = 0;


    }
}
