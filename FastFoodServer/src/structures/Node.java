package structures;

public class Node<T> {
	 T data;
	 Node<T> left, right;
	 
	 public Node(T data) {
		 this.data = data;
		 this.left = null;
		 this.right = null;
	 }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return this.left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return this.right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
	 
}
