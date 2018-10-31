package simpleSorts;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order.
 * This means it only needs to find the right position for the current element
 * and insert it there. It will do these insertions until the array is
 * completely sorted.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the insertion sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				int j = i - 1;
				T key = array[i];

				while ((j >= leftIndex) && (array[j].compareTo(key) > 0)) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = key;
			}
		}
	}

}
