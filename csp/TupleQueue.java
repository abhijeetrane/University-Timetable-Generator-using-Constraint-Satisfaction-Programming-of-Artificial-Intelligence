package csp;

import java.util.LinkedList;
import java.util.List;
public class TupleQueue  {
	protected LinkedList<List <String>> linkedList;

	public TupleQueue () {
		linkedList = new LinkedList<List<String>>();
	} 

	public void addToFront(List<String> n) {
		linkedList.addFirst(n);
	}

	public void addToBack(List<String> n) {
		linkedList.addLast(n);
	}

	
	public List<String> removeFirst() {
		return (List<String>)(linkedList.removeFirst());
	}

	public List<String> removeLast() {
		return (List<String>)(linkedList.removeLast());
	}

	 public List<String> get(int index){
		 return ((List<String>)linkedList.get(index) );
	 }
	public List<String> getFirst() {
		return ((List<String>)(linkedList.getFirst()));
	}

	public List<String> getLast() {
		return (List<String>)(linkedList.getLast());
	}

	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	public int size() {
		return linkedList.size();
	}

	public List asList() {
		return linkedList;
	}

}