package structures;

import java.util.Iterator;

import structures.QueuNode;

public class MyIteratorQueue<T> implements Iterator<T>{
	private QueuNode<T> actual;

	public MyIteratorQueue(QueuNode<T> node) {
		actual = node;
	}

	@Override
	public boolean hasNext() {
		return actual != null;
	}

	@Override
	public T next() {
		T element = actual.getData();
		actual = actual.getNext();
		return element;
	}
}
