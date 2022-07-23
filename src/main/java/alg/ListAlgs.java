package alg;


import common.CommonPrint;
import entity.ListNode;

public class ListAlgs {
    public static void main(String[] args) {
        ListNode head1 = CommonPrint.generateList(5);
        ListNode end = head1;
        while(end.next != null){
            end = end.next;
        }

        CommonPrint.printList(mergeSort(head1, end));

    }

    /**
     * 反转单链表
     * 相关例题：
     * 234. 回文链表
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
     * 相关例题：
     * 23. 合并K个升序链表 hard
     * 148. 排序链表 medium
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

    /**
     * 单链表归并排序
     * @param start 排序起始节点
     * @param end   排序结束节点
     * @return
     */
    public static ListNode mergeSort(ListNode start, ListNode end){
        if(start == end){
            start.next = null;  // 每个节点都断开
            return start;
        }
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end){
            fast = fast.next;
            if(fast != end){
                fast = fast.next;
                slow = slow.next;
            }
        }
        ListNode mid = slow;
        ListNode midNext = mid.next;
        ListNode list1 = mergeSort(start, mid);
        ListNode list2 = mergeSort(midNext, end);
        return mergeTwoLists(list1, list2).next;
    }
}
