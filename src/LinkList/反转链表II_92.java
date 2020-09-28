package LinkList;

/**
 * @Author: zhaoanwei
 * @Date: 2020/9/25
 */
public class 反转链表II_92 {
//    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//    说明:
//            1 ≤ m ≤ n ≤ 链表长度。
//
//    示例:
//
//    输入: 1->2->3->4->5->NULL, m = 2, n = 4
//    输出: 1->4->3->2->5->NULL

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val=x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //边界处理
        if (m == n) return head;
        int count = n-m;
        //pre指向m的前一个节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        int i = m;
        while (i-->1){
            pre = pre.next;
        }
        //p指向m处的节点
        ListNode p = pre.next;
        //q用来遍历
        ListNode q = p.next;
        while (count-->0){
            //将q指向的节点放到pre后
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = p.next;
        }
        return m==1?pre.next:head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(5);
        head.next = node;
        node.next = null;
        reverseBetween(head, 1, 2);
    }
}
