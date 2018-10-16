public class ThreeSumMulti {

    public static void main(String[] args) {
        ThreeSumMulti threeSum = new ThreeSumMulti();
        threeSum.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
    }

    public int threeSumMulti(int[] A, int target) {
        long count = 0;
        int left, right, iCount, leftCount, rightCount;
        for (int i = 0; i < A.length - 2; i++) {
            left = i + 1;
            right = A.length - 1;
            while (left < right) {
                if (A[i] + A[left] + A[right] == target) {
                    iCount = 1;
                    leftCount = 1;
                    rightCount = 1;
                    while (i < left && A[i] == A[i + iCount]) {
                        i++;
                        iCount++;
                    }
                    while (left + leftCount < A.length && left < right && A[left] == A[left + leftCount]) {
                        left++;
                        leftCount++;
                    }
                    while (left < right && A[right] == A[right - rightCount]) {
                        right--;
                        rightCount++;
                    }
                    if (A[left] == A[right]) {
                        rightCount = (leftCount + rightCount) / 2;
                        leftCount = rightCount;
                    }
                    count += Math.pow(2, iCount) + Math.pow(2, leftCount) + Math.pow(2, rightCount);
                    left++;
                    right--;
                } else if (A[i] + A[left] + A[right] < target)
                    left++;
                else
                    right--;
            }
        }
        return (int) count;
    }

}
