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
	 * @param array The array to be modified.
	 * @param i     One of the target positions.
	 * @param j     The other target position.
	 */
	public static void swap(Object[] array, int i, int j) {
		Object copy = array[i];
		array[i] = array[j];
		array[j] = copy;
	}

	/**
	 * This method validates all the parameters received by the sort method. The
	 * array received must not be null or contain less than two elements. Also, the
	 * index parameters given may be suitable to the array.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 * @return the boolean that represents the prameter's validity.
	 * 
	 */
	public static boolean inputValidation(Object[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;

		if (array == null) {
			isValid = false;
		} else if ((leftIndex > rightIndex) || (leftIndex < 0) || (rightIndex < 0)) {
			isValid = false;
		} else if (rightIndex > (array.length - 1)) {
			isValid = false;
		}

		return isValid;
	}

}