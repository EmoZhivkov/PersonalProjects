import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(4);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);

    }

    static class MaxHeap {
        int[] arr;
        int size;

        MaxHeap(int n) {
            this.arr = new int[n + 1];
            this.arr[0] = Integer.MAX_VALUE;
            this.size = 1;
        }

        int getMax() {
            int n = this.arr[1];



            return n;
        }

        void insert(int value) {
            this.arr[this.size] = value;
            this.size++;
            heapify();
        }

        void heapify() {
            int i = this.size - 1;
            int current = this.arr[i];
            int parent = this.arr[i/2];

            while (current > parent) {
                swap(i, i/2);
                i /= 2;

                current = this.arr[i];
                parent = this.arr[i/2];
            }
        }

        void swap(int firstIndex, int secondIndex) {
            int first = arr[firstIndex];

            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = first;
        }
    }
}
