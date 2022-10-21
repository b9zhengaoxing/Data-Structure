import org.w3c.dom.NodeList;

public class SolutionLinklist {

    private ListNode dummyHead;

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

    public SolutionLinklist() {
        this.dummyHead = new ListNode();
    }

    public void addFirst(int val) {
        dummyHead.next = new ListNode(val, dummyHead.next);
    }


    public ListNode removeElements(ListNode head, int val) {


        //代码分开，逻辑简单了
        while (head != null && head.val == val)
            head = head.next;

        //header 推到后面了
        if (head == null)
            return null;

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val){//删除了这个不跳next
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return head;

//        while (pre != null) {
//            if (head.val == val) {
//                head = head.next;
//            } else if (pre.next != null) {
//                if (pre.next.val == val) {
//                    pre.next = pre.next.next;
//                    continue;//结束本次循环，开始下次循环 break 直接干掉
//                }
//            }
//            pre = pre.next;
//        }
//        return head;
    }

    public ListNode removeElementsDummyhead(ListNode head, int val) {

        ListNode dummyheader = new ListNode(0, head);
        ListNode pre = dummyheader;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyheader.next;
    }

    public ListNode removeElementsRecurion(ListNode head, int val) {

        if (head == null) return head;
        if (head.val == val) {
            head = this.removeElementsRecurion(head.next, val);
        } else {
            head.next = this.removeElementsRecurion(head.next, val);
        }
        return head;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("linklist: ");
        ListNode node = dummyHead.next;
        while (node != null) {
            res.append(node.val + " -> ");
            node = node.next;
        }
        res.append("null");
        return res.toString();
    }


    public String toStringList(ListNode head) {

        StringBuilder res = new StringBuilder();
        res.append("linklist: ");
        ListNode node = head;
        while (node != null) {
            res.append(node.val + " -> ");
            node = node.next;
        }
        res.append("null");
        return res.toString();
    }


    public static void main(String[] args) {
        SolutionLinklist list = new SolutionLinklist();
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(2);
        ListNode node;
        node = list.removeElements(list.dummyHead.next, 2);
//        node = list.removeElementsDummyhead(list.dummyHead.next, 2);
//        ListNode node = list.removeElementsRecurion(list.dummyHead.next, 2);
        System.out.println(list.toStringList(node));
    }
}
