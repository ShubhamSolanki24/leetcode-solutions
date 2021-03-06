// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	
    Iterator<Integer> iter;
    Integer Val;

    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        Val = iter.hasNext() ? iter.next() : null;
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
          return Val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer oldNext = Val;
        Val = iter.hasNext() ? iter.next() : null;
        return oldNext; 
	    
	}
	
	@Override
	public boolean hasNext() {
	     return (Val != null); 
	}
}