package efficientSorts;

import java.util.Arrays;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list.
 * 
 * - COMPLEXITY: O(nlog(n)) 
 * - IN-PLACE: No 
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the merge sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			this.sort(array, leftIndex, middleIndex);
			this.sort(array, middleIndex + 1, rightIndex);

			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	/**
	 * Using a copy of the original array and the assumption that each half of the
	 * array is already sorted, this method will sort the entire array by comparing
	 * the elements of distinct halves, putting the proper element at its position
	 * in the original array.
	 * 
	 * @param array       The target array of the sorting algorithm.
	 * @param leftIndex   The index where the sorting should begin.
	 * @param middleIndex The index that divides the two halves.
	 * @param rightIndex  The index where the sorting should end.
	 * 
	 */
	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] copy = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int j = leftIndex;
		int k = middleIndex + 1;

		while ((i <= middleIndex) && (k <= rightIndex)) {
			if (copy[i].compareTo(copy[k]) < 0) {
				array[j] = copy[i];
				i++;
			} else {
				array[j] = copy[k];
				k++;
			}
			j++;
		}

		while (i <= middleIndex) {
			array[j] = copy[i];
			i++;
			j++;
		}

		while (k <= middleIndex) {
			array[j] = copy[k];
			j++;
			k++;
		}
	}

}