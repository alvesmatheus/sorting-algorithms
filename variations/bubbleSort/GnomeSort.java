package variations.bubbleSort;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * This algorithm applies a modified insertion sort. It compares adjacent
 * elements through the array. Whenever it finds an element out of order, this
 * element will be swapped (with the previous ones) until it is in the proper
 * position. Unlikely the insertion sort, a element will go to its position
 * using several swaps.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the gnome sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			int pivotIndex = leftIndex;

			while (pivotIndex < rightIndex) {
				if (array[pivotIndex].compareTo(array[pivotIndex + 1]) > 0) {
					Utility.swap(array, pivotIndex, pivotIndex + 1);

					if (pivotIndex > leftIndex) {
						pivotIndex -= 2;
					}
				}

				pivotIndex++;
			}
		}
	}

}
