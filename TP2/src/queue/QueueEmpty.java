package queue;

public class QueueEmpty extends QueueElement {

    public boolean isEmpty() {
        return true;
    }

    public Object head() {
        throw new Error("Queue is empty");
    }

    public QueueElement add(Object cargo) {
        return new QueueNotEmpty(cargo, this);
    }

    public QueueElement take() {
        throw new Error("Queue is empty");
    }

    public int size() {
        return 0;
    }
}
