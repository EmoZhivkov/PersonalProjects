//#include <iostream>
//using namespace std;
//
//void insertionSort(int *arr, int lenght) {
//
//    for (int i = 0; i < lenght; ++i) {
//
//        int key = arr[i];
//        int j = i -1;
//
//        while (j >= 0 && arr[j] > key) {
//
//            arr[j + 1] = arr[j];
//
//            j--;
//        }
//        arr[j + 1] = key;
//    }
//}
//
//void selectionSort(int *arr, int lenght) {
//    for (int i = 0; i < lenght; ++i) {
//
//        int smallest = i;
//
//        for (int j = i + 1; j < lenght; ++j) {
//
//            if (arr[j] < arr[smallest]) {
//
//                smallest = j;
//
//            }
//
//        }
//        swap(arr[i], arr[smallest]);
//    }
//}
//
//void bubbleSort(int *arr, int lenght) {
//
//    for (int i = 0; i < lenght; ++i) {
//
//        for (int j = 0; j < lenght - i - 1; ++j) {
//
//            if (arr[j] > arr[j + 1]) {
//
//               swap(arr[j], arr[j + 1]);
//
//            }
//        }
//    }
//}
//
//int main() {
//    int arr[5] = {1,5,4,2,10};
//    insertionSort(arr, 5);
//
//    for (int i = 0; i < 5; ++i) {
//        cout << arr[i] << endl;
//    }
//
//    return 0;
//}