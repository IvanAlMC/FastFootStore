package structures;

public class QueuNode<T> {
	private T data;
	private QueuNode<T> next;
	
	public QueuNode(T data){
		this.data = data;
		this.next = null;
	} 
	
	public T getData() {
		return this.data;
	}
	
	public QueuNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(QueuNode<T> node) {
		this.next = node;
	}
}
