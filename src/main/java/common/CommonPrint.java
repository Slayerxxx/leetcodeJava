package common;

import entity.ListNode;


public class CommonPrint {
    private CommonPrint(){}

    /**
     * 生产长度为len的链表
     * @param len
     * @return
     */
    public static ListNode generateList(int len){
        if(len <= 0){
            return null;
        }
        int val = (int)(Math.random() * 10 + 1);
        ListNode head = new ListNode(val);
        ListNode p = head;

        for(int i=1; i<len; i++){
            val += (int)(Math.random() * 10 + 1);
            ListNode cur = new ListNode(val);
            p.next = cur;
            p = p.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head){
        ListNode p = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(p != null){
            stringBuilder.append(p.val);
            stringBuilder.append(",");
            p = p.next;
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length()-1));
    }
}
