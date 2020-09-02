package structures;

import java.util.Comparator;
import java.util.Iterator;

public class QueuList<T> implements Iterable<T>{
	private QueuNode<T> head;
	private Comparator<T> comparator;
	
	public QueuList(Comparator<T> comparator) {
		head=null;
		this.comparator = comparator;
	}
	
	public T search(T data) {
		boolean exist = false;
		T myData = null;
		QueuNode<T> aux = head;
		while(aux!=null && !exist) {
			if(comparator.compare(aux.getData(), data)==0) {
				exist = true;
				myData = aux.getData();
			}else {
				aux = aux.getNext();
			}
		}
		return myData;
	}
	
	public void push(T data) {
		if(head == null) {
			head = new QueuNode<T>(data);
		}else {
			QueuNode<T> temp = head;
			QueuNode<T> myNew = temp;
			while (temp != null) {
				myNew = temp;
				temp = temp.getNext();
			}
			QueuNode<T> aux = new QueuNode<T>(data);
			myNew.setNext(aux);
		}
	}
	
	public T poll() {
		if(isEmpty()) {
			return null;
		}else {
		T aux = head.getData();
		head = head.getNext();
		return aux;
		}
	}
	
	public T get(int index) {
		if(isEmpty()) {
			return null;
		}else {
			QueuNode<T> pointer = head;
			int count = 0;
			while(count < index && pointer.getNext() != null) {
				pointer = pointer.getNext();
				count++;
			}
			if(count != index) {
				return null;
			}else {
				return pointer.getData();
			}
		}
	}
	
	public T peek() {
		return head.getData();
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public boolean exist(T data) {
		boolean exist = false;
		QueuNode<T> aux = head;
		while(aux!=null && !exist) {
			if(comparator.compare(aux.getData(), data)==0) {
				exist = true;
			}else {
				aux = aux.getNext();
			}
		}
		return exist;
	}
	
	public String show() {
		String string = "";
			if(isEmpty()==true) {
				string = "La lista esta vacia";
			}else {
				QueuNode<T> aux = head;
				while(aux!=null) {
					string += aux.getData();
					aux = aux.getNext();
				}
			}
		return string;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIteratorQueue<T>(head);
	}
}
