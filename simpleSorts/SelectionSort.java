package simpleSorts;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * The selection sort algorithm chooses the smallest element of the array and
 * puts it at the first position. Then chooses the second smallest element and
 * puts it in the second position. This process will continue until the array is
 * completely sorted.
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
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
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

}
