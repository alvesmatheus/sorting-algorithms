package utility;

/**
 * Class containing some useful methods for arrays manipulation.
 * 
 */
public class Utility {

	/**
	 * Swaps the contents of two positions in an array. It throws a exception in
	 * case of a null array.
	 *
	 * @param array
	 *            The array to be modified.
	 * @param i
	 *            One of the target positions.
	 * @param j
	 *            The other target position.
	 */
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}