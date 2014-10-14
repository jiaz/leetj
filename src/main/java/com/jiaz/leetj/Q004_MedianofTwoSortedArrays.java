package com.jiaz.leetj;

// There are two sorted arrays A and B of size m and n respectively. 
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

public class Q004_MedianofTwoSortedArrays {
    private double calcMedian(int[] A, int start, int end) {
        int len = (end - start + 1);
        if (len % 2 == 1) {
            return A[start + len / 2];
        } else {
            return (A[start + len / 2] + A[start + len / 2 - 1]) / 2.0;
        }
    }

    private double findMedian(int[] A, int startA, int endA, int[] B, int startB, int endB) {
        if ((endA - startA + endB - startB) % 2 == 0) {
            if (endA == startA && endB == startB) {
                // special case where there is less than 4 numbers
                return (A[startA] + B[startB]) / 2.0;
            }
            // even numbers, find 2 middle numbers
            int count = 0;
            int first = 0;
            int second = 0;
            int posA = startA;
            int posB = startB + (endB - startB + 1) / 2 - 1;
            int target = 3;
            if (posB > startB) {
                posB--;
                target = 4;
            }
            while (count != target) {
                int num = 0;
                if (posA > endA || (posB <= endB && A[posA] > B[posB])) {
                    num = B[posB];
                    posB++;
                } else {
                    num = A[posA];
                    posA++;
                }
                count++;
                if (count == target - 1) {
                    first = num;
                } else if (count == target) {
                    second = num;
                }
            }
            return (first + second) / 2.0;
        } else {
            // odd numbers, find middle
            if (endA - startA == 1) {
                // 2 numbers in A, find the middle 3 numbers in B and find the middle one
                int count = 0;
                int posA = startA;
                int posB = startB + (endB - startB + 1) / 2 - 1;
                int num = 0;
                while (count != 3) {
                    if (posA > endA || (posB <= endB && A[posA] > B[posB])) {
                        num = B[posB];
                        posB++;
                    } else {
                        num = A[posA];
                        posA++;
                    }
                    count++;
                }
                return num;
            } else {
                // 1 number in A, find the middle 2 numbers in B and find the middle one
                int posB = startB + (endB - startB + 1) / 2 - 1;
                int B1 = B[posB];
                int B2 = B[posB+1];
                if (A[startA] < B1) return B1;
                else if (A[startA] > B2) return B2;
                else return A[startA];
            }
        }
    }

    private double abs(double a) {
        if (a < 0) return -1 * a;
        else return a;
    }

    private int compare(double a, double b) {
        if (abs(a - b) < 0.000001) return 0;
        else if (a > b) return 1;
        else return -1;
    }

    private double recurFindMedian(int[] A, int startA, int endA, int[] B, int startB, int endB) {
        if (endA - startA < 0) return calcMedian(B, startB, endB);
        else if (endA - startA <= 1) return findMedian(A, startA, endA, B, startB, endB);
        else {
            double medA = calcMedian(A, startA, endA);
            double medB = calcMedian(B, startB, endB);
            int compareRes = compare(medA, medB);
            if (compareRes == 0) return medA;
            else if (compareRes > 0) {
                int originalEndA = endA;
                endA = startA + (endA - startA + 1) / 2;
                startB = startB + (originalEndA - endA);
            } else {
                int originalStartA = startA;
                startA = startA + (endA - startA + 1) / 2 - 1;
                if (startA == originalStartA) startA++;
                endB = endB - (startA - originalStartA);
            }
            return recurFindMedian(A, startA, endA, B, startB, endB);
        }
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length == 0 && B.length == 0) return 0;

        if (A.length < B.length) {
            return recurFindMedian(A, 0, A.length - 1, B, 0, B.length - 1);
        } else {
            return recurFindMedian(B, 0, B.length - 1, A, 0, A.length - 1);
        }
    }
}
