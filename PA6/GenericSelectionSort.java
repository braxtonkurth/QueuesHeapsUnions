import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class GenericSelectionSort<T> { // A generic class for selection sorting comparable objects

	Comparator<T> comparator; // This is used to compare the objects of the class

	GenericSelectionSort(Comparator<T> comparator) { // Constructor will set the comparator for the specific class
		this.comparator = comparator;
	}

	public void sort(ArrayList<T> content) {
		for (int i = 0; i < content.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < content.size(); j++) {
				T minValue = content.get(minIndex); // get the reference to the object at minIndex
				T currentValue = content.get(j); // get the reference to the object at j
				if (comparator.compare(currentValue, minValue) < 0) { // this checks if currentValue is smaller than minValue
					// < 0 implies currentValue is smaller than minValue
					// = 0 means they are the same
					// > 0 means currentValue is larger than minValue
					minIndex = j;
				}
			}
			// swap contents
			T temp = content.get(minIndex);
			content.set(minIndex, content.get(i));
			content.set(i, temp);
		}
	}
}