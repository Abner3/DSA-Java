/*
You're given the head of a singly linked list whose nodes are in sorted order with respect to their values. Write a function
taht returns a modified version o the Linked List that doens't contain any nodes with duplicate values.
The Linked List should be modified in place and the modified Linked List should still have its nodes sorted with respect
to their values.
 */
public class RemoveDupSingleLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList original = linkedList;
        while (linkedList != null && linkedList.next != null) {
            LinkedList nextLL = linkedList.next;
            if (linkedList.value == nextLL.value) {
                linkedList.next = nextLL.next;
                continue;
            }
            linkedList = linkedList.next;
        }

        return original;
    }
}
