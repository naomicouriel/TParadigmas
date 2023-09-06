package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

private List<Object> fila = new ArrayList<>();

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
		fila.add(cargo);
		return this;
	}

	public Object take() {
    // TODO Auto-generated method stub
		fila.clear();
		return this;
	}

	public Object head() {
		// TODO Auto-generated method stub
		if (fila.size() ==0) {
			return this;
		}
		
		return fila.get(0);
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
