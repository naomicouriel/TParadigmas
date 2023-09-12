package queue;
import java.util.ArrayList;
import java.util.List;

public class Queue {

    private List<Object> fila = new ArrayList<>();

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public Queue add(Object cargo) {
        fila.add(cargo);
        return this;
    }

    public Object take() {
        assert !fila.isEmpty() : "Queue is empty";
        return fila.remove(0);
    }

    public Object head() {
        assert !fila.isEmpty() : "Queue is empty";
        return fila.get(0);
    }

    public int size() {
        return fila.size();
    }
}
