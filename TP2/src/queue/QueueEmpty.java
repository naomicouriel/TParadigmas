package queue;

public class QueueEmpty extends QueueElement {
	
	public static String queueIsEmpty = "Queue is empty";

    public boolean isEmpty() {
        return true;
    }

    public Object head() {
        throw new RuntimeException(queueIsEmpty);
    }

    public QueueElement add(Object cargo) {
        return new QueueNotEmpty(cargo, this);
    }

    public QueueElement take() {
        throw new RuntimeException(queueIsEmpty);
    }

    public int size() {
        return 0;
    }
}
