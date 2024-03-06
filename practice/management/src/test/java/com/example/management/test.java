package com.example.management;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class test {
    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] point : bottomLeft) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }

        for (int[] point : topRight) {
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
        }

        int left = 0;
        int right = Math.min(maxX - minX, maxY - minY);
        long maxArea = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long area = (long) (mid + 1) * (mid + 1);
            boolean found = false;

            for (int i = 0; i < bottomLeft.length; i++) {
                if (bottomLeft[i][0] + mid <= topRight[i][0] &&
                        bottomLeft[i][1] + mid <= topRight[i][1]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxArea = Math.max(maxArea, area);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxArea;
    }
    public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int currentTime = 1;
        Set<Integer> markedIndices = new HashSet<>();
        int []allIndex = new int[nums.length];
        
        while (currentTime <= changeIndices.length) {
            boolean allMarked = true;
            for (int index : changeIndices) {
                if (!markedIndices.contains(index)) {
                    allMarked = false;
                    break;
                }
            }
            if (allMarked) {
                return currentTime;
            }
            markedIndices.add(changeIndices[currentTime]);
            currentTime++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {2,2,0};
        int []changeIndices = {2,2,2,2,3,2,2,1};
        System.out.println(earliestSecondToMarkIndices(nums,changeIndices));
//        int [][]bottomLeft = {{1,1},{2,2},{3,1}};
//        int [][]topRight = {{3,3},{4,4},{6,6}};
//        System.out.println(largestSquareArea(bottomLeft,topRight));
    }
}
