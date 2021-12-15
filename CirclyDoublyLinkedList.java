public class CirclyDoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode createCDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    public void insertCDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
            return;
        }
        if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index != location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;

        }
    }

    public void traverseCDLL() {
        DoublyNode tempNode = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                System.out.println(tempNode.value);
                System.out.println(tempNode.value);
                if (i != size - 1) {
                    System.out.println(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("Does not exist");
        }
    }

    public void traverseReverseCDLL() {
        DoublyNode tempNode = tail;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (i != size - 1) {
                    System.out.println(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("Does not exist");
        }
    }

    public boolean searchCDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The CDLL does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
                return;
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        } else {
            DoublyNode tempNode = new DoublyNode();
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public void deleteCDLL() {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;

    }
}
