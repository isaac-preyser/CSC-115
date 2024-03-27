import java.util.LinkedList;
import java.util.List;

public class ListMap<K extends Comparable<K>, V > implements Map<K, V> {
	//suppress cannot be resolved
	Node<K, V> head;
	int numElements;
	
	public ListMap() {
		head = null;
		numElements = 0;
	}
	
	public void put (K key, V value) {
		if (head == null) {
			head = new Node<K,V>(key, value);
			numElements++;
		} else { 
			Node<K,V> cur = head;
			Node<K,V> prev = null;
			while (cur != null){
				if (cur.key.compareTo(key) == 0) {
					cur.setValue(value);
				} else {
					prev = cur; 
					cur = cur.next;
				}
			}
			prev.next = new Node<K,V>(key, value);
			numElements++;

		}
	}
	
	public int size() {
		return numElements;
	}
	
	public void remove (K key) {
		if (head == null){
			return; 
		} else if (head.getKey().compareTo(key) == 0){
			head = head.next;
			numElements--;
		} else {
			Node<K,V> cur = head;
			Node<K,V> prev = null;
			while (cur != null && cur.getKey().compareTo(key) != 0) {
				prev = cur;
				cur = cur.next;
			}
			if (cur != null) {
				prev.next = cur.next;
				numElements--;
			}
		
		}
	}

	public void clear() {
		head = null;
		numElements = 0;
	}
	
	public boolean containsKey(K key) {
		Node<K,V> cur = head;
		boolean found = false;
		while (cur != null && found == false) {
			if (cur.key.compareTo(key) == 0) {
				found = true;
			}
			cur = cur.next;
		}
		return found;
	}

	public V get (K key) throws KeyNotFoundException {
		Node<K,V> cur = head;
		boolean found = false;
		while (cur != null && found == false) {
			if (cur.key.compareTo(key) == 0) {
				found = true;
			} else {
				cur = cur.next;
			}
		}
		if (found) {
			return cur.value;
		} else {
			throw new KeyNotFoundException();
		}
	}
	
	public List<Entry<K,V>> entryList() {
		List<Entry<K,V>> entries = new LinkedList<Entry<K, V>>();
		Node<K,V> cur = head;
		while (cur != null) {
			entries.add(new Entry<K,V>(cur.getKey(), cur.getValue()));
			cur = cur.next;
		}
		return entries;
		

	}
	
}