package linearSorting;

import java.util.Arrays;

import abstractSorting.AbstractSorting;

/**
 * The algorithm iterates over the elements of the array, which K is the
 * greatest element, computing a histogram of the number of times each element
 * occurs on it. Then, it performs a cumulative sum computation to determine,
 * for each element, the starting position in the array. Finally, it iterates
 * over the elements again, moving each item into its proper position. This
 * implementation only works to positive Integer elements.
 * 
 * - COMPLEXITY: O(n + k)
 * - IN-PLACE: No
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the counting sort strategy.
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
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (this.inputValidation(array, leftIndex, rightIndex)) {
			Integer maximum = this.getMaximum(array, leftIndex, rightIndex);

			Integer[] counter = new Integer[maximum + 1];
			Arrays.fill(counter, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				Integer index = array[i];
				counter[index]++;
			}

			this.cumulativeSum(counter);

			Integer[] copy = Arrays.copyOf(array, array.length);

			for (int i = rightIndex; i >= leftIndex; i--) {
				Integer value = copy[i];
				Integer index = --counter[value] + leftIndex;
				array[index] = value;
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
	private boolean inputValidation(Integer[] array, int leftIndex, int rightIndex) {
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
			if (leftIndex >= rightIndex) {
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
	 * @return the greatest Integer stored at the array between the leftIndex and
	 *         the rightIndex (inclusive).
	 * 
	 */
	private Integer getMaximum(Integer[] array, int leftIndex, int rightIndex) {
		Integer maximum = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(maximum) > 0) {
				maximum = array[i];
			}
		}

		return maximum;
	}

	/**
	 * This method transforms a Integer array in its cumulative sum. After this
	 * method is invoked, every position of the array will store a Integer that
	 * represents the sum of every Integer stored before it in the array.
	 * 
	 * @param counter
	 *            The array what must become a cumulative sum.
	 * 
	 */
	private void cumulativeSum(Integer[] counter) {
		for (int i = 1; i < counter.length; i++) {
			counter[i] += counter[i - 1];
		}
	}

}
