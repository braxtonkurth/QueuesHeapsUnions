import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TestCorrectness {

	public static void testHeapSort() throws Exception {
		System.out.println("*** Test Heap Sort ***\n");
		String[] array = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		System.out.println("Before Sorting: " + Arrays.toString(array));
		StringHeap.heapSort(array, array.length);
		System.out.println("After Sorting:  " + Arrays.toString(array));
	}

	static final String DIJKSTRA1 = "dijkstra1.txt";
	static final String DIJKSTRA2 = "dijkstra2.txt";

	private static void testDijkstra() throws Exception {
		String filePaths[] = { DIJKSTRA1, DIJKSTRA2 };
		for (int j = 0; j < filePaths.length; j++) {
			System.out.println("\n*** Test Dijkstra (" + filePaths[j] + ") ***");
			Dijkstra dijk = new Dijkstra(filePaths[j]);
			for (int i = 0; i < dijk.numVertices; i++) {
				dijk.execute(i);
				System.out.println("\nDistance array (from v" + i + "): "
						+ Arrays.toString(dijk.distance).replaceAll("" + Integer.MAX_VALUE, "infty"));
				System.out.println("Parent array (from v" + i + "):   "
						+ Arrays.toString(dijk.parent).replaceAll("" + Integer.MAX_VALUE, "infty"));
			}
		}
	}
	
	private static void testUnionFind() {
		UnionFind uf = new UnionFind(16);
		System.out.println("Initial sets are 0-15\n");
		for (int i = 0; i < 15; i += 4) {
			System.out.printf("UNION(%d,%d)%n", i, i + 1);
			uf.doUnion(i, i + 1);
		}
		System.out.println();
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(0,5)");
		System.out.println("UNION(10,12)");
		System.out.println("UNION(0,10)\n");
		uf.doUnion(0, 5);
		uf.doUnion(10, 12);
		uf.doUnion(0, 10);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(6,8)");
		System.out.println("UNION(8,5)\n");
		uf.doUnion(6, 8);
		uf.doUnion(8, 5);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
	}

	private static void testKruskal() throws FileNotFoundException {
		String MST_GRAPH_PATH = "mst_graph.txt";
		Kruskal kruskal = new Kruskal(MST_GRAPH_PATH);
		ArrayList<Edge> mst = kruskal.execute();
		int mstWeight = 0;
		for (Edge e : mst)
			mstWeight += e.weight;
		System.out.printf("MST has weight %d%nThe edges are: %s", mstWeight, mst);
	}

	public static void stringSort() {
		System.out.println("*** String Selection Sort ***\n");
		String arr[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		ArrayList<String> strings = new ArrayList<String>();
		for (String str : arr)
			strings.add(str);
		GenericSelectionSort<String> stringSelectionSort = new GenericSelectionSort<>(new StringComparator());

		System.out.print("Original Order: " + strings);
		stringSelectionSort.sort(strings);
		System.out.print("\nAfter Sorting:  " + strings);
		System.out.println("\n");
	}

	public static void studentSort() {
		System.out.println("*** Student Selection Sort ***\n");

		ArrayList<Student> students = new ArrayList<>();

		students.add(new Student("B", 88));
		students.add(new Student("I", 77));
		students.add(new Student("K", 77));
		students.add(new Student("D", 87));
		students.add(new Student("E", 83));
		students.add(new Student("J", 88));
		students.add(new Student("F", 78));
		students.add(new Student("G", 93));
		students.add(new Student("H", 91));
		students.add(new Student("C", 77));
		students.add(new Student("A", 78));

		System.out.print("Original Order: " + students);

		// Create selection sort instance for sorting Students using the StudentComparator
		GenericSelectionSort<Student> studentSelectionSort = new GenericSelectionSort<>(new StudentComparator());

		studentSelectionSort.sort(students);
		System.out.print("\nAfter Sorting:  " + students);
	}

	private static void studentsHeapSort() {
		System.out.println("\n*** Student Heap Sort ***\n");
		ArrayList<Student> students = new ArrayList<>();

		students.add(new Student("B", 88));
		students.add(new Student("I", 77));
		students.add(new Student("K", 77));
		students.add(new Student("D", 87));
		students.add(new Student("E", 83));
		students.add(new Student("J", 88));
		students.add(new Student("F", 78));
		students.add(new Student("G", 93));
		students.add(new Student("H", 91));
		students.add(new Student("C", 77));
		students.add(new Student("A", 78));

		System.out.println("Original Order: " + students);
		GenericHeapSort.sort(students);
		System.out.println("After Sorting:  " + students);
	}

	static void stringHeapSort() {
		System.out.println("\n*** String Heap Sort ***\n");
		String arr[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		System.out.println("Original array: " + Arrays.toString(arr));
		GenericHeapSort.sort(arr, arr.length);
		System.out.println("After sorting:  " + Arrays.toString(arr));
	}

	public static void main(String[] args) throws Exception {
//		stringSort();
//		studentSort();
//		System.out.println();
//		stringHeapSort();
//		studentsHeapSort();
//		System.out.println();

		testHeapSort();
		testDijkstra();
		System.out.println("\n*** Union-Find ***\n");
		testUnionFind();
		System.out.println("\n*** Kruskal ***\n");
		testKruskal();
	}
}