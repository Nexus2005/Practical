import java.util.*;

public class QuickSort {

    // Partition Method
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Deterministic Quick Sort
    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // Randomized Quick Sort
    static void randomizedQuickSort(int arr[], int low, int high) {

        if (low < high) {

            // Select random pivot
            Random rand = new Random();
            int randomIndex = low + rand.nextInt(high - low + 1);

            int temp = arr[randomIndex];
            arr[randomIndex] = arr[high];
            arr[high] = temp;

            int p = partition(arr, low, high);

            randomizedQuickSort(arr, low, p - 1);
            randomizedQuickSort(arr, p + 1, high);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
        }

        // Copy original array
        int a[] = arr.clone();
        int b[] = arr.clone();

        // Deterministic Quick Sort
        long start = System.nanoTime();

        quickSort(a, 0, n - 1);

        long end = System.nanoTime();

        System.out.println("\nDeterministic Quick Sort:");
        System.out.println("Sorted Array: " + Arrays.toString(a));
        System.out.println("Execution Time: " + (end - start) + " ns");

        // Randomized Quick Sort
        start = System.nanoTime();

        randomizedQuickSort(b, 0, n - 1);

        end = System.nanoTime();

        System.out.println("\nRandomized Quick Sort:");
        System.out.println("Sorted Array: " + Arrays.toString(b));
        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}


/*
Enter number of elements: 5
Enter element: 50
Enter element: 20
Enter element: 40
Enter element: 10
Enter element: 30

Deterministic Quick Sort:
Sorted Array: [10, 20, 30, 40, 50]
Execution Time: ... ns

Randomized Quick Sort:
Sorted Array: [10, 20, 30, 40, 50]
Execution Time: ... ns


javac QuickSort.java
java QuickSort
*/