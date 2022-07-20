package alg;

import java.util.Arrays;

public class SortAlgs {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,3,7,2,9,1};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end){
        if(nums == null || start>=end){
            return;
        }
        int key = nums[start]; // 为其找到排序后的位置
        int i = start;
        int j = end;
        while (i<j){
            while (i<j && key<=nums[j]){
                j--;
            }
            if(i<j){
                nums[i] = nums[j];
                nums[j] = key;
            }
            while (i<j && key>nums[i]){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                nums[i] = key;
            }
        }
        quickSort(nums, start, i-1);
        quickSort(nums, j+1, end);
    }
}
