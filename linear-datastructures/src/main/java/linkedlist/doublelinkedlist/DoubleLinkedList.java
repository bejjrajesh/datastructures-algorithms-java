package linkedlist.doublelinkedlist;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void insertAtBeginning(T data) {
        System.out.println("Inserting " + data + " at the beginning");
        Node<T> node = new Node(data);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
        this.size++;
    }

    public void insertAtEnd(T data) {
        System.out.println("\nInserting " + data + " at the end");
        Node<T> node = new Node(data);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insertAtPosition(int position, T data) {
        System.out.println("\nInserting " + data + " at the position" + position);
        Node<T> node = new Node(data);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            Node<T> temp = head;
            for (int i = 1; i < position - 1; ++i) {
                temp = temp.getNext();
            }
            node.setPrevious(temp);
            node.setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrevious(node);
            }
            temp.setNext(node);
        }
        size++;
    }

    public void deleteFromBeginning() {
        System.out.println("\nDeleting Node from Beginning");
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            head.getNext().setPrevious(null);
            head = head.getNext();
        }
        size--;
    }

    public void deleteFromEnd() {
        System.out.println("\nDeleting Node from End");
        if (tail == null) {
            System.out.println("List is Empty");
        } else {
            tail = tail.getPrevious();
            if (tail.getNext() != null)
                tail.getNext().setPrevious(null);
            tail.setNext(null);
        }
        size--;
    }

    public void deleteFromPosition(int position) {
        System.out.println("\nDeleting Node from Position " + position);
        Node<T> temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.getNext();
        }
        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());
        size--;
    }

    public void traverseNodes() {
        Node<T> tempNode = head;
        System.out.println();
        while (tempNode != null) {
            System.out.print(" | " + tempNode.getData() + " |");
            tempNode = tempNode.getNext();
        }
        System.out.println();
    }

}
