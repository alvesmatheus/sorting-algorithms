package selectionSortVariations;

import abstractSorting.AbstractSorting;
import utility.Utility;

/**
 * A ternary array is an array that stores three different same-type elements,
 * where any of them must appear no less than one time. This algorithm is based
 * on the selection sort strategy and sorts only ternary arrays. It will find
 * the smallest element stored and move it and every element equal to it to the
 * beginning of the array. It does the opposite to the maximum element and its
 * equivalents, moving them to the end of the array. After this, the ternary
 * array will be completely sorted.
 * 
 * - COMPLEXITY: O(n)
 * - IN-PLACE: Yes
 * - STABLE: No
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class TernarySelectionSorting<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements or
	 * more than three different elements. If leftIndex and/or rightIndex are
	 * outside the array limits, this method will do absolutely nothing. It
	 * implements the selection sort strategy to a ternary array.
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
	public void sort(T[] ternaryArray, int leftIndex, int rightIndex) {
		if (this.inputValidation(ternaryArray, leftIndex, rightIndex)) {

			T minimumElement = this.getMinimum(ternaryArray, leftIndex, rightIndex);
			T maximumElement = this.getMaximum(ternaryArray, leftIndex, rightIndex);

			int k = leftIndex;
			int l = rightIndex;

			for (int i = leftIndex; i <= rightIndex; i++) {
				if (ternaryArray[i].compareTo(minimumElement) == 0) {
					Utility.swap(ternaryArray, i, k);
					k++;
				}
			}

			for (int i = k; i <= l; i++) {
				if (ternaryArray[i].compareTo(maximumElement) == 0) {
					Utility.swap(ternaryArray, i, l);
					l--;
				}
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

	/**
	 * This method iterates over the array to find the smallest element stored
	 * between leftIndex and rightIndex (inclusive).
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * @param leftIndex
	 *            The index where the sorting should begin.
	 * @param rightIndex
	 *            The index where the sorting should end.
	 * 
	 * @return the smallest element stored at the array between the leftIndex and
	 *         the rightIndex (inclusive).
	 * 
	 */
	public T getMinimum(T[] ternaryArray, int leftIndex, int rightIndex) {
		T minimumElement = ternaryArray[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (ternaryArray[i].compareTo(minimumElement) < 0) {
				minimumElement = ternaryArray[i];
			}
		}

		return minimumElement;
	}

	/**
	 * This method iterates over the array to find the greatest element stored
	 * between leftIndex and rightIndex (inclusive).
	 * 
	 * @param array
	 *            The target array of the sorting algorithm.
	 * @param leftIndex
	 *            The index where the sorting should begin.
	 * @param rightIndex
	 *            The index where the sorting should end.
	 * 
	 * @return the greatest element stored at the array between the leftIndex and
	 *         the rightIndex (inclusive).
	 * 
	 */
	public T getMaximum(T[] ternaryArray, int leftIndex, int rightIndex) {
		T maximumElement = ternaryArray[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (ternaryArray[i].compareTo(maximumElement) > 0) {
				maximumElement = ternaryArray[i];
			}
		}

		return maximumElement;
	}

}