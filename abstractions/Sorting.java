package abstractions;

/**
 * A interface for all sorting algorithms. It contains only the signature of the
 * sort method, which must be implemented according to the specific algorithm.
 * 
 */
public interface Sorting<T extends Comparable<T>> {

	/**
	 * It sorts the array in increasing order considering all of its elements.
	 * 
	 * @param array The target array of the sorting algorithm.
	 * 
	 */
	public void sort(T[] array);

}
