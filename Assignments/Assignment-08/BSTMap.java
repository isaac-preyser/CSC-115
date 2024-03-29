import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		try { 
			bst.find(key);
			return true;
		} catch (KeyNotFoundException e) {
			return false;
		
		} //could we do this in a one-liner? e.g. return (bst.find(key) != null);
		//well, containsKey can't throw an exception, so we need to catch it... hence this soln. 
	}

	public V get (K key) throws KeyNotFoundException {
		return bst.find(key);
	}

	public List<Entry<K,V>> entryList() {
		return bst.entryList();
	}

	public void put (K key, V value) {
		bst.insert(key, value);
	}

	public int size() {
		return bst.size();
	}

	public void clear() {
		bst.clear();
	}

}