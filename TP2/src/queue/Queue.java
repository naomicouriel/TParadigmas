
package queue;

public class Queue {
    private QueueElement queueElement;

    public Queue() {
        queueElement = new QueueEmpty();
    }

    public boolean isEmpty() {
        return queueElement.isEmpty();
    }

    public Queue add(Object cargo) {
        queueElement = queueElement.add(cargo);
        return this;
    }

    public Object take() {
        Object removed = queueElement.head();
        queueElement = queueElement.take();
        return removed;
    }

    public Object head() {
        return queueElement.head();
    }

    public int size() {
        return queueElement.size();
    }
}
