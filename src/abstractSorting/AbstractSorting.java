package abstractSorting;

/**
 * This abstract class will be used as parent of all the future sorting
 * algorithms implementations produced.
 * 
 */
public abstract class AbstractSorting<T extends Comparable<T>> implements Sorting<T> {

	/**
	 * This method will apply the sorting algorithm on the complete array.
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * 
	 */
	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length - 1);
	}

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing.
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * @param leftIndex
	 *            The index where the sorting should begin.
	 * @param rightIndex
	 *            The index where the sorting should end.
	 * 
	 */
	public abstract void sort(T[] array, int leftIndex, int rightIndex);

}
