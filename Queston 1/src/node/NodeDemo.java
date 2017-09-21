package node;

public class NodeDemo {

    /**
     * This method reverses a single link list and returns the new head of the reversed list.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * @param head head of the list
     * @return head of the reversed list
     */

    public Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
