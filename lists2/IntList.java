public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	/**
	 * if 2 numbers in a row are the same, we add them together and
	 * make one large node. For example:
	 * 1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3
	 * No reverse adding, e.g. 2 -> 1 -> 1 -> 3 becomes 2 -> 2 -> 3 but won't become 4 -> 3
	 * further questions: is reverse adding required? If so, when one number is same as prev and next number, which one to add together?
	 * */
	public void addAdjacent() {
		IntList.addAdjacent(this);
	}

	private static void addAdjacent(IntList p) {
		if (p == null) {
			return;
		}
		while (p.rest != null) {
			if (p.first == p.rest.first) {
				p.first = p.first * 2;
				p.rest = p.rest.rest;
			} else {
				p = p.rest;
			}
		}
	}

	private static void printValues(IntList p){
//		if (p == null) {
//			System.out.println("\n");
//			return;
//		}
		System.out.print(p.first);
		if (p.rest != null) {
			System.out.print(" => ");
			IntList.printValues(p.rest);
		} else {
			System.out.println();
		}
	}

	public void square(int x) {
		IntList.square(this, x);
	}

	private static IntList square(IntList L, int x) {
		if (L == null) {
			L = new IntList(x, null);
			return L;
		}
		L.rest = new IntList(L.first * L.first, L.rest);
		L.rest.rest = square(L.rest.rest, x);
		return L;
	}

	public void squareIter(int x) {
		IntList current = this;
		// record the last node to add at the end.
		// This is a typical way that recording the useful info which is harder to get or calculate when needed
		IntList last = null;
		while (current != null) {
			current.rest = new IntList(current.first * current.first, current.rest);
			last = current.rest;
			current = current.rest.rest;
		}
		last.rest = new IntList(x, null);
	}

	public static void main(String[] args) {
		// for addAdjacent
		IntList L = new IntList(3, null);
		L = new IntList(2, L);
		L = new IntList(1, L);
		L = new IntList(1, L);
		L.addAdjacent();
		printValues(L);

		// for square
		IntList L2 = new IntList(2, null);
		L2 = new IntList(1, L2);
		printValues(L2);
		L2.square(5);
		printValues(L2);
		L2.square(7);
		printValues(L2);

		// for squareIter
		IntList L3 = new IntList(2, null);
		L3 = new IntList(1, L3);
		printValues(L3);
		L3.squareIter(5);
		printValues(L3);
		L3.squareIter(7);
		printValues(L3);
	}
} 