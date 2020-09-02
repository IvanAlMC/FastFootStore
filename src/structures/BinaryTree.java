package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<T> implements Iterable<T>{
	private Node<T> root;
	private Comparator<T> comparator;

	public BinaryTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}
	
	public T getData(T key) {
	      return search(key, root);
	}
	
	public T search(T key, Node<T> nodo) {
	      if (nodo==null) {
	    	  return null;
	      }
	      else if (key==nodo.getData()) {
	    	  return nodo.getData();
	      }
	       
	      else if (comparator.compare(key, nodo.getData())<0) {
	    	  return search(key, nodo.getLeft());
	      }
	        
	      else {
	        return search(key, nodo.getRight());
	      }
	    }
	
	public void insert(T data) {
		Node<T> myNew = new Node<T>(data);
		if(root == null) {
			root = myNew;
		}else {
			Node<T> aux = root;
			Node<T> father;
			while(true) {
				father = aux;
				if(comparator.compare(data, aux.getData())<0) {
					aux=aux.getLeft();
					if(aux==null) {
						father.setLeft(myNew);
						return;
					}
				}else {
					aux=aux.getRight();
					if(aux==null) {
						father.setRight(myNew);
						return;
					}
				}
			}
		}
	}
	
	public boolean search1(T data) {
		return search(root, data);
	}
	
	public boolean search(Node<T> node, T data)
	{
	    if(node!=null)
	    {
	        if(comparator.compare(node.getData(), data)==0) return true;
	        boolean bus1 = search(node.getLeft(), data);
	        boolean bus2 = search(node.getRight(), data);
	        if((bus1 == true)||(bus2 == true))return true;
	    }
	    return false;
	}
	
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public Node<T> search(T data) {
		Node<T> aux = root;
		while(comparator.compare(aux.getData(),data)!=0) {
			if(comparator.compare(data, aux.getData())>0) {
				aux=aux.getLeft();
			}else{
				aux=aux.getRight();
			}
			if(aux==null) {
				return null;
			}
		}
		return aux;
	}
	
	
	public boolean exist(T data) {
	    return exist(this.root, data);
	}

	private boolean exist(Node<T> node, T data) {
	    if (node == null) {
	        return false;
	    }
	    if (comparator.compare(node.getData(), data)==0) {
	        return true;
	    } else if (comparator.compare(data, node.getData())>0) {
	        return exist(node.getLeft(), data);
	    } else {
	        return exist(node.getRight(), data);
	    }
	}
	
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public List<T> getPreOrder(){
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return list;
	}
	

	public void preOrder(Node<T> node, List<T> list) {
		if(node!=null) {
			list.add(node.getData());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}
	}
	
	public String showPreOrder() {
		List<T> list = getPreOrder();
		String string = "-";
		for(T data: list) {
			string += data + "-";
		}
		return string;
	}
	
	public int countPreOrder() {
		List<T> list = getPreOrder();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			count ++;
		}
		return count;
	}
	
	public List<T> getInOrder(){
		List<T> list = new ArrayList<T>();
		inOrder(root, list);
		return list;
	}
	

	public void inOrder(Node<T> node, List<T> list) {
		if(node!=null) {
			inOrder(node.getLeft(), list);
			list.add(node.getData());;
			inOrder(node.getRight(), list);
		}
	}
	
	public String showInOrder() {
		List<T> list = getInOrder();
		String string = "-";
		for(T data: list) {
			string += data + "-";
		}
		return string;
	}
	
	
	public List<T> getPostOrder(){
		List<T> list = new ArrayList<T>();
		postOrder(root, list);
		return list;
	}
	

	public void postOrder(Node<T> name, List<T> list) {
		if(name!=null) {
			postOrder(name.getLeft(), list);
			postOrder(name.getRight(), list);
			list.add(name.getData());;
		}
	}
	
	public String showPostOrder() {
		List<T> list = getPostOrder();
		String string = "-";
		for(T data: list) {
			string += data + "-";
		}
		return string;
	}
	
	
	
	public void delete(T data) {
		root = deleteNode(root, data);
	}
	
	private Node<T> deleteNode(Node<T> aux, T data){
		if(aux==null) {
			return null;
		}else if(comparator.compare(data, aux.getData())<0){
			Node<T> left = deleteNode(aux.getLeft(), data);
			aux.setLeft(left);
		}else if(comparator.compare(data, aux.getData())>0) {
			Node<T> rigth = deleteNode(aux.getRight(), data);
			aux.setRight(rigth);
		}else {
			Node<T> temp = aux;
			if(temp.getRight() == null) {
				aux = temp.getLeft();
			}else if(temp.getLeft() == null) {
				aux = temp.getRight();
			}else {
				temp = change(temp);
			}
			temp = null;
		}
		return aux;
	}
	
	private Node<T> change(Node<T> aux){
		Node<T> temp = aux;
		Node<T> temp2 = aux.getLeft();
		while(temp2.getRight()!=null) {
			temp = temp2;
			temp2 = temp2.getRight();
		}
		aux.setData(temp2.getData());
		if(temp == aux) {
			temp.setLeft(temp2.getLeft());
		}else {
			temp.setRight(temp2.getLeft());
		}
		return temp2;
	}
	
	public String showList(BinaryTree<Integer> list) {
		String datas = "-";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			datas += iterator.next().toString()+ "-";
		}
		return datas;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(root);
	}
}
