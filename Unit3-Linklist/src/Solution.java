public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return head;
        if (head.val == val) {
            head = this.removeElements(head.next, val);
        } else {
            head.next = this.removeElements(head.next, val);
        }
        return head;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7};
        ListNode node = new ListNode(a);
        Solution solution = new Solution();
        ListNode res = solution.removeElements(node,2);

        System.out.println(res);
    }
}
