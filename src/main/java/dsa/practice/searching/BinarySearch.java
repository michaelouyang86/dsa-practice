package dsa.practice.searching;

public class BinarySearch {

    public boolean searchIteratively(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == target) {
                return true;
            } else if (target < data[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean searchRecursively(int[] data, int target) {
        return searchRecursively(data, target, 0, data.length - 1);
    }

    public boolean searchRecursively(int[] data, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (data[mid] == target) {
            return true;
        } else if (target < data[mid]) {
            return searchRecursively(data, target, left, mid - 1);
        } else {
            return searchRecursively(data, target, mid + 1, right);
        }
    }
}
