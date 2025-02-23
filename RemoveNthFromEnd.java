class ListNode {
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

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(); 
        dummyHead.next = head;
        
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
    
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return null; 
            }
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummyHead.next;
    }
    
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n1 = 2;

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        solution.printList(result1); 
        
      
    }
}
