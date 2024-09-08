public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return null;
        }
        IntList restNewList = incrList(L.rest, x);
        IntList newList = new IntList(L.first + x, restNewList);
        return newList;
    }

    public static IntList incrListIter(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return null;
        }
        IntList newList = new IntList(L.first + x, null);
        IntList newTempList = newList;
        IntList temp = L.rest;
        while (temp != null) {
            newTempList.rest = new IntList(temp.first + x, null);
            newTempList = newTempList.rest;
            temp = temp.rest;
        }
        return newList;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return L;
        }
        L.first = L.first + x;
        dincrList(L.rest, x);
        return L;
    }

    public static IntList dincrListIter(IntList L, int x) {
        IntList temp = L;
        while (temp != null) {
            temp.first += x;
            temp = temp.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
         System.out.println(incrList(L, 3));
         System.out.println(dincrList(L, 3));
    }
}