package alg;


import common.CommonPrint;
import entity.ListNode;

public class ListAlgs {
    public static void main(String[] args) {
        ListNode head1 = CommonPrint.generateList(5);
        ListNode head2 = CommonPrint.generateList(5);
        ListNode head = mergeTwoLists(head1, head2);
        CommonPrint.printList(head);

    }

    /**
     * 反转单连表
     * @param head 表头（有数据）
     * @return 单链表表头（没数据）
     */
    public static ListNode reverseSingleList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode rst = new ListNode();
        ListNode p = head;
        ListNode q = head.next;
        while(p != null){ // 头插法
            p.next = rst.next;
            rst.next = p;
            p = q;
            if(q != null){
                q = q.next;
            }
        }
        return rst;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return 合并后的链表头（无数据）
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode rst = new ListNode();
        ListNode worker1 = rst;
        while (p1 != null && p2 != null){
            if(p1.val <= p2.val){
                worker1.next = p1;
                p1 = p1.next;
                worker1 = worker1.next;
            }
            else{
                worker1.next = p2;
                p2 = p2.next;
                worker1 = worker1.next;
            }
        }
        if(p1 != null){ // l1还有剩余
            worker1.next = p1;
        }
        if(p2 != null){ // l2还有剩余
            worker1.next = p2;
        }
        return rst;
    }
}
