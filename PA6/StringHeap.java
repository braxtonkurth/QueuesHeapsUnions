import java.util.ArrayList;


public class StringHeap {


   private ArrayList<String> heapArray;


   public StringHeap() {
       heapArray = new ArrayList<>();
   }


   public String top() {
       return heapArray.get(0);
   }


   private void swap(int index1, int index2) {
       String temp = heapArray.get(index1);
       heapArray.set(index1, heapArray.get(index2));
       heapArray.set(index2, temp);
   }


   public void insert(String value) { // complete this method
       heapArray.add(value);
   }


   public void extract() { // complete this method
       heapArray.remove(0);
   }


   public static void heapSort(String array[], int arrayLen) throws Exception {
       StringHeap heap = new StringHeap();
       for (String s : array)
           heap.insert(s);
       for (int i = 0; i < arrayLen; i++) {
           array[i] = heap.top();
           heap.extract();
       }
   }


   public int size() {
       return heapArray.size();
   }


   public String toString() {
       return heapArray.toString();
   }
}



