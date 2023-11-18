package homework;

public class BinarySearchInsertion {
    public static void main(String[] args) {
        int Array[] = {1, 3, 5, 7, 9, 11};
        int target = 8, newIndex = findIndex(Array, target);
        if (newIndex >= 0) {
            System.out.println("插入 " + target + " 后的数组为：");
            int newArray[] = insert(Array, target, newIndex);
            for (int num : newArray) {
                System.out.print(num + " ");
            }
        }
    }

    public static int findIndex(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return l;
    }

    public static int[] insert(int[] arr, int target, int index) {
        int result[] = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        result[index] = target;
        for (int i = index + 1; i < result.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }
}
