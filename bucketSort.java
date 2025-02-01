import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void bucketSort(float[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        // Find minimum and maximum values in the array
        float minValue = arr[0];
        float maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // Initialize buckets
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        List<List<Float>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute input array values into buckets
        for (float value : arr) {
            int bucketIndex = (int) Math.floor((value - minValue) / bucketSize);
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket and place back into the input array
        int currentIndex = 0;
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket); // Use any sorting algorithm here
            for (float value : bucket) {
                arr[currentIndex++] = value;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};
        int bucketSize = 10;

        System.out.println("Original array:");
        for (float value : arr) {
            System.out.print(value + " ");
        }

        bucketSort(arr, bucketSize);

        System.out.println("\nSorted array:");
        for (float value : arr) {
            System.out.print(value + " ");
        }
    }
}
