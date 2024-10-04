import java.util.ArrayList;
import java.util.PriorityQueue;

public class GenericHeapSort {

	public static void sort(String[] arr, int len) {

		// creates a priority queue using the StringComparator
		PriorityQueue<String> heap = new PriorityQueue<>(new StringComparator());

		for (int i = 0; i < len; i++)
			heap.add(arr[i]);

		int i = 0;
		while (heap.size() > 0) { // as long as the heap is not empty
			String ele = heap.peek(); // get the topmost item
			heap.remove(); // remove the topmost item
			arr[i++] = ele;
		}
	}

	public static void sort(ArrayList<Student> students) {
		// creates a priority queue using the StringComparator
		PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());

		for (int i = 0; i < students.size(); i++)
			heap.add(students.get(i));

		students.clear();
		while (heap.size() > 0) { // as long as the heap is not empty
			Student ele = heap.peek(); // get the topmost item
			heap.remove(); // remove the topmost item
			students.add(ele);
		}
	}
}