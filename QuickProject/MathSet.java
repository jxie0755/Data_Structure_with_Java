import java.util.HashMap;
import java.util.Map;

// Hint: use a symbol table provided in JDK and a boolean array.
public class MathSet<Key> {
	private Map<Key, Boolean> content;

	// create a set
	public MathSet(Key[] universe) {
		this.content = new HashMap<>();
		for (Key element : universe) {
			this.content.put(element, false);
		}
	}

	// put key into the set
	public void add(Key key) {
		this.content.replace(key, true);
	}

	// return set of keys in the universe that are not in the set
	public MathSet<Key> complement() {
		Object[] new_universe = this.content.keySet().toArray();
		MathSet<Key> comp = new MathSet<>((Key[]) new_universe);
		for (Key element : this.content.keySet()) {
			if (!this.content.get(element)) {
				comp.add(element);
			}
		}
		return comp;
	}

	// put keys from the given set into this set that are not already there
	public void union(MathSet<Key> set) {
		for (Key element : set.content.keySet()) {
			if (!this.contains(element) && set.contains(element)) {
				this.add(element);
			}
		}
	}

	// remove any keys from this set that are not in the given set
	public void intersection(MathSet<Key> set) {
		for (Key element : this.content.keySet()) {
			if (!set.contains(element)) {
				this.delete(element);
			}
		}
	}

	// remove key from the set
	public void delete(Key key) {
		this.content.replace(key, false);
	}

	// is the key in this set?
	public boolean contains(Key key) {
		return this.content.get(key);
	}

	// is the set empty?
	public boolean isEmpty() {
		// replace the throw statement with your implementation
		for (Key element : this.content.keySet()) {
			if (this.content.get(element)) {
				return false;
			}
		}
		return true;
	}

	// number of keys in the set
	public int size() {
		int size = 0;
		for (Key element : this.content.keySet()) {
			if (this.content.get(element)) {
				size += 1;
			}
		}
		return size;
	}
}

