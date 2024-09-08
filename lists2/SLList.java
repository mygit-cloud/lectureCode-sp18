 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	private static void lectureQuestion() {
		SLList L = new SLList();
		// IntNode n = IntNode(5, null);
	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** creates an SLList with those integers */
	public SLList(int[] values) {
		sentinel = new IntNode(63, null);
		IntNode temp = sentinel;
		for (int i = 0; i < values.length; i++) {
			temp.next = new IntNode(values[i], null);
			temp = temp.next;
		}
		size = values.length;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	public void deleteFirst() {
		if (sentinel.next != null) {
			sentinel.next = sentinel.next.next;
			size -= 1;
		}
	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
// 		SLList L = new SLList(30);
// 		L.addLast(20);
// 		System.out.println(L.size());
//		L.deleteFirst();
//		System.out.println(L.size());
		int[] initValues = new int[]{2, 5, 1, 0};
		SLList L = new SLList(initValues);
		System.out.println(L.size());
 	}
}