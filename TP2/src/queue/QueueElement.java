package queue;

public abstract class QueueElement {
	public abstract boolean isEmpty();
    public abstract Object head();
    public abstract QueueElement take();
    public abstract QueueElement add(Object cargo);
    public abstract int size();
}
