package com.testTask;

public class MergeSort<T extends Comparable<T>> {

    private T[] array;

    boolean ascending;

    MergeSort() {

    }

    public T[] getResult() {
        return array;
    }

    public void sort(T[] array, boolean ascending) {
        this.array = array;
        this.ascending = ascending;
        sortMerge(0, array.length - 1);
    }

    private void sortMerge(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            sortMerge(low, mid);
            sortMerge(mid + 1, high);

            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = array[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (ascending) {
                array[k++] = (left[i].compareTo(right[j]) <= 0) ? left[i++] : right[j++];
            } else {
                array[k++] = (left[i].compareTo(right[j]) >= 0) ? left[i++] : right[j++];
            }
        }

        while (i < n1) {
            array[k++] = left[i++];
        }
        while (j < n2) {
            array[k++] = right[j++];
        }
    }

    public static <T> String arrayToString(T[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
