package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

List<Queue> fila = new ArrayList<>();

  public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (fila.size() == 0) {
			return true;
		};
		{
			return false;
		}
	}

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
	    Queue fila = new Queue();
		fila.add(cargo);
		return fila;
	}

	public Object take() {
    // TODO Auto-generated method stub
		return null;
	}

	public Object head() {
		// TODO Auto-generated method stub
		return fila.get(0);
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
