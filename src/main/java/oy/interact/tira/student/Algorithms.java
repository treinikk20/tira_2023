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
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

}
