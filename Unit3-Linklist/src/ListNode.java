public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //use array init
    public ListNode(int[] val) {
        if (val == null || val.length == 0) {
            throw new IllegalArgumentException("ListNode error; val array is Empty!");
        }

        this.val = val[0];
        ListNode cur = this;
        for (int i = 1; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("LinkList:");
        ListNode head = this;
        while (head != null){
            res.append( head.val + "->");
            head = head.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        ListNode node = new ListNode(a);
        System.out.println(node);
    }
}
