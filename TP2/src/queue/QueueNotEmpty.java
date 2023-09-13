package queue;

public class QueueNotEmpty extends QueueElement {

    private Object head;
    private QueueElement tail;

    public QueueNotEmpty(Object head, QueueElement tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object head() {
        return head;
    }

    public QueueElement add(Object cargo) {
        return new QueueNotEmpty(head, tail.add(cargo));
    }

    public QueueElement take() {
        return tail;
    }

    public int size() {
        return 1 + tail.size();
    }
}
