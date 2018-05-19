package simpleSorting;

import abstractSorting.AbstractSorting;
import utility.Utility;

/**
 * The selection sort algorithm chooses the smallest element of the array and
 * puts it at the first position. Then chooses the second smallest element and
 * puts it in the second position. This process will continue until the array
 * is completely sorted.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the selection sort strategy.
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * @param leftIndex
	 *            The index where the sorting should begin.
	 * @param rightIndex
	 *            The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		// Only arrays that go through all validations will be sorted.
		if (this.inputValidation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i < rightIndex; i++) {
				int indexMinimum = i;

				for (int j = (i + 1); j <= rightIndex; j++) {
					if (array[j].compareTo(array[indexMinimum]) < 0) {
						indexMinimum = j;
					}
				}
				Utility.swap(array, i, indexMinimum);
			}
		}

	}

	/**
	 * This method validates all the parameters received by the sort method. The
	 * array received must not be null or contain less than two elements. Also, the
	 * index parameters given may be suitable to the array.
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * @param leftIndex
	 *            The index where the sorting should begin.
	 * @param rightIndex
	 *            The index where the sorting should end.
	 * 
	 * @return the boolean that represents the prameter's validity.
	 * 
	 */
	private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;

		// A null can't be sorted.
		if (array == null) {
			isValid = false;
		}

		// Arrays containing less than two elements don't need to be sorted.
		else if (array.length < 2) {
			isValid = false;
		}

		else {
			// Prevent misuse of indexes parameters.
			if (leftIndex > rightIndex) {
				isValid = false;
			}

			// Prevent attempts to access invalid indexes.
			if (leftIndex < 0) {
				isValid = false;
			}
			
			if (rightIndex < 0) {
				isValid = false;
			}
			
			if (rightIndex > (array.length - 1)) {
				isValid = false;
			}
		}

		return isValid;
	}

}
