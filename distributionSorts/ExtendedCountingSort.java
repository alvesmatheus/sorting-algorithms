package distributionSorts;

import java.util.Arrays;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * The algorithm iterates over the elements of the array, which K is the
 * greatest element, computing a histogram of the number of times each element
 * occurs on it. Then, it performs a cumulative sum computation to determine,
 * for each element, the starting position in the array. Finally, it iterates
 * over the elements again, moving each item into its proper position. It takes
 * advantage on the traditional counting sort by reducing the size of the
 * counter array to the minimum necessary. This implementation only works to
 * Integer elements.
 * 
 * - COMPLEXITY: O(n + k)
 * - IN-PLACE: No
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the extended counting sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			Integer minimum = this.getMinimum(array, leftIndex, rightIndex);
			Integer maximum = this.getMaximum(array, leftIndex, rightIndex);

			Integer[] counter = new Integer[maximum - minimum + 1];
			Arrays.fill(counter, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				Integer index = array[i] - minimum;
				counter[index]++;
			}

			Integer[] copy = Arrays.copyOf(array, array.length);
			this.getCumulativeSum(counter);

			for (int i = rightIndex; i >= leftIndex; i--) {
				Integer value = copy[i] - minimum;
				Integer index = --counter[value] + leftIndex;
				array[index] = copy[i];
			}
		}

	}

	/**
	 * This method iterates over the array to find the smallest element stored
	 * between leftIndex and rightIndex (inclusive).
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 * @return the smallest Integer stored at the array between the leftIndex and
	 *         the rightIndex (inclusive).
	 * 
	 */
	private Integer getMinimum(Integer[] array, int leftIndex, int rightIndex) {
		Integer minimum = array[rightIndex];
		for (int i = rightIndex; i >= leftIndex; i--) {
			if (array[i].compareTo(minimum) < 0) {
				minimum = array[i];
			}
		}

		return minimum;
	}

	/**
	 * This method iterates over the array to find the greatest element stored
	 * between leftIndex and rightIndex (inclusive).
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
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
	 * @param counter The array what must become a cumulative sum.
	 * 
	 */
	private void getCumulativeSum(Integer[] counter) {
		for (int i = 1; i < counter.length; i++) {
			counter[i] += counter[i - 1];
		}
	}

}
