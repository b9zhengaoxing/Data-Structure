public class Solution {

    private ListNode head;
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public Solution(){
        this.head = null;
    }
    public void addFirst(int val){
        head = new ListNode(val,head);
    }


    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return head;

        ListNode pre = head;
        while (pre != null){
            if(head.val == val){
                head = head.next;
            }else if(pre.next != null){
                if (pre.next.val == val){
                    pre.next = pre.next.next;
                    continue;//结束本次循环，开始下次循环 break 直接干掉
                }
            }
            pre = pre.next;
        }
        return head;
    }

    public ListNode removeElementsDummyhead(ListNode head, int val) {

        if (head == null) return head;

        ListNode pre = head;
        while (pre != null){
            if(head.val == val){
                head = head.next;
            }else if(pre.next != null){
                if (pre.next.val == val){
                    pre.next = pre.next.next;
                    continue;
                }
            }
            pre = pre.next;
        }
        return head;
    }

    public ListNode removeElementsRecurion(ListNode head, int val) {

        if (head == null) return head;

        ListNode pre = head;
        while (pre != null){
            if(head.val == val){
                head = head.next;
            }else if(pre.next != null){
                if (pre.next.val == val){
                    pre.next = pre.next.next;
                    continue;
                }
            }
            pre = pre.next;
        }
        return head;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("linklist: ");
        ListNode node = head;
        while (node != null){
            res.append(node.val + " -> ");
            node = node.next;
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("1111");
        Solution list = new Solution();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(1);
        list.removeElements(list.head,2);
        System.out.println(list);


        System.out.println("1111");
    }
}
