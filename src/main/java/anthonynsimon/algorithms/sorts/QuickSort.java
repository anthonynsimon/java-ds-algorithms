package anthonynsimon.algorithms.sorts;

import java.util.Arrays;

public class QuickSort {
  
  public void sort(int[] array) {
    if (array.length < 2) {
      return;
    }
   
    quickSort(array, 0, array.length - 1);
  }
  
  private void quickSort(int[] array, int min, int max) {
    // Base case, partition is of size one or null
    if (min >= max) {
      return;
    }
    
    // Set starting pivot at last position
    int pivot = max;
    int left = min;
    int right = max;
    
    // Repeat until pointers meet
    while (left < right) {
      // Continue until left side swap candidate is found
      while (array[left] < array[pivot]) {
        left++;
      }
      
      // Swap and update pivot index
      swap(array, left, pivot);
      pivot = left;
      
      // Continue until right side swap candidate is found
      while (array[right] > array[pivot]) {
        right--;
      }
      
      // Swap and update pivot index
      swap(array, right, pivot);
      pivot = right;
    }
    
    // Recursively apply quick sort to left and right side of list
    quickSort(array, min, pivot - 1);
    quickSort(array, pivot + 1, max);
  }
    
  
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}