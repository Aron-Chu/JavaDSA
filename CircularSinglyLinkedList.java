public class CircularSinglyLinkedList {
    // public class Node {
    // public Node next;
    // public int value;
    // }
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;

    }

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCSLL(nodeValue);
            return;
        }
        if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;

    }

    public void traverseCSLL() {
        Node tempNode = head;
        if (head == null) {
            System.out.println("CSLL does not exist");
        }
        for (int i = 0; i < size; i++) {
            tempNode = tempNode.next;
            System.out.println(tempNode.value);
            if (i != size - 1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");

    }

    public boolean searchCSLL(int nodeValue) {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public void deleteCSLL(int location) {
        if (head == null) {
            System.out.println("The CSLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;

        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;

            }
            tempNode.next = tempNode.next.next;
        }
    }

    public void deleteEntireCSLL() {
        if (head == null) {
            System.out.println("The CSLL does not exist!");
        }
        head = null;
        tail.next = null;
        tail = null;

    }
}