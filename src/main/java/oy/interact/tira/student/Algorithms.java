package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      int n = array.length;
    
      for (int i = 1; i < n; i++) {
          T key = array[i];
          int j = i - 1;
  
          while (j >= 0 && array[j].compareTo(key) > 0) {
              array[j + 1] = array[j];
              j--;
          }
  
          array[j + 1] = key;
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
         T key = array[i];
         int j = i - 1;
 
         while (j >= fromIndex && array[j].compareTo(key) > 0) {
             array[j + 1] = array[j];
             j--;
         }
 
         array[j + 1] = key;
     }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      int n = array.length;

      for (int i = 1; i < n; i++) {
          T key = array[i];
          int j = i - 1;
  
          while (j >= 0 && comparator.compare(array[j], key) > 0) {
              array[j + 1] = array[j];
              j--;
          }
  
          array[j + 1] = key;
      }
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
         T key = array[i];
         int j = i - 1;
 
         while (j >= fromIndex && comparator.compare(array[j], key) > 0) {
             array[j + 1] = array[j];
             j--;
         }
 
         array[j + 1] = key;
     }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      for (int i = 0; i < array.length / 2; i++) {
         swap(array, i, array.length - 1 - i);
      } 
  }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex; i < (fromIndex + toIndex) / 2; i++) {
         swap(array, i, (toIndex - 1 - (i - fromIndex)));
     }
   }

   ///////////////////////////////////////////
   // Swap algorithm
   ///////////////////////////////////////////

   public static <T> void swap(T[] array, int x, int y) {
      T temp = array[x];
      array[x] = array[y];
      array[y] = temp;
  }

   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   //Iteratiivinen versio

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      while (fromIndex <= toIndex) {
         int mid = fromIndex + (toIndex - fromIndex) / 2;

         if (mid < 0 || mid >= fromArray.length) {
            return -1;
        }
 
         int comparison = aValue.compareTo(fromArray[mid]);
 
         if (comparison == 0) {
            return mid;
         } else if (comparison < 0) {
            toIndex = mid - 1;
         } else {
            fromIndex = mid + 1; 
         }
     }
     return -1;
   }

   //Rekursiivinen versio

   /*public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      if (fromIndex <= toIndex) {
         int mid = fromIndex + (toIndex - fromIndex) / 2;

         if (mid < 0 || mid >= fromArray.length) {
            return -1;
         }
  
         int comparison = aValue.compareTo(fromArray[mid]);
  
         if (comparison == 0) {
            return mid;
         } else if (comparison < 0) {
            return binarySearch(aValue, fromArray, fromIndex, mid - 1);
         } else {
            return binarySearch(aValue, fromArray, mid + 1, toIndex);
         }
      }
  
      return -1;
  }*/

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   //Iteratiivinen versio

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      while (fromIndex <= toIndex) {
         int mid = fromIndex + (toIndex - fromIndex) / 2;
 
         if (mid < 0 || mid >= fromArray.length) {
            return -1;
         }
 
         int comparison = comparator.compare(aValue, fromArray[mid]);
 
         if (comparison == 0) {
            return mid;
         } else if (comparison < 0) {
            toIndex = mid - 1;
         } else {
            fromIndex = mid + 1;
         }
      }
 
     return -1;
   }

   //Rekursiivinen versio

   /*public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      if (fromIndex <= toIndex) {
         int mid = fromIndex + (toIndex - fromIndex) / 2;

         if (mid < 0 || mid >= fromArray.length) {
            return -1;
         }
  
         int comparison = comparator.compare(aValue, fromArray[mid]);
  
         if (comparison == 0) {
            return mid;
         } else if (comparison < 0) {
            return binarySearch(aValue, fromArray, fromIndex, mid - 1, Comparator<T> comparator);
         } else {
            return binarySearch(aValue, fromArray, mid + 1, toIndex, Comparator<T> comparator);
         }
      }
  
      return -1;
  }*/

   public static <E extends Comparable<E>> void fastSort(E [] array) {
      //array = mergeSortComparable(array);
      quickSortComparable(array, 0, array.length - 1);
   }

   private static <E extends Comparable<E>> void quickSortComparable(E [] array, int fromIndex, int toIndex) {
      if (fromIndex < toIndex) {
         int i = fromIndex;
         int j = toIndex;
         E pivot = array[(i + j) / 2];
         
         do {
            while (array[i].compareTo(pivot) < 0) i++;
            while (pivot.compareTo(array[j]) < 0) j--;
         
            if (i <= j) {
               swap(array, i, j);
               i++;
               j--;
            }
         
         } while (i <= j);

         quickSortComparable(array, fromIndex, j);
         quickSortComparable(array, i, toIndex);
      } 
   }

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      //array = mergeSortComparator(array, comparator);
      quickSortComparator(array, 0, array.length - 1, comparator);
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      //array = mergeSortComparator(array, fromIndex, toIndex, comparator);
      quickSortComparator(array, fromIndex, toIndex, comparator);
   }

   private static <E> void quickSortComparator(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (fromIndex < toIndex) {
         int i = fromIndex;
         int j = toIndex;
         E pivot = array[(i + j) / 2];

         do {
            while (comparator.compare(array[i], pivot) < 0) i++;
            while (comparator.compare(pivot, array[j]) < 0) j--;

            if (i <= j) {
               swap(array, i, j);
               i++;
               j--;
            }

         } while (i <= j);

         quickSortComparator(array, fromIndex, j, comparator);
         quickSortComparator(array, i, toIndex, comparator);
      } 
   }   

   ///////////////////////////////////////////
   // Mergesort using comparable (not working)
   ///////////////////////////////////////////
/*
   @SuppressWarnings("unchecked")
   private static <E extends Comparable<E>> E[] mergeSortComparable(E [] array) {
      int length = array.length;
      System.out.println(length);
      int mid = length / 2;
      E [] leftArray = (E[]) new Object[mid];
      E [] rightArray = (E[]) new Object[mid];
      if (length == 1) {
         return array;
      } else {
         for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
         }
         for (int j = mid; j < length; j++) {
            int i = 0;
            rightArray[i++] = array[j];
         }

      leftArray = mergeSortComparable(leftArray);
      rightArray = mergeSortComparable(rightArray);
      mergeComparable(leftArray, rightArray, array);
      }

      return array;
   }

   private static <E extends Comparable<E>> void mergeComparable(E [] leftArray, E [] rightArray, E [] array) {
      int leftIndex = 0;
      int rightIndex = 0;
      int arrayIndex = 0;

      while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
         if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
            array[arrayIndex] = leftArray[leftIndex];
            leftIndex++;
         } else {
            array[arrayIndex] = rightArray[rightIndex];
            rightIndex++;
         }
         arrayIndex++;
      }

      while (leftIndex < leftArray.length) {
         array[arrayIndex] = leftArray[leftIndex];
         arrayIndex++;
         leftIndex++;
      }

      while (rightIndex < rightArray.length) {
         array[arrayIndex] = rightArray[rightIndex];
         arrayIndex++;
         rightIndex++;
      }
   }
*/

   ///////////////////////////////////////////
   // Mergesort using comparator (not working)
   ///////////////////////////////////////////

/*
   @SuppressWarnings("unchecked")
   private static <E> E [] mergeSortComparator(E[] array, Comparator<E> comparator) {
      int length = array.length;
      int mid = length / 2;
      E [] leftArray = (E[]) new Object[mid];
      E [] rightArray = (E[]) new Object[mid];
      if (length == 1) {
         return array;
      } else {
         for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
         }
         for (int j = mid; j < length; j++) {
            int i = 0;
            rightArray[i++] = array[j];
         }

      leftArray = mergeSortComparator(leftArray, comparator);
      rightArray = mergeSortComparator(rightArray, comparator);
      mergeComparator(leftArray, rightArray, array, comparator);
      }

      return array;
   }

   private static <E> void mergeComparator(E[] leftArray, E[] rightArray, E[] array, Comparator<E> comparator) {
   int leftIndex = 0;
   int rightIndex = 0;
   int arrayIndex = 0;

   while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
      if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) < 0) {
         array[arrayIndex] = leftArray[leftIndex];
         leftIndex++;
         } else {
         array[arrayIndex] = rightArray[rightIndex];
         rightIndex++;
         }
      arrayIndex++;
      }

   while (leftIndex < leftArray.length) {
      array[arrayIndex] = leftArray[leftIndex];
      arrayIndex++;
      leftIndex++;
      }

   while (rightIndex < rightArray.length) {
      array[arrayIndex] = rightArray[rightIndex];
      arrayIndex++;
      rightIndex++;
      }
   }
*/   

   ///////////////////////////////////////////
   // Mergesort from index to index using comparator (not working)
   ///////////////////////////////////////////

/*
   @SuppressWarnings("unchecked")
   private static <E> E [] mergeSortComparator(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      int length = toIndex - fromIndex;
      int mid = length / 2;
      E [] leftArray = (E[]) new Object[mid];
      E [] rightArray = (E[]) new Object[mid];
      if (length == 1) {
         return array;
      } else {
         for (int i = fromIndex; i < mid; i++) {
            int j = 0;
            leftArray[j++] = array[i];
         }
         for (int i = mid; i < toIndex; i++) {
            int j = 0;
            rightArray[j++] = array[i];
         }

      leftArray = mergeSortComparator(leftArray, comparator);
      rightArray = mergeSortComparator(rightArray, comparator);
      mergeComparator(leftArray, rightArray, array, comparator);
      }

      return array;
   }
*/

}
