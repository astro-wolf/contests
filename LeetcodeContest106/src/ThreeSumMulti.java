/**
 * https://leetcode.com/contest/weekly-contest-106/problems/3sum-with-multiplicity/
 *
 * Given an integer array A, and an integer target, return the number of tuples i, j, k
 * such that i < j < k and A[i] + A[j] + A[k] == target.
 *
 * As the answer can be very large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (A[i], A[j], A[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 3) occurs 2 times;c
 * (2, 3, 3) occurs 2 times.
 *
 * Example 2:
 * Input: A = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 * Note:
 *
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 */
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
